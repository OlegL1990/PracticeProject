package ru.bellintegrator.eas.view;

public class OfficeView {

    private Long id;

    private String name;

    private String address;

    private String phone;

    private Boolean isActive;

    private long org;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public long getOrg() {
        return org;
    }

    public void setOrg(long org) {
        this.org = org;
    }

}
