package br.edu.ifpe.ptmd.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PredictionDTO(
        @JsonProperty("class") String className,
        @JsonProperty("Probabilidade") double probabilidade,
        @JsonProperty("MultClass") String multClass,
        @JsonProperty("ProbabilidadeMultClass") String probabilidadeMultClass
) {}
