package com.aliaskar.crmPhone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 22.05.2022
 */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String pasport;
    private String adress;
//    private Date dateOfBirth;

        @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Phone> phone;

//    public void addPhoneForCustomer(Phone phones) {
//        if (phone == null) {
//            phone = new ArrayList<>();
//        }
//        phone.add(phones);
//        phones.setCustomer(this);
//    }


    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String pasport, String adress, List<Phone> phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pasport = pasport;
        this.adress = adress;
//        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }

//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public List<Phone> getPhone() {
        return phone;
    }

    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pasport='" + pasport + '\'' +
                ", adress='" + adress + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
                ", phone=" + phone +
                '}';
    }
}
