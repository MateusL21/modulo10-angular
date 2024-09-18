package com.spring.java.models;

public class Student {

    private int id;
    private String name;
    private String email;
    private String phone;
    private Course course;
    private String period;


    public Student(int Id, String name, String email, String phone, int i, String period){
        this.id = Id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.phone = phone;
        this.period = period;
        
    }

    public Student(){

    }



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public String getPeriod() {
        return period;
    }
    public void setPeriod(String period) {
        this.period = period;
    }

    

    
}
