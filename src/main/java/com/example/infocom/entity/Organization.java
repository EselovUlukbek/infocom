package com.example.infocom.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Organization implements Serializable {

    private long id;
    private String typeOfOwnership; //forma sobstvennosti
    private String legalForm;        //pravovaya forma
    private String nameOfTheOrganization;  //nazvanie organizatsii
    private String fullnameOfTheHead;       //FIO rukovoditelya
    private String fax;                 // FAX
    private String phone;
    private String webpage;             //web-stranitsa
    private long licenseNumber;       //nomer litsensii (uniq)
    private String dateOfObtainingTheLicense;   //data polycheniya lisensii
    private long certificateNumber;           //nomer svidetelctva
    private String dateOfReceiptOfTheCertificate;    //data polycheniya svidetelstva
    private String address;
    private String filesToAttach;               //faily dlya prikrepleniya


    @Id
    @Basic
    @Column(nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false)
    public String getTypeOfOwnership() {
        return typeOfOwnership;
    }

    public void setTypeOfOwnership(String typeOfOwnership) {
        this.typeOfOwnership = typeOfOwnership;
    }

    @Basic
    @Column(nullable = false)
    public String getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(String legalForm) {
        this.legalForm = legalForm;
    }

    @Basic
    @Column(nullable = false)
    public String getNameOfTheOrganization() {
        return nameOfTheOrganization;
    }

    public void setNameOfTheOrganization(String nameOfTheOrganization) {
        this.nameOfTheOrganization = nameOfTheOrganization;
    }

    @Basic
    @Column(nullable = false)
    public String getFullnameOfTheHead() {
        return fullnameOfTheHead;
    }

    public void setFullnameOfTheHead(String fullnameOfTheHead) {
        this.fullnameOfTheHead = fullnameOfTheHead;
    }

    @Basic
    @Column(nullable = false)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(nullable = false)
    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    @Basic
    @Column(nullable = false, unique = true)
    public long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(long licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Basic
    @Column(nullable = false)
    public String getDateOfObtainingTheLicense() {
        return dateOfObtainingTheLicense;
    }

    public void setDateOfObtainingTheLicense(String dateOfObtainingTheLicense) {
        this.dateOfObtainingTheLicense = dateOfObtainingTheLicense;
    }

    @Basic
    @Column(nullable = false)
    public long getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(long certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    @Basic
    @Column(nullable = false)
    public String getDateOfReceiptOfTheCertificate() {
        return dateOfReceiptOfTheCertificate;
    }

    public void setDateOfReceiptOfTheCertificate(String dateOfReceiptOfTheCertificate) {
        this.dateOfReceiptOfTheCertificate = dateOfReceiptOfTheCertificate;
    }

    @Basic
    @Column(nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(nullable = false)
    public String getFilesToAttach() {
        return filesToAttach;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (id != that.id) return false;
        if (licenseNumber != that.licenseNumber) return false;
        if (certificateNumber != that.certificateNumber) return false;
        if (typeOfOwnership != null ? !typeOfOwnership.equals(that.typeOfOwnership) : that.typeOfOwnership != null)
            return false;
        if (legalForm != null ? !legalForm.equals(that.legalForm) : that.legalForm != null) return false;
        if (nameOfTheOrganization != null ? !nameOfTheOrganization.equals(that.nameOfTheOrganization) : that.nameOfTheOrganization != null)
            return false;
        if (fullnameOfTheHead != null ? !fullnameOfTheHead.equals(that.fullnameOfTheHead) : that.fullnameOfTheHead != null)
            return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (webpage != null ? !webpage.equals(that.webpage) : that.webpage != null) return false;
        if (dateOfObtainingTheLicense != null ? !dateOfObtainingTheLicense.equals(that.dateOfObtainingTheLicense) : that.dateOfObtainingTheLicense != null)
            return false;
        if (dateOfReceiptOfTheCertificate != null ? !dateOfReceiptOfTheCertificate.equals(that.dateOfReceiptOfTheCertificate) : that.dateOfReceiptOfTheCertificate != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        return filesToAttach != null ? filesToAttach.equals(that.filesToAttach) : that.filesToAttach == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (typeOfOwnership != null ? typeOfOwnership.hashCode() : 0);
        result = 31 * result + (legalForm != null ? legalForm.hashCode() : 0);
        result = 31 * result + (nameOfTheOrganization != null ? nameOfTheOrganization.hashCode() : 0);
        result = 31 * result + (fullnameOfTheHead != null ? fullnameOfTheHead.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (webpage != null ? webpage.hashCode() : 0);
        result = 31 * result + (int) (licenseNumber ^ (licenseNumber >>> 32));
        result = 31 * result + (dateOfObtainingTheLicense != null ? dateOfObtainingTheLicense.hashCode() : 0);
        result = 31 * result + (int) (certificateNumber ^ (certificateNumber >>> 32));
        result = 31 * result + (dateOfReceiptOfTheCertificate != null ? dateOfReceiptOfTheCertificate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (filesToAttach != null ? filesToAttach.hashCode() : 0);
        return result;
    }

    public void setFilesToAttach(String filesToAttach) {
        this.filesToAttach = filesToAttach;
    }



    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", typeOfOwnership='" + typeOfOwnership + '\'' +
                ", legalForm='" + legalForm + '\'' +
                ", nameOfTheOrganization='" + nameOfTheOrganization + '\'' +
                ", fullnameOfTheHead='" + fullnameOfTheHead + '\'' +
                ", fax='" + fax + '\'' +
                ", phone='" + phone + '\'' +
                ", webpage='" + webpage + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", dateOfObtainingTheLicense='" + dateOfObtainingTheLicense + '\'' +
                ", certificateNumber='" + certificateNumber + '\'' +
                ", dateOfReceiptOfTheCertificate='" + dateOfReceiptOfTheCertificate + '\'' +
                ", address='" + address + '\'' +
                ", filesToAttach='" + filesToAttach + '\'' +
                '}';
    }
}
