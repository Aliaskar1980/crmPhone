package com.aliaskar.crmPhone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Admin on 22.05.2022
 */

@Entity
@Table(name = "phone")

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneModel;
    private String colorOfPhone;
    private Date dateOfModification;
    private Double priceOfPhone;
    private Double firstAmount;
    private Double restOfAmount;
    private Date dateOfSell;
    private int periodOfCredit;
    private Date dateOfdeadline;
    private int totalAmount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public Double getFirstAmount() {
        return firstAmount;
    }

    public Double getRestOfAmount() {
        return restOfAmount;
    }

    public void setRestOfAmount(Double restOfAmount) {
        this.restOfAmount = restOfAmount;
    }

    public void setFirstAmount(Double firstAmount) {
        this.firstAmount = firstAmount;
    }

    public void setPhoneModel(String phoneModel) {
        this.phoneModel = phoneModel;
    }

    public String getColorOfPhone() {
        return colorOfPhone;
    }

    public void setColorOfPhone(String colorOfPhone) {
        this.colorOfPhone = colorOfPhone;
    }

    public Date getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public Double getPriceOfPhone() {
        return priceOfPhone;
    }

    public void setPriceOfPhone(Double priceOfPhone) {
        this.priceOfPhone = priceOfPhone;
    }

    public Date getDateOfSell() {
        return dateOfSell;
    }

    public void setDateOfSell(Date dateOfSell) {
        this.dateOfSell = dateOfSell;
    }

    public int getPeriodOfCredit() {
        return periodOfCredit;
    }

    public int setPeriodOfCredit(int periodOfCredit) {
        this.periodOfCredit = periodOfCredit;
        return periodOfCredit;
    }

    public Date getDateOfdeadline() {
        return dateOfdeadline;
    }

    public void setDateOfdeadline(Date dateOfdeadline) {
        this.dateOfdeadline = dateOfdeadline;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneModel='" + phoneModel + '\'' +
                ", colorOfPhone='" + colorOfPhone + '\'' +
                ", dateOfModification=" + dateOfModification +
                ", priceOfPhone=" + priceOfPhone +
                ", firstAmount=" + firstAmount +
                ", restOfAmount=" + restOfAmount +
                ", dateOfSell=" + dateOfSell +
                ", periodOfCredit=" + periodOfCredit +
                ", dateOfdeadline=" + dateOfdeadline +
                ", totalAmount=" + totalAmount +
                ", customer=" + customer +
                '}';
    }
}
