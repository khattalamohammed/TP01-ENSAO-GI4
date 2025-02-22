package com.ensa.gi4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.modele.TypeMateriel;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.api.GestionMaterielServiceFacade;

@Service("facade")
public class GestionServiceFacadeImpl implements GestionMaterielServiceFacade {
	@Autowired
	@Qualifier("livre")
	private GestionMaterielService livreMaterielService;
	@Autowired
	@Qualifier("chaise")
	private GestionMaterielService chaiseMaterielService;

	@Override
	public void ajouterNouveauMateriel(TypeMateriel type, String name) {
		final Materiel materiel;
		final GestionMaterielService serviceActuel;

		
		switch (type){
		case LIVRE: 
			materiel = new Livre();
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			materiel = new Chaise();
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}
		
		materiel.setName(name);
		serviceActuel.ajouterNouveauMateriel(materiel);
	}

	@Override
	public void afficherMateriel(TypeMateriel type) {
		final GestionMaterielService serviceActuel;
		List<Materiel> materiels;
		
		
		switch (type){
		case LIVRE: 
			serviceActuel = livreMaterielService;
			break; 
		case CHAISE : 
			serviceActuel = chaiseMaterielService;
			break; 
		default:
			System.out.println("Le type " + type + " n'est pas reconnu");
			return;
		}

		 materiels=serviceActuel.listerMateriel();
		 for (Materiel materiel : materiels) {
			System.out.println( materiel.getName());
			
		}
	}

}
