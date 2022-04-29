package com.ensa.gi4.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Materiel;

@Repository("chaiseDao")
public class ChaiseDao extends GenericDAO implements IDao {
    
	
	@Override
	public void add(Materiel materiel) {
		super.add("INSERT INTO CHAISE (NAME,CODE) VALUES (?,?)", materiel.getName(),materiel.getCode());	
	}

	@Override
	public List<Materiel> get() {
		return super.findAll("SELECT * FROM CHAISE;");
	}

	@Override
	public void delete(int id) {
		super.delete("DELETE FROM CHAISE WHERE ID = ?",id);
	}
 
	@Override
	public void update(int id,Materiel materiel) {
		super.update("UPDATE CHAISE SET NAME = ?, CODE = ? WHERE ID = ?", id, materiel.getName(), materiel.getCode());
	}

	@Override
	public Materiel search(int id) {
		return super.getOne("SELECT * FROM CHAISE WHERE ID = ?",id);
	}

	@Override
	protected RowMapper<Materiel> getRowMapper() {
		return new ChaiseRowMapper();
	}
}
