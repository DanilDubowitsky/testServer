package com.example.chatapp.service.interface_impl;

import com.example.chatapp.model.Poll;
import com.example.chatapp.model.PollQuestions;
import com.example.chatapp.repository.PollQuestionsRepo;
import com.example.chatapp.service.IPollQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollQuestionsImpl implements IPollQuestions {
    PollQuestionsRepo pollQuestionsRepo;

    @Autowired
    public PollQuestionsImpl(PollQuestionsRepo pollQuestionsRepo){
        this.pollQuestionsRepo = pollQuestionsRepo;
    }

    @Override
    public ResponseEntity<?> addPollQuestions(List<PollQuestions> pollQuestions) {
        for(int i=0;i<pollQuestions.size();i++){
            pollQuestionsRepo.save(pollQuestions.get(i));
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> changePollQuestions(List<PollQuestions> pollQuestions) {
        for(int i=0;i<pollQuestions.size();i++){
            pollQuestionsRepo.save(pollQuestions.get(i));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deletePollQuestions(List<PollQuestions> pollQuestions) {
        for(int i = 0;i<pollQuestions.size();i++){
            Optional<PollQuestions> pollQuestions1 = pollQuestionsRepo.findById(pollQuestions.get(i).getId());
            pollQuestionsRepo.delete(pollQuestions1.get());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
