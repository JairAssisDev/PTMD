package br.edu.ifpe.ptmd.controller.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {
    @NotBlank(message = "campo obrigatorio")
    private String nome;

//    @CPF(message = "CPF inválido")
    private String cpf;

    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "campo obrigatorio")
    private String password;
}
