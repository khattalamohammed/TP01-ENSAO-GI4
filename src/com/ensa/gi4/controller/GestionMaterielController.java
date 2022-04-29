package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;
import com.ensa.gi4.service.api.GestionMaterielService;

import com.ensa.gi4.service.api.GestionMaterielServiceFacade;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan
public class GestionMaterielController {

	@Autowired
	@Qualifier("facade")
	private GestionMaterielServiceFacade gestionMaterielServiceFacade;
	private Materiel materiel;

	public void afficherMenu() {
		System.out.println();
		System.out.println("1- AJOUTER");
		System.out.println("2- AFFICHER");
		System.out.println("3- MODIFIER");
		System.out.println("4- SUPPRIMER");
		System.out.println("5- CHERCHER");
		System.out.println("0- pour sortir de l'application, entrer 0");
		System.out.println();

		Scanner scanner = new Scanner(System.in);
		String operation = scanner.next();
		String mat;
		int id;
		switch (operation) {

		case "0":
			sortirDeLApplication();
			break;
		case "1":
			System.out.println("1-pour livre \t 2-pour chaise");
			mat = scanner.next();
			Optional<String> checkType = Optional.of(mat);

			if (checkType.isPresent()) {

				System.out.println("Saisir le nom  : ");
				String name = scanner.next();
				System.out.println("Saisir le code  : ");
				String code = scanner.next();
				Optional<String> checkMaterialName = Optional.of(name);
				if (checkMaterialName.isPresent()) {

					if (mat.equals("1")) {
						gestionMaterielServiceFacade.ajouterNouveauMateriel(TypeMateriel.LIVRE, checkMaterialName.get(),
								code);
					} else if (mat.equals("2")) {
						gestionMaterielServiceFacade.ajouterNouveauMateriel(TypeMateriel.CHAISE,
								checkMaterialName.get(), code);
					} else {
						System.out.println("Le type " + mat + " n'est pas reconnu ");
					}
				} else {
					System.out.println("Nom du materiel invalide, ajout non effectué");
				}

			} else {
				System.out.println("Choix invalide ! ");
			}
			break;
		case "2":
			System.out.println("1-pour livre \t 2-pour chaise");
			mat = scanner.next();
			Optional<String> checkType1 = Optional.of(mat);

			if (checkType1.isPresent()) {

				if (checkType1.get().equals("1")) {
					gestionMaterielServiceFacade.afficherMateriel(TypeMateriel.LIVRE);
				} else if (checkType1.get().equals("2")) {
					gestionMaterielServiceFacade.afficherMateriel(TypeMateriel.CHAISE);
				} else {
					System.out.println("Le type " + checkType1.get() + " n'est pas reconnu ");
				}
			} else {
				System.out.println("Choix invalide ! ");
			}
			break;
		case "3":
			System.out.println("1-pour livre 2-pour chaise");
			mat = scanner.next();
			System.out.println("entrez l'id du materiel");
			id = scanner.nextInt();
			System.out.println("Saisir le nom  : ");
			String name = scanner.next();
			System.out.println("Saisir le code  : ");
			String code = scanner.next();
			if (mat.equals("1")) {
				gestionMaterielServiceFacade.modifierMateriel(TypeMateriel.LIVRE, id, name, code);
			} else {
				gestionMaterielServiceFacade.modifierMateriel(TypeMateriel.CHAISE, id, name, code);
			}
			break;
		case "4":
			System.out.println("1-pour livre 2-pour chaise");
			mat = scanner.next();
			System.out.println("entrez l'id du materiel");
			id = scanner.nextInt();
			if (mat.equals("1")) {
				gestionMaterielServiceFacade.supprimerMateriel(TypeMateriel.LIVRE, id);
			} else {
				gestionMaterielServiceFacade.supprimerMateriel(TypeMateriel.CHAISE, id);
			}
			break;
		case "5":
			System.out.println("1-pour livre 2-pour chaise");
			mat = scanner.next();
			System.out.println("entrez l'id du materiel");
			id = scanner.nextInt();
			if (mat.equals("1")) {
				gestionMaterielServiceFacade.findOne(TypeMateriel.LIVRE, id);
			} else {
				gestionMaterielServiceFacade.findOne(TypeMateriel.CHAISE, id);
			}
			break;
		default:
			System.out.println("choix invalide");

		}
	}

	private void sortirDeLApplication() {
		System.out.println("Fin du programme ! ");
		System.exit(0);
	}

}
