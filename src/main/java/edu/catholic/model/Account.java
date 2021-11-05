package edu.catholic.model;


public class Account {
    private String id;
    private String password;

    public String getId() {
        return id;
    }
    public String getPassword() {return password;}
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void set_NewPassword(String new_password) {this.password = new_password;}
    public String toString(){
        return "ID: " + getId() +"\n" + "PASSWORD: " +getPassword();
    }
}
