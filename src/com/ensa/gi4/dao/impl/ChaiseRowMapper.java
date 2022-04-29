package com.ensa.gi4.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Materiel;

public class ChaiseRowMapper implements RowMapper<Materiel>{

	@Override
	public Chaise mapRow(ResultSet rs, int rowNum) throws SQLException {
		Chaise chaise=new Chaise();
		chaise.setId(rs.getInt("ID"));
		chaise.setCode(rs.getString("CODE"));
		chaise.setName(rs.getString("NAME"));
		return chaise;
	}

}
