/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;



import DTO.Project;
import DTO.User;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class RepoProject {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public RepoProject() {
        con = ConnectionManager.getConnection();
    }
    //Project details
    private Project extractProjectFromResultSet(ResultSet rs) throws SQLException {
        
        Project project = new Project();
        project.setId(rs.getInt("id"));
        project.setname(rs.getString("name"));
        project.setdescription(rs.getString("description"));
        project.setcreatedby(rs.getInt("createdby"));
        project.setstatus(rs.getString("status"));
        return project;
        }
    
        //get Project by name and created by
    public Project Get(Project p) {
        Project project = null;
        try {
            ps = con.prepareStatement("SELECT * FROM project where name=? and createdby =?");
            ps.setString(1, p.getname());
            ps.setInt(2, p.getcreatedby());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                project = extractProjectFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return project;
    }
         //get Project by name 
    public Project Getid(String p) {
        Project project = null;
        try {
            ps = con.prepareStatement("SELECT * FROM project where name=? ");
            ps.setString(1, p);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                project = extractProjectFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return project;
    }
            //get Project by id
    public Project Getname(int p) {
        Project project = null;
        try {
            ps = con.prepareStatement("SELECT * FROM project where id=?");
            ps.setInt(1, p);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                project = extractProjectFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return project;
    }
        //check if project exist
    public boolean checkname(Project p) {
        Project project = null;
        try {
            ps = con.prepareStatement("SELECT * FROM project where name=?");
            ps.setString(1, p.getname());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }   
    
        //get all open projects status == 1 (open)
    public Set<Project> GetAllOpen(int createdby) {
        Set projects = null;
        try {
            
          ps = con.prepareStatement("SELECT * FROM project where createdby =? and status = 'open';");
            ps.setInt(1, createdby);
            rs = ps.executeQuery();
            
            projects = new HashSet();
            while (rs.next()) {
                Project project = extractProjectFromResultSet(rs);
                projects.add(project);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return projects;
    }
    
            //get all closed projects status == 0 (closed)
    public Set GetAllClosed(int createdby) {
        Set projects = null;
        try {
            
          ps = con.prepareStatement("SELECT * FROM project where createdby =? and status = 0");
            ps.setInt(1, createdby);
            rs = ps.executeQuery();
            
            projects = new HashSet();
            while (rs.next()) {
                Project project = extractProjectFromResultSet(rs);
                projects.add(project);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return projects;
    }  
    
        //get all for my project
    public Set<Project> GetAll(int createdby){
        Set projects = null;
        try {
            
          ps = con.prepareStatement("SELECT * FROM project where createdby =?");
            ps.setInt(1, createdby);
            rs = ps.executeQuery();
            
            projects = new HashSet();
            while (rs.next()) {
                Project project = extractProjectFromResultSet(rs);
                projects.add(project);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return projects;
    }
    
        //create new Project  
    public boolean Create(Project project) {
        
        try {
            ps = con.prepareStatement("insert into project(createdby,name,description,status) values (?,?,?,?);");
            ps.setInt(1,project.getcreatedby());
            ps.setString(2, project.getname());
            ps.setString(3,project.getdescription());
            ps.setString(4, project.getstatus());            
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
        //Edit Project
    public boolean Edit(Project project) {
        try {
            ps = con.prepareStatement("UPDATE project SET name=?, description=?, status=? where ID=? and Createdby=?;");
            ps.setString(1, project.getname());
            ps.setString(2, project.getdescription());
            ps.setString(3, project.getstatus());
            ps.setInt(4,project.getId());
            ps.setInt(5,project.getcreatedby());
            
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    
}
