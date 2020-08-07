package org.launchcode.goalsavingsapp.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotNull
    @NotBlank(message="Must not be blank")
    @Size(min=3, max=20, message="Username must be between 3 and 20 characters")
    private String username;

    @NotNull
    @NotBlank(message="Must not be blank")
    @Size(min=6, max=30, message="Username must be between 6 and 30 characters")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
