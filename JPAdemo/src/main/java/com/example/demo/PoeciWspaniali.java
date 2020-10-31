package com.example.demo;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PoeciWspaniali {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private String imie;
    private String nazwisko;
    private  String ocena;

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getOcena() {
        return ocena;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public Integer getid() {
        return id;
    }

    public void setid(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }
}
