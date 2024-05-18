package com.gumaso.Screentify;

import com.gumaso.Screentify.models.TipoFormacao;
import com.gumaso.Screentify.principal.Principal;
import com.gumaso.Screentify.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreentifyApplication implements CommandLineRunner {
	@Autowired
	ArtistaRepository artistaRepository;
	public static void main(String[] args) {
		SpringApplication.run(ScreentifyApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(artistaRepository);
		principal.exibeMenu();

	}
}
