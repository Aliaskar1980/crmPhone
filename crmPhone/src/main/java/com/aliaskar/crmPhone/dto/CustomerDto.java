package com.aliaskar.crmPhone.dto;

import com.aliaskar.crmPhone.model.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 23.05.2022
 */
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
public class CustomerDto {
    private  Long id;
    private  String firstName;
    private  String lastName;
    private  String pasport;
    private  String adress;
//    private Date dateOfBirth;
    private List<Phone> phoneList;
}
