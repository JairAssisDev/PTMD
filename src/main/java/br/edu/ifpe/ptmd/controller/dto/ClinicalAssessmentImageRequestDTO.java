package br.edu.ifpe.ptmd.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

public record ClinicalAssessmentImageRequestDTO(
        @NotBlank String nome,

        @NotBlank
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos numéricos")
        String cpf,

        @NotNull MultipartFile file
) {}
