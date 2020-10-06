/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import DTO.User;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author PC
 */
public class RepoUser {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    public RepoUser() {
        con = ConnectionManager.getConnection();
    }
    //user details
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirst_name(rs.getString("firstname"));
        user.setLast_name(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    }
    //get user by id
    public User Get(int id) {
        User user = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);
            //rs.next check if user exist
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return user;
    }
        //get user id by name
    public User Getid(String email) {
        User user = null;
        try {
           // stmt = con.createStatement();
            //rs = stmt.executeQuery("SELECT * FROM user WHERE email=" + email);
            //rs.next check if user exist
            ps = con.prepareStatement("SELECT * FROM user WHERE email=?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return user;
    }
    //login with an existing email and password
    public User Login(String email, String password) {
        User user = null;
        try {
            ps = con.prepareStatement("SELECT * FROM user WHERE email=?"
                    + " AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return user;
    }
    
    
    //get all users
    public Set<User> GetAll() {
        Set users = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM user");
            users = new HashSet();
            while (rs.next()) {
                User user = extractUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return users;
    }
    
        //get all users names using project
    public Set<User> GetAllnames(int idproject) {
        Set users = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT user.* FROM user,team where team.idproject = "+idproject+" and team.iduser = user.id");
            users = new HashSet();
            while (rs.next()) {
                User user = extractUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return users;
    }
    
    //check if email exist
    public boolean checkemail(String email){
        User user = null;
        boolean exist = false ;
        try {
            ps = con.prepareStatement("SELECT * FROM user WHERE email =?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            //rs.next check if user exist
            if (rs.next()) {
               exist = true;
            }else
            {
                exist = false;
            }            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return exist;
    }
    //create new user
    public boolean Create(User user) {
        boolean checkexist;
        checkexist = checkemail(user.getEmail());
        if(checkexist){
         return false;   
        }else{
        try {
            ps = con.prepareStatement("insert into user(firstname,lastname,email, password) values (?,?,?,?);");
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getEmail().toLowerCase());
            ps.setString(4, user.getPassword());
            
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
        return false;
    }
    // check if email and password exist to change the password
        public boolean check_to_change(String email, String password) {
        try {
            ps = con.prepareStatement("SELECT * FROM user WHERE email=?"
                    + " AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
               return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    
    //change password
    public boolean change_password(User user) {
        boolean check_email_password;
        check_email_password = check_to_change(user.getEmail(),user.getPassword());
        if (check_email_password){
        try {
            ps = con.prepareStatement("UPDATE user SET password=? WHERE email=? and password=?");
            ps.setString(1, user.getCPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        }
        return false;
    }

    //delete a user
    public boolean Delete(int id) {
        try {
            stmt = con.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    public void Destroy() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        ConnectionManager.Close();
    }
}
