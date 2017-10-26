package JDBS;

import java.sql.*;

public class JDBCPostgreSQLExampl {

    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5432/personal";
    static final String USER = "root";
    static final String PASS = "root";

    public static Connection onConnectJDBS() {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }
        return connection;
    }
}
