package DTO;

public class Project {
    
    private Integer id;
    private Integer createdby;
    private String name;
    private String description;
    private String status;
    
public Project(){
}

    public Project(String name,String description, Integer createdby,String status) {
        
        this.createdby = createdby;
        this.name = name;
        this.description = description;
        this.status = status;
       
    }
    
    public Project(Integer id,String name,String description, Integer createdby,String status) {
        this(name,description,createdby, status);
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
    
   //name
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name = name;
    }
       //description
    public String getdescription(){
        return description;
    }
    public void setdescription(String description){
        this.description = description;
    }
        //created by
    public Integer getcreatedby() {
        return createdby;
    }

    public void setcreatedby(Integer createdby) {
        this.createdby = createdby;
    }
        //status
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    
    
}
