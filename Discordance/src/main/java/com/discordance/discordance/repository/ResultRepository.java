package com.discordance.discordance.repository;

import com.discordance.discordance.domain.Result;

import java.util.Optional;

public interface ResultRepository {

    Optional<Result> findById(Long id);
    Optional<Result> findByValue(String value);
}
