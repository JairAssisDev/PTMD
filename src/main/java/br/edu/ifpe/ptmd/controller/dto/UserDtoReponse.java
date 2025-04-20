package br.edu.ifpe.ptmd.controller.dto;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UserDtoReponse {

    public String username;

    public UUID userId;

    public String token;
}