package br.edu.ifpe.ptmd;

import br.edu.ifpe.ptmd.model.AcessLevel;
import br.edu.ifpe.ptmd.model.User;
import br.edu.ifpe.ptmd.repository.IUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PtmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtmdApplication.class, args);
	}

	@Bean
	@Profile("dev")
	public CommandLineRunner devProfile(IUserRepository IUserRepository, PasswordEncoder encoder) {
		return args -> {
			IUserRepository.save(new User("jair","1231231233","admin@email.com",encoder.encode("123"), AcessLevel.MANAGER));
		};
	}
}
