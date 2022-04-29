package com.ensa.gi4;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Configuration
public class DbConfig {

	@Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
   @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jbdc.init.schema}")
    private String initSchema;

    @Value("${jbdc.populate.schema}")
    private String populateSchema;
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        executeScript(initSchema, dataSource);
        executeScript(populateSchema, dataSource);
        return dataSource;
    }

    private void lancerH2Console() {
        try {
            org.h2.tools.Console.main();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void executeScript(String scriptPath, DataSource dataSource) {
        final Resource pathResource = new ClassPathResource(scriptPath);
        if (pathResource.exists()) {
            DatabasePopulator databasePopulator = new ResourceDatabasePopulator(pathResource);
            DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        } else {
            System.out.println("ERROR : script not found in '" + scriptPath + "'");
        }
    }
}
