package com.ensa.gi4.service.api;

import java.util.List;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    List<Materiel> listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    void supprimerMateriel(int id);
    Materiel chercherMateriel(int id);
    void modifierMateriel(int id,Materiel materiel);
}
