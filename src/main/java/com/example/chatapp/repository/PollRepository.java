package com.example.chatapp.repository;

import com.example.chatapp.model.Poll;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PollRepository extends JpaRepository<Poll,Long> {

    List<Poll> findByPollName(String name, Sort sort);
    List<Poll> findByActivity(Boolean activity,Sort sort);
    List<Poll> findByStartDateAfterAndEndDateBefore(Date date,Date date1, Sort sort);

}
