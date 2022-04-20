package com.ensa.gi4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

@Service("chaise")
public class ChaiseService implements GestionMaterielService{
	@Autowired
	@Qualifier("chaiseDao")
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
