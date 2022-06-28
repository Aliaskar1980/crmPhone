package com.aliaskar.crmPhone.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by Admin on 23.05.2022
 */
@Getter
@Setter
public class PhoneDto {
    private Long id;
    private String phoneModel;
    private String colorOfPhone;
    private Date dateOfModification;
    private Double priceOfPhone;
    private Date dateOfSell;
    private int periodOfCredit;
    private Date dateOfdeadline;
    private int totalAmount;
    private Long customerId;
    private Double firstAmount;
    private Double restOfAmount;
}
