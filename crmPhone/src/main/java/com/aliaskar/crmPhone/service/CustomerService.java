package com.aliaskar.crmPhone.service;

import com.aliaskar.crmPhone.dto.CustomerDto;
import com.aliaskar.crmPhone.exception.CustomerException;
import com.aliaskar.crmPhone.model.Customer;
import com.aliaskar.crmPhone.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Admin on 23.05.2022
 */
@Service
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        if (Objects.isNull(customerRepository.findByPasport(customer.getPasport()))) {
            customerRepository.save(customer);
            return;
        }
        throw new CustomerException("Клиент с таким паспортным номером существует");

    }

    public CustomerDto getCustomerDtoFromCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
//        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setAdress(customer.getAdress());
        customerDto.setPasport(customer.getPasport());
        customerDto.setPhoneList(customer.getPhone());
        return customerDto;
    }

    public List<CustomerDto> getAllCustomers() {

        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        customerList.forEach(customerDto -> customerDtos.add(getCustomerDtoFromCustomer(customerDto)));
        return customerDtos;
    }

    public void editCustomer(long customerId, Customer updatCustomer) throws Exception {
        Optional<Customer> customerById = customerRepository.findById(customerId);
        if (!customerById.isPresent()){
        throw new Exception("Клиент не существует");
        }
        Customer customer =customerById.get();

        customer.setFirstName(updatCustomer.getFirstName());
        customer.setLastName(updatCustomer.getLastName());
        customer.setPasport(updatCustomer.getPasport());
        customer.setAdress(updatCustomer.getAdress());
        customerRepository.save(customer);
    }

    public boolean findById(long customerId) {
        return customerRepository.findById(customerId).isPresent();
    }

    public void deleteCustomer(long customerId) throws Exception {
        Optional<Customer> deleteByIdCustomer = customerRepository.findById(customerId);
        if (deleteByIdCustomer.isPresent()){
            customerRepository.deleteById(customerId);
            return;
        }
        throw new Exception("customer not exsist");

    }
}
