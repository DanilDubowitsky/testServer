package com.example.chatapp.service;

import com.example.chatapp.model.Poll;
import com.example.chatapp.model.PollQuestions;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPollQuestions {

    ResponseEntity<?> addPollQuestions(List<PollQuestions> pollQuestions);
    ResponseEntity<?> changePollQuestions(List<PollQuestions> pollQuestions);
    ResponseEntity<?> deletePollQuestions(List<PollQuestions> pollQuestions);



}
