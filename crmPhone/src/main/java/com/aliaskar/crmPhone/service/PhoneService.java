package com.aliaskar.crmPhone.service;

import com.aliaskar.crmPhone.dto.PhoneDto;
import com.aliaskar.crmPhone.model.Customer;
import com.aliaskar.crmPhone.model.Phone;
import com.aliaskar.crmPhone.repository.CustomerRepository;
import com.aliaskar.crmPhone.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 23.05.2022
 */
@Service
public class PhoneService {
    @Autowired
    private final PhoneRepository phoneRepository;
    @Autowired
    private final CustomerRepository customerRepository;

    public PhoneService(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
        this.phoneRepository = phoneRepository;
        this.customerRepository = customerRepository;
    }

    public void createPhone(Customer customer, PhoneDto phoneDto) {

        Phone phone = new Phone();
        phone.setPhoneModel(phoneDto.getPhoneModel());
        phone.setColorOfPhone(phoneDto.getColorOfPhone());
        phone.setDateOfModification(phoneDto.getDateOfModification());
        phone.setDateOfSell(phoneDto.getDateOfSell());
        setDateOfDeadline(phone, phoneDto.getDateOfdeadline(),
                phoneDto.getPriceOfPhone(),
                phoneDto.getFirstAmount(),
                phoneDto.getDateOfSell());

        phone.setCustomer(customer);
        phoneRepository.save(phone);

    }

    private void setDateOfDeadline(Phone phone,
                                   Date dateOfdeadline,
                                   Double priceOfPhone,
                                   Double firstAmount,
                                   Date dateOfSell) {
        phone.setDateOfdeadline(dateOfdeadline);
        phone.setPriceOfPhone(priceOfPhone);
        phone.setFirstAmount(firstAmount);
        phone.setRestOfAmount(priceOfPhone - firstAmount);
        int e = phone.setPeriodOfCredit((int) ((dateOfdeadline.getTime() - dateOfSell.getTime()) / (1000 * 60 * 60 * 24)) / 30);
        if (e >= 1) {
            phone.setTotalAmount((int) (((priceOfPhone - firstAmount) * 30) / 100));
        }
    }

    public PhoneDto getPhoneDtoFromPhone(Phone phone){
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setPhoneModel(phone.getPhoneModel());
        phoneDto.setColorOfPhone(phone.getColorOfPhone());
        phoneDto.setDateOfModification(phone.getDateOfModification());
        phoneDto.setDateOfSell(phone.getDateOfSell());
        phoneDto.setFirstAmount(phone.getFirstAmount());
        phoneDto.setDateOfdeadline(phone.getDateOfdeadline());
        phoneDto.setPeriodOfCredit(phone.getPeriodOfCredit());
        phoneDto.setTotalAmount(phone.getTotalAmount());
        phoneDto.setCustomerId(phone.getId());
        phoneDto.setRestOfAmount(phone.getRestOfAmount());
        phoneDto.setPriceOfPhone(phone.getPriceOfPhone());
        phoneDto.setId(phone.getId());
        return phoneDto;
    }

    public List<PhoneDto> getAllPhones() {
        List<Phone> phones = phoneRepository.findAll();
        List<PhoneDto> phoneDtos = new ArrayList<>();
        phones.forEach(phone -> phoneDtos.add(getPhoneDtoFromPhone(phone)));

        return phoneDtos;
    }

    public void updatePhone(long phoneId,Phone updatedPhone) throws Exception {
        Optional<Phone> phoneOptional = phoneRepository.findById(phoneId);
        if (!phoneOptional.isPresent()){
            throw new Exception("xlaksmxa");
        }
        Phone phones = phoneOptional.get();
        phones.setPhoneModel(updatedPhone.getPhoneModel());
        phones.setDateOfSell(updatedPhone.getDateOfSell());
        setDateOfDeadline(phones, updatedPhone.getDateOfdeadline(),
                updatedPhone.getPriceOfPhone(),
                updatedPhone.getFirstAmount(),
                updatedPhone.getDateOfSell());
        phoneRepository.save(phones);
    }

}
