package br.edu.ifpe.ptmd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "doctor")
@NoArgsConstructor
public class Doctor extends User{

    @Column(unique = true, nullable = false)
    public String CRM;

    public Doctor(String nome, String cpf, String email, String password, AcessLevel accessLevel, String CRM) {
        super(nome, cpf, email, password, accessLevel);
        this.CRM = CRM;
    }
}
