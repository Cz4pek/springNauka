package com.example.demo;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormData{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @NotNull
    private String lasta_name;
    @NotNull
    private Integer age;
    @NotNull
    private  String country;
    @NotNull
    private  String email;
    @NotNull
    private  String tech;
    @NotNull
    private  String payment;

    public Integer getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public String getLasta_name() {
        return lasta_name;
    }

    public void setLasta_name(String lasta_name) {
        this.lasta_name = lasta_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
