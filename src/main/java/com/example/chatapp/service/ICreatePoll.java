package com.example.chatapp.service;

import com.example.chatapp.model.Poll;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface ICreatePoll {
    ResponseEntity<?>save(Poll poll);
    ResponseEntity<?> deletePoll(Poll poll);
    List<Poll> get (String name,
                    Boolean activity, Date date1,
                    Date date2,
                    String sort,
                    String sortBy);
}
