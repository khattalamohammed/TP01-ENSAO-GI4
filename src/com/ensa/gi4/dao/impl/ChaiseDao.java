package com.ensa.gi4.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Materiel;

@Repository("chaiseDao")
public class ChaiseDao implements IDao {
    List<Materiel> chaises;
    public ChaiseDao() {
    	chaises=new ArrayList<Materiel>();
    }
    
	public List<Materiel> getChaises() {
		return chaises;
	}

	public void setChaises(List<Materiel> chaises) {
		this.chaises = chaises;
	}

	@Override
	public void add(Materiel materiel) {
		chaises.add(materiel);
	}

	@Override
	public List<Materiel> get() {
		return chaises;
	}

	@Override
	public void delete(int id) {
		chaises.remove(id);
	}

	@Override
	public void update(int id,Materiel materiel) {
		chaises.set(id, materiel);
	}

	@Override
	public Materiel search(int id) {
		return chaises.get(id);
	}

}
