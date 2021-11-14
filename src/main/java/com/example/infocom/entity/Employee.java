package com.example.infocom.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table
public class Employee implements Serializable {

    private long id;
    private String fullName;
    private String homePhone;
    private String phone;
    private String homeAddress;
    private String email;
    private long bankDetails;
    private String position;
    private String workPhone;

    @Id
    @Basic
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "home_phone", nullable = false)
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Basic
    @Column(name = "phone", nullable = false)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "home_address", nullable = false)
    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    @Basic
    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "bank_details", nullable = false)
    public long getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(long bankDetails) {
        this.bankDetails = bankDetails;
    }

    @Basic
    @Column(name = "position", nullable = false)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Basic
    @Column(name = "work_phone", nullable = false)
    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (bankDetails != employee.bankDetails) return false;
        if (fullName != null ? !fullName.equals(employee.fullName) : employee.fullName != null) return false;
        if (homePhone != null ? !homePhone.equals(employee.homePhone) : employee.homePhone != null) return false;
        if (phone != null ? !phone.equals(employee.phone) : employee.phone != null) return false;
        if (homeAddress != null ? !homeAddress.equals(employee.homeAddress) : employee.homeAddress != null)
            return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (position != null ? !position.equals(employee.position) : employee.position != null) return false;
        if (workPhone != null ? !workPhone.equals(employee.workPhone) : employee.workPhone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (homeAddress != null ? homeAddress.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (bankDetails ^ (bankDetails >>> 32));
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", phone='" + phone + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", email='" + email + '\'' +
                ", bankDetails=" + bankDetails +
                ", position='" + position + '\'' +
                ", workPhone='" + workPhone + '\'' +
                '}';
    }
}
