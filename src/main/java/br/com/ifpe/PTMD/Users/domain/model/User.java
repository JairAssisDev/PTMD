package br.com.ifpe.PTMD.Users.domain.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User implements UserDetails{

    public User(){}

    public User(String nome , String cpf, String email, String password,AcessLevel accessLevel ) {
        this.email = email;
        this.password = password;
        this.nome  = nome;
        this.cpf = cpf;
        this.acessLevel = accessLevel;
    }


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    private String cpf;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "acess_level")
    @Enumerated(EnumType.STRING)
    private AcessLevel acessLevel;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        switch (acessLevel){
            case MANAGER:
                authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
            case DOCTOR:
                authorities.add(new SimpleGrantedAuthority("ROLE_DOCTOR"));
                break;
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
}
