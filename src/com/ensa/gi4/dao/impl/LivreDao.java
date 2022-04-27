package com.ensa.gi4.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Materiel;

@Repository("livreDao")
public class LivreDao implements IDao{
	List<Materiel> livres;
	public LivreDao() {
		livres=new ArrayList<Materiel>();
	}
	
	@Override
	public void add(Materiel materiel) {
		livres.add(materiel);
	}

	@Override
	public List<Materiel> get() {
		return this.livres;
	}

	@Override
	public void delete(int id) {
		livres.remove(id);
	}
 
	@Override
	public void update(int id,Materiel materiel) {
		livres.set(id, materiel);
	}

	@Override
	public Materiel search(int id) {
		return livres.get(id);
	}

}
