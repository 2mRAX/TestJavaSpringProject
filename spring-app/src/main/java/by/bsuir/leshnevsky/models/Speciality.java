package by.bsuir.leshnevsky.models;

import javax.persistence.*;

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_speciality")
    private Integer id;
    @Column(name = "name_speciality")
    private String name;

    public Speciality() {
    }

    public Speciality(String name) {
        this.name = name;
    }

    public Speciality(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
