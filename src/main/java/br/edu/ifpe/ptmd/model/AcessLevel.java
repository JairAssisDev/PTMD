package br.edu.ifpe.ptmd.model;

import lombok.Getter;

@Getter
public enum AcessLevel {
    DOCTOR("DOCTOR"),MANAGER("MANAGER");
    public final String role;
    AcessLevel(String role){
        this.role = role;
    }
}
