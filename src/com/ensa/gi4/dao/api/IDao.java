package com.ensa.gi4.dao.api;

import java.util.List;

import com.ensa.gi4.modele.Materiel;

public interface IDao {
	void add(Materiel materiel);
	List<Materiel> get();
	void delete(int id);
	void update(int id,Materiel materiel);
	Materiel search(int id);
}
