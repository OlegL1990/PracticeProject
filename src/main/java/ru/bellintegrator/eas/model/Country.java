package ru.bellintegrator.eas.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @Column(name = "code")
    private Long code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Basic(optional = false)
    @Column(name = "name")
    private String name;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "citizenshipCode", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Employee> employees;


}
