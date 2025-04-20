package br.edu.ifpe.ptmd.repository;

import br.edu.ifpe.ptmd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<User, UUID> {
    UserDetails findByLogin(String login);
}
