package br.com.ifpe.PTMD.Users.application.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDTO {
    @NotBlank
    public String email;
    @NotBlank
    public String password;
}
