package DTO;


public class User {
    
    private Integer id;
    private String First_name;
    private String Last_name;
    private String email;
    private String password;
    
    private String Change_Password;


    public User() {
    }

    public User(String first_name,String Last_name,String email, String pass,String Change_Password) {
        this.First_name = first_name;
        this.Last_name = Last_name;
        this.email = email;
        this.password = pass;
        
        this.Change_Password =  Change_Password;
       
    }
    
    public User(Integer id,String first_name,String Last_name, String email, String pass,String Change_Password) {
        this(first_name,Last_name,email, pass,Change_Password);
        this.id = id;
    }

    @Override
    public String toString() {
        return "My name is " + this.First_name + " My Email is " + this.email ;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
   //first name
    public String getFirst_name(){
        return First_name;
    }
    public void setFirst_name(String first_name){
        this.First_name = first_name;
    }
    
    //last name
    public String getLast_name(){
        return Last_name;
    }
    public void setLast_name(String last_name){
        this.Last_name = last_name;
    }
    //email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }    
    //to change password
    public String getCPassword() {
        return Change_Password;
    }
    public void setCPassword(String Change_Password) {
        this.Change_Password = Change_Password;
    } 

}
