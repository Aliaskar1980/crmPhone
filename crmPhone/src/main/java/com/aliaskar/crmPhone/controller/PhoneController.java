package com.aliaskar.crmPhone.controller;

import com.aliaskar.crmPhone.common.ApiResponse;
import com.aliaskar.crmPhone.dto.PhoneDto;
import com.aliaskar.crmPhone.model.Customer;
import com.aliaskar.crmPhone.model.Phone;
import com.aliaskar.crmPhone.repository.CustomerRepository;
import com.aliaskar.crmPhone.repository.PhoneRepository;
import com.aliaskar.crmPhone.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 23.05.2022
 */
@Controller
@RestController
@RequestMapping("/phone")
public class PhoneController {
    @Autowired
    private final PhoneService phoneService;
    @Autowired
    private final PhoneRepository phoneRepository;
    @Autowired
    private final CustomerRepository customerRepository;

    public PhoneController(PhoneService phoneService, PhoneRepository phoneRepository, CustomerRepository customerRepository) {
        this.phoneService = phoneService;
        this.phoneRepository = phoneRepository;
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createPhone(@RequestBody PhoneDto phoneDto) {
        Optional<Customer> optionalCustomer = customerRepository.findById(phoneDto.getCustomerId());
        if (!optionalCustomer.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Customer not exsist"), HttpStatus.BAD_REQUEST);
        }
        phoneService.createPhone(optionalCustomer.get(), phoneDto);
        return new ResponseEntity<>(new ApiResponse(true, "phone has been added"), HttpStatus.OK);
    }

    @GetMapping("/getAllPhone")
    public ResponseEntity<List<PhoneDto>> getAllPhone() {
        List<PhoneDto> phoneDtos = phoneService.getAllPhones();
        return new ResponseEntity<>(phoneDtos, HttpStatus.OK);
    }
    @PutMapping("/{phoneId}")
    public ResponseEntity<ApiResponse> updatePhone(@PathVariable("phoneId") long phoneId, Phone updatePhone) throws Exception {
        Optional<Phone> phoneOptional = phoneRepository.findById(phoneId);
        if (!phoneOptional.isPresent()){
            return  new ResponseEntity<>(new ApiResponse(false,"phone id not found"),HttpStatus.BAD_REQUEST);
        }
        phoneService.updatePhone(phoneId,updatePhone);
        return  new ResponseEntity<>(new ApiResponse(true, "phone has been updated"), HttpStatus.OK);
    }
}
