package com.aliaskar.crmPhone.controller;

import com.aliaskar.crmPhone.common.ApiResponse;
import com.aliaskar.crmPhone.dto.CustomerDto;
import com.aliaskar.crmPhone.model.Customer;
import com.aliaskar.crmPhone.repository.CustomerRepository;
import com.aliaskar.crmPhone.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Admin on 23.05.2022
 */
@CrossOrigin("*")
//@Controller
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(new ApiResponse(true, "created new customer"), HttpStatus.OK);
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PutMapping("/editCustomer/{customerId}")
    public ResponseEntity<ApiResponse> editCustomer(@PathVariable("customerId") long customerId, Customer customer) throws Exception {
        if (!customerService.findById(customerId)) {
            return new ResponseEntity<>(new ApiResponse(false, "customer does not exist"), HttpStatus.NOT_FOUND);
        }
        customerService.editCustomer(customerId, customer);
        return new ResponseEntity<>(new ApiResponse(true, "category has been updated"), HttpStatus.OK);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("customerId") long customerId) throws Exception {
        if (!customerService.findById(customerId)) {
            return new ResponseEntity<>(new ApiResponse(false, "customer does not exist"), HttpStatus.NOT_FOUND);
        }
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(new ApiResponse(true, "category has been deleted"), HttpStatus.OK);
    }
}
