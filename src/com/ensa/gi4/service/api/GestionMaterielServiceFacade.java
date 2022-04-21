package com.ensa.gi4.service.api;

import com.ensa.gi4.modele.TypeMateriel;

public interface GestionMaterielServiceFacade {

    void afficherMateriel(TypeMateriel type);
	void ajouterNouveauMateriel(TypeMateriel type, String name);
}
