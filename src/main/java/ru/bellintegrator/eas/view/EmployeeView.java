package ru.bellintegrator.eas.view;



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

    private long docCode;

    private long citizenshipCode;

    private  String docName;

    private  String citizenshipName;

    private  long office;

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

    public long getOffice() {
        return office;
    }

    public void setOffice(long office) {
        this.office = office;
    }

    public long getDocCode() {
        return docCode;
    }

    public void setDocCode(long docCode) {
        this.docCode = docCode;
    }

    public long getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(long citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }
}
