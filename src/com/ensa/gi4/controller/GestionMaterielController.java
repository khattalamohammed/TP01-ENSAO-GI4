package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class GestionMaterielController implements ApplicationContextAware{
	private ApplicationContext APPLICATION_CONTEXT;
    private GestionMaterielService service;
    private Materiel materiel;
	
	public void afficherMenu() {
        System.out.println("1- AFFICHER");
        System.out.println("2- AJOUTER");
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
            	afficherMateriel("livre");
            }else {
            	afficherMateriel("chaise");
            }
            break;
        case "2":
        	System.out.println("1-pour livre 2-pour chaise");
             mat = scanner.next();
             if(mat.equals("1")) {
             	ajouterMateriel("livre");
             }else {
             	ajouterMateriel("chaise");
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
             	supprimerMateriel("livre");
             }else {
             	supprimerMateriel("chaise");
             }
            break;
        case "5":
        	System.out.println("1-pour livre 2-pour chaise");
            mat = scanner.next();
            if(mat.equals("1")) {
             	chercherMateriel("livre");
             }else {
             	chercherMateriel("chaise");
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
		if(type.equals("livre")) {
    	materiel=(Materiel) APPLICATION_CONTEXT.getBean("livre");
    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
    	materiel.setName(name);
    	service.ajouterNouveauMateriel(materiel);
		}
		else if(type.equals("chaise")) {
	    	materiel=(Materiel) APPLICATION_CONTEXT.getBean("chaise");
	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
	    	materiel.setName(name);
	    	service.ajouterNouveauMateriel(materiel);
			}
    }
	public void chercherMateriel(String type) {
		System.out.println("saisir l'id du materiel");
    	Scanner scanner = new Scanner(System.in);
    	int  id=scanner.nextInt();
		if(type.equals("livre")) {
    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
    	materiel=service.chercherMateriel(id);
    	System.out.println(materiel.getName());
		}
		else if(type.equals("chaise")) {
	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
	    	materiel=service.chercherMateriel(id);
	    	System.out.println(materiel.getName());
			}
    	
    }
	public void afficherMateriel(String type) {
		if(type.equals("livre")) {
	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
	    	for(Materiel materiel:service.listerMateriel()) {
				System.out.println(materiel.getName());
			}
			}
			else if(type.equals("chaise")) {
		    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
		    	for(Materiel materiel:service.listerMateriel()) {
					System.out.println(materiel.getName());
				}
				}
	
	}
	public void supprimerMateriel(String type) {
		System.out.println("saisir l'id du materiel");
    	Scanner scanner = new Scanner(System.in);
    	int  id=scanner.nextInt();
		if(type.equals("livre")) {
    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("livreService");
    	service.supprimerMateriel(id);
		}
		else if(type.equals("chaise")) {
	    	service=(GestionMaterielService) APPLICATION_CONTEXT.getBean("chaiseService");
	    	service.supprimerMateriel(id);
			}
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.APPLICATION_CONTEXT=arg0;
	}
}
