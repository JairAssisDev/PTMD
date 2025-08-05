package br.edu.ifpe.ptmd.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.io.IOException;
import java.util.Base64;

public record ClinicalAssessmentImageDTO(
        @NotBlank String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
        String cpf,

        @NotBlank String imageBase64
) {

}
