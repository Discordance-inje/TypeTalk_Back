package com.discordance.discordance.controller.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginForm {
    @NotEmpty
    private String studentId;
    @NotEmpty
    private String password;
}
