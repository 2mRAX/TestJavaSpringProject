package by.bsuir.leshnevsky.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_patient")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronym")
    private String patronym;
    @Column(name = "gender")
    private char gender;
    @Column(name = "address_id")
    private Integer address_id;
    @Column(name = "medcard")
    private Integer medcard;
    @Column(name = "birth")
    private String birth;

    public Patient() {
    }

    public Patient(String name, String surname, char gender, Integer address_id, Integer medcard, String birth) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.address_id = address_id;
        this.medcard = medcard;
        this.birth = birth;
    }

    public Patient(String name, String surname, String patronym, char gender, Integer address_id, Integer medcard, String birth) {
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.gender = gender;
        this.address_id = address_id;
        this.medcard = medcard;
        this.birth = birth;
    }

    public Patient(Integer id, String name, String surname, String patronym, char gender, Integer address_id, Integer medcard, String birth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.gender = gender;
        this.address_id = address_id;
        this.medcard = medcard;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronym() {
        return patronym;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public Integer getMedcard() {
        return medcard;
    }

    public void setMedcard(Integer medcard) {
        this.medcard = medcard;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
