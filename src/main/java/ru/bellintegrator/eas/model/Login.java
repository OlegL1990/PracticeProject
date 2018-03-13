package ru.bellintegrator.eas.model;

import javax.persistence.*;


@Entity
@Table(name = "Login")
public class Login {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "login")
    private String login;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "passhash")
    private String passhash;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    public Login(){}
}
