package by.bsuir.leshnevsky.models;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_district")
    private Integer id;
    @Column(name = "street")
    private String street;
    @Column(name = "number_district")
    private Integer number_district;

    public District() {
    }

    public District(String street, Integer number_district) {
        this.street = street;
        this.number_district = number_district;
    }

    public District(Integer id, String street, Integer number_district) {
        this.id = id;
        this.street = street;
        this.number_district = number_district;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber_district() {
        return number_district;
    }

    public void setNumber_district(Integer number_district) {
        this.number_district = number_district;
    }
}
