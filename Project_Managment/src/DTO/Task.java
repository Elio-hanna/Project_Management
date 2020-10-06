package DTO;


public class Task {
    
    private Integer id;
    private Integer idproject;
    private Integer iduser;
    private Integer idassignedto;
    private String name;
    private String description;
    private String priority;
    private String startdate;
    private String enddate;
    private String status;
    
    
 public Task() {
    }

    public Task(Integer idproject ,Integer iduser ,Integer idassignedto,String name,String description,String priority, String startdate,String enddate,String status) {
        
        this.idproject = idproject;
        this.iduser = iduser;
        this.idassignedto = idassignedto;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.startdate = startdate;
        this.enddate = enddate;
        this.status = status;
          
    }
    
    public Task(Integer id,Integer idproject ,Integer iduser ,Integer idassignedto,String name,String description,String priority, String startdate,String enddate,String status) {
        this(idproject,iduser,idassignedto,name,description,priority,startdate,enddate,status);
        this.id = id;
    }
    
        @Override
    public String toString() {
        return "My name is " + this.name  ;
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
        //id assigned to
    public Integer getidassignedto(){
        return idassignedto;
    }
    public void setidassignedto(Integer idassignedto){
        this.idassignedto = idassignedto;
    }
    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
     //description
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    //priority
    public String getPriority(){
        return priority;
    }
    public void setPriority(String priority){
        this.priority = priority;
    }
    //startdate
    public String getstartdate(){
        return startdate;
    }
    public void setstartdate(String startdate){
        this.startdate = startdate;
    }
    //enddate
    public String getenddate(){
        return enddate;
    }
    public void setenddate(String enddate){
        this.enddate = enddate;
    }
    //status
    public String getstatus(){
        return status;
    }
    public void setstatus(String status){
        this.status = status;
    }
}
