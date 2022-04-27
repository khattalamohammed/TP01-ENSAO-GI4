package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ensa.gi4.controller.GestionMaterielController;

@Configuration
public class AppConfiguration {

	@Bean
	public GestionMaterielController getGestionMaterielController() {
		return new GestionMaterielController();
	}
}
