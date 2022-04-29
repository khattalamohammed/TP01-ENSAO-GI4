package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.TypeMateriel;

public interface GestionMaterielServiceFacade {

    void afficherMateriel(TypeMateriel type);
	void ajouterNouveauMateriel(TypeMateriel type, String name,String code);
	void supprimerMateriel(TypeMateriel type, int id);
	void findOne(TypeMateriel type,int id);
	void modifierMateriel(TypeMateriel type,int id,String name,String code);
	
}
