package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.api.GestionMaterielServiceFacade;

import java.util.List;
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
        System.out.println("1- AJOUTER");
        System.out.println("2- AFFICHER");
        System.out.println("3- MODIFIER");
        System.out.println("4- SUPPRIMER");
        System.out.println("5- CHERCHER");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();
        String mat;
        switch(operation) {
        
        case "0":
        	sortirDeLApplication();
        	break;
        case "1":
        	System.out.println("1-pour livre 2-pour chaise");
            mat = scanner.next();
            if(mat.equals("1")) {
            	gestionMaterielServiceFacade.ajouterNouveauMateriel("livre", "spring");
            }else {
            	gestionMaterielServiceFacade.ajouterNouveauMateriel("chaise", "popopopo");
            }
            break;
        case "2":
        	System.out.println("1-pour livre 2-pour chaise");
             mat = scanner.next();
             if(mat.equals("1")) {
             	gestionMaterielServiceFacade.afficherMateriel("livre");
             }else {
             	gestionMaterielServiceFacade.afficherMateriel("chaise");
             }
             break;
        case "3":
        	System.out.println("1-pour livre 2-pour chaise");
            mat = scanner.next();
            
            break;
        case "4":
        	System.out.println("1-pour livre 2-pour chaise");
            mat = scanner.next();
            if(mat.equals("1")) {
             }else {
             }
            break;
        case "5":
        	System.out.println("1-pour livre 2-pour chaise");
            mat = scanner.next();
            if(mat.equals("1")) {
             }else {
             }
            break;
        case "6":
        	System.out.println("1-pour livre 2-pour chaise");
            mat = scanner.next();
            switch(mat) {
            case"1":
            	break;
            case"2":
            	break;
            default:System.out.println("choix invalide");
            }
            break;
        default:System.out.println("choix invalide");
        
        }  
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

	public void ajouterMateriel(String type) {
		//Materiel materiel=new Livre();
		System.out.println("saisir le nom du materiel");
    	Scanner scanner = new Scanner(System.in);
    	String name=scanner.next();
    	gestionMaterielServiceFacade.ajouterNouveauMateriel(type, name);
		
    }
//	public void chercherMateriel(String type) {
//		System.out.println("saisir l'id du materiel");
//    	Scanner scanner = new Scanner(System.in);
//    	int  id=scanner.nextInt();
//		if(type.equals("livre")) {
//    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
//    	materiel=service.chercherMateriel(id);
//    	System.out.println(materiel.getName());
//		}
//		else if(type.equals("chaise")) {
//	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
//	    	materiel=service.chercherMateriel(id);
//	    	System.out.println(materiel.getName());
//			}
//    	
//    }
//	public void afficherMateriel(String type) {
//		if(type.equals("livre")) {
//	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
//	    	for(Materiel materiel:service.listerMateriel()) {
//				System.out.println(materiel.getName());
//			}
//			}
//			else if(type.equals("chaise")) {
//		    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
//		    	for(Materiel materiel:service.listerMateriel()) {
//					System.out.println(materiel.getName());
//				}
//				}
//	
//	}
//	public void supprimerMateriel(String type) {
//		System.out.println("saisir l'id du materiel");
//    	Scanner scanner = new Scanner(System.in);
//    	int  id=scanner.nextInt();
//		if(type.equals("livre")) {
//    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
//    	service.supprimerMateriel(id);
//		}
//		else if(type.equals("chaise")) {
//	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
//	    	service.supprimerMateriel(id);
//			}
//	}
//	@Override
//	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
//		// TODO Auto-generated method stub
//		this.APPLICATION_CONTEXT=arg0;
//	}
}
