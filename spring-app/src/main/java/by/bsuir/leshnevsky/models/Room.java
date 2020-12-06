package by.bsuir.leshnevsky.models;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Integer id;
    @Column(name = "name_room")
    private String name;
    @Column(name = "number_room")
    private Integer number;

    public Room() {
    }

    public Room(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public Room(Integer id, String name, Integer number) {
        this.id = id;
        this.name = name;
        this.number = number;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
