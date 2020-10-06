
package DTO;

public class Team {
    
    
    private Integer id;
    private Integer idproject;
    private Integer iduser;
    private String position;
    
    public Team() {
    }

    public Team(Integer idproject ,Integer iduser ,String position) {
        
        this.idproject = idproject;
        this.iduser = iduser;
        this.position = position;
          
    }
    
    public Team(Integer id,Integer idproject ,Integer iduser ,String position) {
        this(idproject,iduser,position);
        this.id = id;
    }
    
            //id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        //id project
    public Integer getIdProject() {
        return idproject;
    }

    public void setIdProject(Integer idproject) {
        this.idproject = idproject;
    }
    //id user
    public Integer getIdUser(){
        return iduser;
    }
    public void setIdUser(Integer iduser){
        this.iduser = iduser;
    }
    
    //position
    public String getposition(){
        return position;
    }
    public void setposition(String position){
        this.position = position;
    }
    
    
}
