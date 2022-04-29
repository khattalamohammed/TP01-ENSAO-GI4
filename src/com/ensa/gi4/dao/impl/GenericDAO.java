package com.ensa.gi4.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ensa.gi4.DbConfig;
import com.ensa.gi4.modele.Materiel;

public abstract class GenericDAO implements InitializingBean {

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void add(String query, String name, String code) {
		int c = jdbcTemplate.update(query, name, code);
	}

	public List<Materiel> findAll(String query) {
		return jdbcTemplate.query(query, getRowMapper());
	}

	public Materiel getOne(String query, int id) {
		return jdbcTemplate.queryForObject(query, getRowMapper(),id);
	}

	public void update(String query, int id, String name, String code) {
		jdbcTemplate.update(query, name, code, id);
	}

	public void delete(String query, int id) {
		jdbcTemplate.update(query, id);
	}

	protected abstract RowMapper<Materiel> getRowMapper();
}
