package pkg123210141_responsi;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/perpustakaan";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;

    public Connector() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection Success");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Connection Failed");
        }
    }
}
