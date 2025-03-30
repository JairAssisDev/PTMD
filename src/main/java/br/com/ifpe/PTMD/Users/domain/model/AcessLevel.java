package br.com.ifpe.PTMD.Users.domain.model;

public enum AcessLevel {
    DOCTOR("DOCTOR"),MANAGER("MANAGER");
    public final String level;
    AcessLevel(String level){
        this.level = level;
    }
}
