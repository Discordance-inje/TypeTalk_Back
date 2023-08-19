package com.discordance.discordance.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.time.LocalDateTime;

@JsonSerialize
@Getter
public class RecordVO {

    private String value;
    private LocalDateTime day;

    public RecordVO(String value, LocalDateTime day) {
        this.value = value;
        this.day = day;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

}
