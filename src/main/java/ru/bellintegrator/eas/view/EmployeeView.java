package ru.bellintegrator.eas.view;

import ru.bellintegrator.eas.model.Countries;
import ru.bellintegrator.eas.model.Docs;
import ru.bellintegrator.eas.model.Office;

import java.util.Date;

public class EmployeeView {

    private Long id;

    private String firstName;

    private String secondName;

    private String middleName;

    private String position;

    private String phone;

    private Boolean isIdentified;

    private String docNumber;

    private Date docDate;

    private Office office;

    private Docs docid;

    private Countries citizenshipid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Docs getDocid() {
        return docid;
    }

    public void setDocid(Docs docid) {
        this.docid = docid;
    }

    public Countries getCitizenshipid() {
        return citizenshipid;
    }

    public void setCitizenshipid(Countries citizenshipid) {
        this.citizenshipid = citizenshipid;
    }
}