package br.edu.ifpe.ptmd.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class DoctorRegisterDto extends UserRegisterDto {

    @NotBlank(message = "campo obrigatorio")
    private String CRM;

    public String getCRM() {
        return CRM;
    }
}
