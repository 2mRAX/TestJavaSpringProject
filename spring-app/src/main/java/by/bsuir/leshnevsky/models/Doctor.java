package by.bsuir.leshnevsky.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_doctor")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronym")
    private String patronym;
//    @ManyToOne (optional=false, cascade=CascadeType.ALL)
//    @JoinColumn (name="id_speciality")
//    private Speciality speciality;
    @Column(name = "room_id")
    private Integer room_id;
    @Column(name = "speciality_id")
    private Integer speciality_id;
    @Column(name = "district_id")
    private Integer district_id;
    @Column(name = "birth")
    private String birth;
    @Column(name = "begin_job")
    private String begin_job;

    public Doctor() {
    }

    public Doctor(String name, String surname, Integer room_id, Integer speciality_id, String birth, String begin_job) {
        this.name = name;
        this.surname = surname;
        this.room_id = room_id;
        this.speciality_id = speciality_id;
        this.birth = birth;
        this.begin_job = begin_job;
    }

    public Doctor(String name, String surname, Integer room_id, Integer speciality_id, Integer district_id, String birth, String begin_job) {
        this.name = name;
        this.surname = surname;
        this.room_id = room_id;
        this.speciality_id = speciality_id;
        this.district_id = district_id;
        this.birth = birth;
        this.begin_job = begin_job;
    }

    public Doctor(String name, String surname, String patronym, Integer room_id, Integer speciality_id, String birth, String begin_job) {
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.room_id = room_id;
        this.speciality_id = speciality_id;
        this.birth = birth;
        this.begin_job = begin_job;
    }

    public Doctor(String name, String surname, String patronym, Integer room_id, Integer speciality_id, Integer district_id, String birth, String begin_job) {
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.room_id = room_id;
        this.speciality_id = speciality_id;
        this.district_id = district_id;
        this.birth = birth;
        this.begin_job = begin_job;
    }

    public Doctor(Integer id, String name, String surname, String patronym, Integer room_id, Integer speciality_id, Integer district_id, String birth, String begin_job) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.room_id = room_id;
        this.speciality_id = speciality_id;
        this.district_id = district_id;
        this.birth = birth;
        this.begin_job = begin_job;
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

    public Integer getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public Integer getSpeciality_id() {
        return speciality_id;
    }

    public void setSpeciality_id(Integer speciality_id) {
        this.speciality_id = speciality_id;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBegin_job() {
        return begin_job;
    }

    public void setBegin_job(String begin_job) {
        this.begin_job = begin_job;
    }

    //    public Speciality getSpeciality() {
//        return speciality;
//    }
//
//    public void setSpeciality(Speciality speciality) {
//        this.speciality = speciality;
//    }

}
