package com.ua.foxminded.school.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {

    private final String propFileName;
    private String dataBaseUrl;
    private String user;
    private String pwd;

    public DataSource() {
        this("connection.properties");
    }
    public DataSource(String propFileName) {
        this.propFileName = propFileName;
    }

    public Connection getConnection() throws SQLException {
        if (!propertiesInitialized()) {
            setUpConnectionProperties();
        }
        return DriverManager.getConnection(dataBaseUrl, user, pwd);
    }

    private void setUpConnectionProperties() {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            Properties property = new Properties();
            if (inputStream != null) {
                property.load(inputStream);
            } else {
                throw new FileNotFoundException("The file has not found.");
            }
            this.dataBaseUrl = property.getProperty("dataBaseUrl");
            this.user = property.getProperty("user");
            this.pwd = property.getProperty("pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean propertiesInitialized() {
        return this.dataBaseUrl != null && this.user != null && this.pwd != null;
    }
}
