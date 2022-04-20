package com.ensa.gi4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

@Service("livre")
public class LivreService implements GestionMaterielService{
	@Autowired
	@Qualifier("livreDao")
	IDao livreDao;
    
	public void setLivreDao(IDao livreDao) {
		this.livreDao = livreDao;
	}

	@Override
	public List<Materiel> listerMateriel() {
		return livreDao.get();
	}

	@Override
	public void ajouterNouveauMateriel(Materiel materiel) {
		livreDao.add(materiel);
	}

	@Override
	public void supprimerMateriel(int id) {
		livreDao.delete(id);
	}

	@Override
	public Materiel chercherMateriel(int id) {
		return livreDao.search(id);
	}

	@Override
	public void modifierMateriel(int id,Materiel materiel) {
		livreDao.update(id,materiel);
	}
}
