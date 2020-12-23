package com.example.chatapp.controller;

import com.example.chatapp.model.Poll;
import com.example.chatapp.model.PollQuestions;
import com.example.chatapp.repository.PollQuestionsRepo;
import com.example.chatapp.repository.PollRepository;
import com.example.chatapp.service.ICreatePoll;
import com.example.chatapp.service.interface_impl.CreatePollServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/poll")
public class CreatePollController {
    CreatePollServiceImpl createPollService;

    @Autowired
    public CreatePollController(CreatePollServiceImpl createPollService){
        this.createPollService = createPollService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Poll poll){
        ResponseEntity<?> responseEntity = createPollService.save(poll);
        return responseEntity;
    }

    @PutMapping("/change")
    public ResponseEntity<?> change(@RequestBody Poll poll){
        ResponseEntity<?> responseEntity = createPollService.save(poll);
        return responseEntity;
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Poll poll){
        ResponseEntity<?> responseEntity = createPollService.deletePoll(poll);
        return responseEntity;
    }

    @GetMapping("/get")
    public List<Poll> getPolls (@RequestParam(value = "name",required = false) String name,
                                @RequestParam(value = "activity",required = false) Boolean activity,
                                @RequestParam(value = "start_date",required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") Date date1,
                                @RequestParam(value = "end_date",required = false)@DateTimeFormat(pattern = "dd.MM.yyyy")Date date2,
                                @RequestParam(value = "sort",required = true) String sort,
                                @RequestParam(value = "sort_by",required = true) String sortBy
    ){
       return createPollService.get(name,activity,date1,date2,sort,sortBy);
    }
}
