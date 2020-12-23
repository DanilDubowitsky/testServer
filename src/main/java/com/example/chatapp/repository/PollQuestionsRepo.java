package com.example.chatapp.repository;

import com.example.chatapp.model.PollQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollQuestionsRepo extends JpaRepository<PollQuestions,Long> {

}
