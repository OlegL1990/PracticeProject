package ru.bellintegrator.eas.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Doc_type")
public class Doc_type {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "code")
    private int code;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "docid", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Employee> employees;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }




}
