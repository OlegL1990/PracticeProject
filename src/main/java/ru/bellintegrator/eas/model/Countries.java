package ru.bellintegrator.eas.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Countries")
public class Countries {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> users0) {
        this.employees = employees;
    }

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "code")
    private int code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "citizenshipid", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Employee> employees;


}
