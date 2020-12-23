package com.example.chatapp.service.interface_impl;

import com.example.chatapp.model.Poll;
import com.example.chatapp.repository.PollRepository;
import com.example.chatapp.service.ICreatePoll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Service
public class CreatePollServiceImpl implements ICreatePoll {
    PollRepository pollRepository;

    @Autowired
    public CreatePollServiceImpl(PollRepository pollRepository){
        this.pollRepository = pollRepository;
    }

    @Override
    public ResponseEntity<?> save(Poll poll) {
        pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePoll(Poll poll) {
        pollRepository.delete(poll);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public List<Poll> get(String name,
                          Boolean activity,
                          Date date1,
                          Date date2,
                          String sort,
                          String sortBy) {
        List<Poll> myPolls;
        Sort.Direction sort1;
        String sortBy1 = sortBy;
        if(sort.equals("ASC"))
            sort1 = Sort.Direction.ASC;
        else
            sort1 = Sort.Direction.DESC;
        if(name != null) {
            myPolls = pollRepository.findByPollName(name, Sort.by(sort1, sortBy1));
        }
        else if(activity!=null){
            myPolls = pollRepository.findByActivity(activity, Sort.by(sort1, sortBy1));
        }
        else if(date1!=null){
            myPolls = pollRepository.findByStartDateAfterAndEndDateBefore(date1,date2,Sort.by(sort1,sortBy1));
        }
        else{
            myPolls = pollRepository.findAll(Sort.by(sort1,sortBy1));
        }
        return myPolls;
    }
}
