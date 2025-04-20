package br.edu.ifpe.ptmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Managers")
public class Manager extends User{
    public Manager(String nome, String cpf, String email, String password, AcessLevel accessLevel) {
        super(nome, cpf, email, password, accessLevel);
    }
}
