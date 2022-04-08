package com.ensa.gi4.service.impl;

import java.util.List;

import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

public class ChaiseService implements GestionMaterielService{
   IDao chaiseDao;
   
public void setChaiseDao(IDao chaiseDao) {
	this.chaiseDao = chaiseDao;
}

@Override
public List<Materiel> listerMateriel() {
	return chaiseDao.get();
}

@Override
public void ajouterNouveauMateriel(Materiel materiel) {
	chaiseDao.add(materiel);
}

@Override
public void supprimerMateriel(int id) {
	chaiseDao.delete(id);
}

@Override
public Materiel chercherMateriel(int id) {
	return chaiseDao.search(id);
}

@Override
public void modifierMateriel(int id,Materiel materiel) {
	chaiseDao.update(id, materiel);
}
 
}
