
package Repositories;

import DTO.Team;
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

public class RepoTeam {
    
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    public RepoTeam() {
        con = ConnectionManager.getConnection();
    }
    //Project details
    private Team extractteamFromResultSet(ResultSet rs) throws SQLException {
        
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setIdProject(rs.getInt("idproject"));
        team.setIdUser(rs.getInt("iduser"));
        team.setposition(rs.getString("position"));
        return team;
        }
    
    //get team using project id
        public Set<Team> getteam(int pid){
           Set teamM = null;
           try{
            ps = con.prepareStatement("SELECT * FROM team where idproject =?");
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            
            teamM = new HashSet();
            while (rs.next()) {
                Team team = extractteamFromResultSet(rs);
                teamM.add(team);
            
            }
           } catch (SQLException ex) {
            System.out.println(ex);
        }
        return teamM;
        }
        
        //remove a member
        public boolean Delete(Team t) {
        try {
            stmt = con.createStatement();
            //int i = stmt.executeUpdate("DELETE FROM team WHERE idproject = " + t.getIdProject()+ " and iduser = ?" + t.getIdUser());
            ps = con.prepareStatement("DELETE FROM team WHERE idproject =? and iduser = ?");
            ps.setInt(1, t.getIdProject());
            ps.setInt(2, t.getIdUser());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
        
        //check if member exist
        public boolean checkexist(Team t){
  
            boolean exist = false;
            try{
            ps = con.prepareStatement("SELECT * FROM team WHERE idproject =? and iduser = ?");
            ps.setInt(1, t.getIdProject());
            ps.setInt(2, t.getIdUser());
            rs = ps.executeQuery();
                
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
        
            // add member
        public boolean add(Team t){
        boolean checkexist;
        checkexist = checkexist(t);
        if (checkexist){
            return false;
        }else{
            try{
                ps = con.prepareStatement("insert into team(idproject,iduser,position) values (?,?,?);");
                ps.setInt(1,t.getIdProject());
                ps.setInt(2, t.getIdUser());
                ps.setString(3,t.getposition());
                int i = ps.executeUpdate();
                if (i == 1){
                    return true;
                }
            }catch (SQLException ex) {
            System.out.println(ex);
        }
        }
        return false;
        }    
    
}
