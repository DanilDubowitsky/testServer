package com.example.chatapp.model;

import javax.persistence.*;

@Entity
@Table(name = "poll_questions")
public class PollQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long id;

    @Column(name = "question_text",nullable = false)
    private String questionText;

    @Column(name = "method",nullable = false)
    private Integer method;

    @Column(name = "poll_id")
    private Long pollId;

    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long pollId) {
        this.pollId = pollId;
    }

    public PollQuestions() {

    }

    public PollQuestions(String questionText, Integer method) {
        this.questionText = questionText;
        this.method = method;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }
}
