package com.discordance.discordance.repository;


import com.discordance.discordance.domain.Result;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaResultRepository implements ResultRepository {

    private final EntityManager em;


    @Override
    public Optional<Result> findById(Long id) {
        return Optional.ofNullable(em.find(Result.class, id));
    }

    @Override
    public Optional<Result> findByValue(String value) {
        return Optional.ofNullable(
                em.createQuery("SELECT r FROM Result r WHERE value = :value", Result.class)
                .setParameter("value", value)
                .getSingleResult()
        );
    }
}
