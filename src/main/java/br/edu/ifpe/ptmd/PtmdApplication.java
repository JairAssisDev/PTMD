package br.edu.ifpe.ptmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PtmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtmdApplication.class, args);
	}

//	@Bean
//	@Profile("dev")
//	public CommandLineRunner devProfile(IUserRepository IUserRepository, PasswordEncoder encoder) {
//		return args -> {
//			IUserRepository.save(new User("jair","1231231233","admin@email.com",encoder.encode("123"), AcessLevel.MANAGER));
//		};
//	}
}
