package com.aliaskar.crmPhone.repository;

import com.aliaskar.crmPhone.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 23.05.2022
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
Customer findByPasport(String pasport);

}
