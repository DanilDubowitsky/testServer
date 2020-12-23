package com.example.chatapp.controller;

import com.example.chatapp.model.PollQuestions;
import com.example.chatapp.repository.PollQuestionsRepo;
import com.example.chatapp.service.interface_impl.PollQuestionsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/questions")
public class CreateQuestionsController {
    PollQuestionsImpl pollQuestionsImpl;
    @Autowired
    public CreateQuestionsController (PollQuestionsImpl pollQuestionsImpl){
       this.pollQuestionsImpl = pollQuestionsImpl;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addQuestions(@RequestBody List<PollQuestions> pollQuestions){
        ResponseEntity<?> responseEntity = pollQuestionsImpl.addPollQuestions(pollQuestions);
        return responseEntity;
    }
    @PutMapping("/change")
    public ResponseEntity<?> changeQuestions(@RequestBody List<PollQuestions> pollQuestions){
        ResponseEntity<?> responseEntity = pollQuestionsImpl.changePollQuestions(pollQuestions);
        return responseEntity;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody List<PollQuestions> pollQuestions){
        ResponseEntity<?> responseEntity = pollQuestionsImpl.deletePollQuestions(pollQuestions);
        return responseEntity;
    }

}
