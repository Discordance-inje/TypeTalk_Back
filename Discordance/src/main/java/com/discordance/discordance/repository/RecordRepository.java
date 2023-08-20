package com.discordance.discordance.repository;

import java.util.List;
import java.util.Optional;
import com.discordance.discordance.domain.Record;

public interface RecordRepository {

    Long count();
    Optional<Record> findById(Long id);
    Record record(Record record);
    List<Record> findAll();
}
