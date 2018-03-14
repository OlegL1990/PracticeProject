package ru.bellintegrator.eas.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Org")
public class Org {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "full_name")
    private String fullName;

    @Basic(optional = false)
    @Column(name = "inn")
    private String inn;

    @Basic(optional = false)
    @Column(name = "kpp")
    private String kpp;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "org", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Office> offices;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullname) {
        this.fullName = fullname;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }



}
