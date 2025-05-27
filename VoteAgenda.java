package com.Shareholder.Vote.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.Shareholder.Vote.dto.OptionResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "vote_Agenda")
public class VoteAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id")
    private Long eventId;



    @ManyToOne
    @JoinColumn(name = "shareholder_id")
    private Shareholder shareholder;


    @ManyToOne
    @JoinColumn(name = "option_id")
    private VotingOption option;

    @Column(name = "share_weight", nullable = false)
    private Double shareWeight;

    @CreationTimestamp
    @Column(name = "timestamp")
    private LocalDateTime timestamp;



    @ManyToOne
    @JoinColumn(name = "assisting_employee_id")
    @JsonIgnoreProperties({ "password" })
    private AppUser  assistingEmployeeId;

    @Column(name = "booth_number")
    private String boothNumber; // NULL for remote voting

    @Column(name = "voting_token_id")
    private String votingTokenId; // NULL for booth voting

    @Column(name = "ip_address")
    private String ipAddress; // For remote voting

    @Column(name = "user_agent")
    private String userAgent; // For remote voting

    // Constructors
    public VoteAgenda() {
    }

    // Constructor for agenda voting
    public VoteAgenda(Long eventId, Shareholder shareholder, VotingOption option, Double shareWeight) {
        this.eventId = eventId;
        this.shareholder = shareholder;
        this.option = option;
        this.shareWeight = shareWeight;
    }

    public VoteAgenda(Long eventId, String title, double totalVotes, List<OptionResult> results) {

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Shareholder getShareholder() {
        return shareholder;
    }

    public void setShareholder(Shareholder shareholder) {
        this.shareholder = shareholder;
    }

    public VotingOption getOption() {
        return option;
    }

    public void setOption(VotingOption option) {
        this.option = option;
    }

    public Double getShareWeight() {
        return shareWeight;
    }

    public void setShareWeight(Double shareWeight) {
        this.shareWeight = shareWeight;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Getters and setters for new fields

    public AppUser getAssistingEmployeeId() {
        return assistingEmployeeId;
    }

    public void setAssistingEmployeeId(AppUser assistingEmployeeId) {
        this.assistingEmployeeId = assistingEmployeeId;
    }

    public String getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(String boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getVotingTokenId() {
        return votingTokenId;
    }

    public void setVotingTokenId(String votingTokenId) {
        this.votingTokenId = votingTokenId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }





}
