package com.ensa.gi4;

import com.ensa.gi4.controller.GestionMaterielController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
@ComponentScan
public class AppGestionMateriel {
	private static final ApplicationContext APPLICATION_CONTEXT;

	static { // bloc static pour initilialisation
		APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppGestionMateriel.class);
	}

	public static void main(String[] args) {
		//APPLICATION_CONTEXT.refresh();
		GestionMaterielController gestionMaterielController = APPLICATION_CONTEXT
				.getBean(GestionMaterielController.class);
		while (true) { // pour que l'appliation tourne jusqu'à la demande de l'utilisateur de
						// l'arrêter
			gestionMaterielController.afficherMenu();
		}

	}
}
