package com.cg.obb.entity;


import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private int age;
    private long ph_no;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPh_no() {
        return ph_no;
    }

    public void setPh_no(long ph_no) {
        this.ph_no = ph_no;
    }



    public User(){

    }
    public User(String email, String name, int age, long ph_no) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.ph_no = ph_no;
    }




}
