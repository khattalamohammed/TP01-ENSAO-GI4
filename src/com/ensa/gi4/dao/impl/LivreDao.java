package com.ensa.gi4.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ensa.gi4.DbConfig;
import com.ensa.gi4.dao.api.IDao;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

@Repository("livreDao")
public class LivreDao extends GenericDAO implements IDao{
	
	@Override
	public void add(Materiel materiel) {
		super.add("INSERT INTO LIVRE (NAME,CODE) VALUES (?,?)", materiel.getName(),materiel.getCode());	
	}

	@Override
	public List<Materiel> get() {
		return super.findAll("SELECT * FROM LIVRE;");
	}

	@Override
	public void delete(int id) {
		super.delete("DELETE FROM LIVRE WHERE ID = ?",id);
	}
 
	@Override
	public void update(int id,Materiel materiel) {
		super.update("UPDATE LIVRE SET NAME = ?, CODE = ? WHERE ID = ?", id, materiel.getName(), materiel.getCode());
	}

	@Override
	public Materiel search(int id) {
		return super.getOne("SELECT * FROM LIVRE WHERE ID = ?",id);
	}

	@Override
	protected RowMapper<Materiel> getRowMapper() {
		return new LivreRowMapper();
	}

}
