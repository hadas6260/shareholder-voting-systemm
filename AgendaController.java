package com.votee.votee.controller;

import com.votee.votee.dto.AgendaDTO;
import com.votee.votee.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    // CREATE
    @PostMapping("/create")
    public String createAgenda(@RequestBody AgendaDTO agendaDTO) {
        return agendaService.createAgenda(agendaDTO);
    }

    // READ ALL
    @GetMapping("/all")
    public List<AgendaDTO> getAllAgendas() {
        return agendaService.getAllAgendas();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public AgendaDTO getAgendaById(@PathVariable Long id) {
        return agendaService.getAgendaById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAgenda(@PathVariable Long id, @RequestBody AgendaDTO agendaDTO) {
        try {
            String result = agendaService.updateAgenda(id, agendaDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace(); // Log full stack trace here
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error updating agenda: " + e.getMessage());
        }
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteAgenda(@PathVariable Long id) {
        return agendaService.deleteAgenda(id);
    }
}
