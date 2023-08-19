package com.discordance.discordance.repository;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import com.discordance.discordance.domain.Record;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaRecordRepository implements RecordRepository{

    private final EntityManager em;


    @Override
    public Long count() {
        return (Long) em.createQuery("SELECT COUNT(r) FROM Record r")
                .getSingleResult();
    }

    @Override
    public Optional<Record> findById(Long id) {
        return Optional.ofNullable(em.find(Record.class, id));
    }

    @Override
    public Record record(Record record) {
        em.persist(record);
        return record;
    }

    @Override
    public List<Record> findAll() {
        return em.createQuery("SELECT r FROM Record r",Record.class)
                .getResultList();
    }
}
