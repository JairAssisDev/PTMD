package br.com.ifpe.PTMD;

import br.com.ifpe.PTMD.Users.domain.model.AcessLevel;
import br.com.ifpe.PTMD.Users.domain.model.User;
import br.com.ifpe.PTMD.Users.domain.repository.UserRepository;
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
	public CommandLineRunner devProfile(UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			userRepository.save(new User("jair","1231231233","admin",encoder.encode("123"), AcessLevel.MANAGER));
		};
	}
}
