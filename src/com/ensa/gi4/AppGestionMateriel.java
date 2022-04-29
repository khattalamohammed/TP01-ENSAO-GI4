package com.ensa.gi4;

import com.ensa.gi4.controller.GestionMaterielController;
import com.ensa.gi4.listeners.ApplicationPublisher;
import com.ensa.gi4.listeners.EventType;
import com.ensa.gi4.listeners.MyEvent;
import com.ensa.gi4.modele.Livre;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@SuppressWarnings("all")
@ComponentScan
public class AppGestionMateriel {
	private static final ApplicationContext APPLICATION_CONTEXT;


	static { // bloc static pour initilialisation
		APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(AppGestionMateriel.class);
	}

	public static void main(String[] args) {
		GestionMaterielController gestionMaterielController = APPLICATION_CONTEXT
				.getBean(GestionMaterielController.class);
		while (true) { 
			gestionMaterielController.afficherMenu();
		}
	}
}
