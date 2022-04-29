package com.ensa.gi4.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

public class LivreRowMapper implements RowMapper<Materiel>{

	@Override
	public Materiel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Livre livre=new Livre();
		livre.setId(rs.getInt("ID"));
		livre.setCode(rs.getString("CODE"));
		livre.setName(rs.getString("NAME"));
		return livre;
	}

}
