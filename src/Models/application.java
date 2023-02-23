package Models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */

   public class application {
    
    private String id;
    private String name;
    private int num;
    private String role;
    private String location;
    private String document;

    public application() {
    }

    public application(String id, String name, int num, String role, String location, String document) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.role = role;
        this.location = location;
        this.document = document;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "application{" + "id=" + id + ", name=" + name + ", num=" + num + ", role=" + role + ", location=" + location + ", document=" + document + '}';
    }

   
}



 

