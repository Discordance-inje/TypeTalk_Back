package com.discordance.discordance.repository;

import com.discordance.discordance.domain.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    List<Question> findAll();
    Optional<Question> findById(Long id);
}
