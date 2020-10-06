package Repositories;

import DTO.Task;
import Helpers.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class RepoTask {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public RepoTask() {
        con = ConnectionManager.getConnection();
    }
    //Task details
    private Task extractTaskFromResultSet(ResultSet rs) throws SQLException {
        
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setIdProject(rs.getInt("idproject"));
        task.setIdUser(rs.getInt("iduser"));
        task.setidassignedto(rs.getInt("idassignedto"));
        task.setName(rs.getString("name"));
        task.setDescription(rs.getString("description"));
        task.setPriority(rs.getString("priority"));
        task.setstartdate(rs.getString("startdate"));
        task.setenddate(rs.getString("enddate"));
        task.setstatus(rs.getString("status"));
        return task;
        }
        //get a task
       public Task Get(Task p) {
        Task task = null;
        try {
            ps = con.prepareStatement("SELECT * FROM task where name=? and iduser =?");
            ps.setString(1, p.getName());
            ps.setInt(2, p.getIdUser());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                task = extractTaskFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return task;
    }
              //get a task
       public Task Get2(Task p) {
        Task task = null;
        try {
            ps = con.prepareStatement("SELECT * FROM task where name=?");
            ps.setString(1, p.getName());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                task = extractTaskFromResultSet(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return task;
    }
    
         //get all task created by a user
        public Set<Task> GetAll(int createdby){
        Set tasks = null;
        try {
            
          ps = con.prepareStatement("SELECT * FROM task where iduser =?");
            ps.setInt(1, createdby);
            rs = ps.executeQuery();
            
            tasks = new HashSet();
            while (rs.next()) {
                Task task = extractTaskFromResultSet(rs);
                tasks.add(task);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tasks;
    }
        
                //check if project exist
    public boolean checkname(Task t) {
        Task task = null;
        try {
            ps = con.prepareStatement("SELECT * FROM task where name=?");
            ps.setString(1, t.getName());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return false;
    }   
    
        //create new Task  
    public boolean Create(Task task) {
        
        try {
          
           ps = con.prepareStatement("insert into task(idproject,iduser,IDAssignedto,name,description,priority,startdate,enddate,status) values(?,?,?,?,?,?,?,?,?);");
           ps.setInt(1, task.getIdProject());
           ps.setInt(2, task.getIdUser());
           ps.setInt(3, task.getidassignedto());
           ps.setString(4, task.getName());
           ps.setString(5,task.getDescription());
           ps.setString(6, task.getPriority());
           ps.setString(7,task.getstartdate());
           ps.setString(8, task.getenddate());
           ps.setString(9, task.getstatus());
           int i = ps.executeUpdate();

            if (i == 1) {
                return true;
            }
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
    
    
        //Edit task
    public boolean Edit(Task task) {
        try {
            ps = con.prepareStatement("UPDATE task SET idproject=?,idassignedto=?, name=?, description=?,priority=?,startdate=?,enddate=?, status=? where ID=?;");
           ps.setInt(1, task.getIdProject());
           ps.setInt(2, task.getidassignedto());
           ps.setString(3, task.getName());
           ps.setString(4,task.getDescription());
           ps.setString(5, task.getPriority());
           ps.setString(6, task.getstartdate());
           ps.setString(7,task.getenddate());
           ps.setString(8, task.getstatus());
           ps.setInt(9, task.getId());
            
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }    
    
    
    
    // get all open tasks for assigned for me
    public Set<Task> getallopen(int createdby){
        Set tasks = null;
        try{        
            ps = con.prepareStatement("Select * from task where IDAssignedto =? and status = ?");
            ps.setInt(1, createdby);
            ps.setString(2, "open");
            rs = ps.executeQuery();
            
            tasks = new HashSet();
            while(rs.next()){
                Task task = extractTaskFromResultSet(rs);
                tasks.add(task);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex);
        }

        return tasks;
    }
     
    // get all closed tasks for assigned for me
    public Set<Task> getallclosed(int createdby){
        Set tasks = null;
        try{        
            ps = con.prepareStatement("Select * from task where IDAssignedto =? and status = ?");
            ps.setInt(1, createdby);
            ps.setString(2, "closed");
            rs = ps.executeQuery();
            
            tasks = new HashSet();
            while(rs.next()){
                Task task = extractTaskFromResultSet(rs);
                tasks.add(task);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex);
        }

        return tasks;
    }
      
    
    
}
