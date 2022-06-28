package com.aliaskar.crmPhone.repository;

import com.aliaskar.crmPhone.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 23.05.2022
 */
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
