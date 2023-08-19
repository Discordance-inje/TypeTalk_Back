package com.discordance.discordance.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class ResultRequest {

    @NotBlank(message = "value must be provided")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
