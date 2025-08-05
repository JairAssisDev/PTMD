package br.edu.ifpe.ptmd.model;

public enum Classification {
    NORMAL("NORMAL"),ANORMAL("ANORMAL");
    public final String role;
    Classification(String role){
        this.role = role;
    }
}
