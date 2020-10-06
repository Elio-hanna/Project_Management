package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    private static final String ConnectionString = "jdbc:mysql://localhost/pootest?user=root";
    private static Connection con = null;
    public static int NumberOfOpenedConnection=0;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Driver initiated");

            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(ConnectionString);
            }
            System.out.println("Connection initiated");
        } catch (Exception ex) {
            System.out.println("Connection could not be returned:" + ex);
        }

        NumberOfOpenedConnection++;
        return con;
    }
    
    public boolean IsConnectionOpened()
    {
        try {
            return !con.isClosed();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }

    public static void Close() {
        try {
            con.close();
            NumberOfOpenedConnection--;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }   
}
