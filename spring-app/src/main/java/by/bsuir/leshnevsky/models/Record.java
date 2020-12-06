package by.bsuir.leshnevsky.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_record")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "doctor_id")
    private Integer doctor_id;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Column(name = "comment")
    private String comment;

    public Record() {
    }

    public Record(Integer patient_id, Integer doctor_id, String date, String time, String comment) {
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.time = time;
        this.comment = comment;
    }

    public Record(Integer id, Integer patient_id, Integer doctor_id, String date, String time, String comment) {
        this.id = id;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
        this.date = date;
        this.time = time;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(Integer patient_id) {
        this.patient_id = patient_id;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
