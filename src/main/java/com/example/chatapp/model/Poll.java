package com.example.chatapp.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "poll")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "poll_name",nullable = false)
    private String pollName;

    @Column(name = "start_date",nullable = false)
    private Date startDate;

    @Column(name = "end_date",nullable = false)
    private Date endDate;

    @Column(name = "activity",nullable = false)
    private Boolean activity;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pollId")
    private List<PollQuestions> pollQuestions;

    public Poll() {

    }
    public Poll(Long id,String pollName, Date startDate, Date endDate, Boolean activity, List<PollQuestions> pollQuestions) {
        this.id = id;
        this.pollName = pollName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activity = activity;
        this.pollQuestions = pollQuestions;
    }

    public List<PollQuestions> getPollQuestions() {
        return pollQuestions;
    }

    public void setPollQuestions(List<PollQuestions> pollQuestions) {
        this.pollQuestions = pollQuestions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getActivity() {
        return activity;
    }

    public void setActivity(Boolean activity) {
        this.activity = activity;
    }
}
