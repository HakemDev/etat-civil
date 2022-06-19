package com.civil.project;

import com.civil.project.security.dao.UtilisateurRepository;
import com.civil.project.security.entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
public class ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	private final PasswordEncoder encoder;
	private final UtilisateurRepository repository;
	@Value("${admin.nomFr}") private String nomFr;
	@Value("${admin.nomAr}") private String nomAr;
	@Value("${admin.prenomAr}") private String prenomAr;
	@Value("${admin.prenomFr}") private String prenomFr;
	@Value("${admin.login}") private String login;
	@Value("${admin.motDePasse}") private String password;


	@Override
	public void run(String... args) throws Exception {

		if( !repository.findAll().isEmpty()) {
			return;
		}

		Utilisateur admin =	Utilisateur.builder()
				.motDePasse( encoder.encode(password))
				.login(login)
				.nomAr(nomAr)
				.nomFr(nomFr)
				.prenomAr(prenomAr)
				.prenomFr(prenomFr)
				.role("admin")
				.build();

		repository.save(admin);
	}
}
