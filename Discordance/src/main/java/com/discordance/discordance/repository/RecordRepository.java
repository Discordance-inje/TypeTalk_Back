package com.discordance.discordance.repository;

import java.util.List;
import java.util.Optional;

public interface RecordRepository {

    Long count();
    Optional<Record> findById(Long id);
    Record record(Record record);
    List<Record> findAll();
}
