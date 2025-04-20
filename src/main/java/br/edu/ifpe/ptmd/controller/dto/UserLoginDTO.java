package br.edu.ifpe.ptmd.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserLoginDTO {
    @Email(message = "Email inválido")
    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
