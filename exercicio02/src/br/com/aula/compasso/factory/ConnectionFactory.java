package br.com.aula.compasso.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

    //ConnectionFactory class, responsible for the connection with the DB

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/db_exercicio02?useTimezone=true&serverTimezone=UTC");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("12345");

        this.dataSource = comboPooledDataSource;
    }

    public Connection recoverConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
