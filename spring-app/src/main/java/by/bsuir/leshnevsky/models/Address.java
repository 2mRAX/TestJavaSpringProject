package by.bsuir.leshnevsky.models;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer id;
    @Column(name = "house")
    private String house;
    @Column(name = "flat")
    private String flat;
    @Column(name = "phone")
    private String phone;
    @Column(name = "district_id")
    private Integer district_id;

    public Address() {
    }

    public Address(String house, String flat, String phone, Integer district_id) {
        this.house = house;
        this.flat = flat;
        this.phone = phone;
        this.district_id = district_id;
    }

    public Address(Integer id, String house, String flat, String phone, Integer district_id) {
        this.id = id;
        this.house = house;
        this.flat = flat;
        this.phone = phone;
        this.district_id = district_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }
}
