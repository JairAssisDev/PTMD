package br.edu.ifpe.ptmd.model;

public enum ClassificationMultiClass {
    AOM("AOM"),CSOM("CSOM"),EARMAX("EARMAX"), EXTERNALEARINFECTIONS("EXTERNALEARINFECTIONS"), TYMPANOSKLEROS("TYMPANOSKLEROS");
    public final String name;
    ClassificationMultiClass(String name){
        this.name = name.toUpperCase();
    }
}
