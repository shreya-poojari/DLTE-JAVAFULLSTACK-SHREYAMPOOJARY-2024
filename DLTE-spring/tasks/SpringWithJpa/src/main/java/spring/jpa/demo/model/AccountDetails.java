package spring.jpa.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="userdetails")
public class AccountDetails implements Serializable {
    @Id
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column
    private String Address;
    @Column
    private String emailId;

    @Column
    private Long phoneNumber;

    public AccountDetails() {
    }

    public AccountDetails(String userName, String password, Date dob, String emailId, String address, Long phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.dob = dob;
        this.emailId = emailId;
        Address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dob=" + dob +
                ", emailId='" + emailId + '\'' +
                ", Address='" + Address + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
