package org.okasha.databaseConnection;

import java.sql.*;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class mySQLConnection {
    private Connection con;

    public mySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:80/watanaya", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(mySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Boolean execute(String q) {
        int row = 0;
        try {
            Statement stmt = con.createStatement();
            row = stmt.executeUpdate(q);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(mySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (row != 0);
    }

    public Connection getCon() {
        return this.con;
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(mySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}