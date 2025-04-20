package br.edu.ifpe.ptmd.service;

import br.edu.ifpe.ptmd.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private IUserRepository userRepository;

    public boolean findByEmail(String email) {
        if(this.userRepository.findByLogin(email) != null) {
            return true;
        }
        return false;
    }
}

