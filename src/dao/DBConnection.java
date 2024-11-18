package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/campusmanager?useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Boring@2022";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}