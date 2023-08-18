package com.discordance.discordance.repository;

import com.discordance.discordance.domain.Question;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaQuestionRepository implements QuestionRepository {

    private final EntityManager em;


    @Override
    public List<Question> findAll() {
        return em.createQuery("SELECT q FROM Question q",Question.class)
                .getResultList();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.ofNullable(em.find(Question.class, id));
    }
}
