package com.discordance.discordance.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @ManyToOne @JoinColumn(name = "result_id")
    private Result result;

    private LocalDateTime day;


    public Record() {
    }

    public Record(Result result) {
        this.result = result;
        this.day = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Result getResult() {
        return result;
    }

    public LocalDateTime getDay() {
        return day;
    }

}
