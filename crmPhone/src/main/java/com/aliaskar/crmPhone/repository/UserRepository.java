package com.aliaskar.crmPhone.repository;

import com.aliaskar.crmPhone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 25.05.2022
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
User findByEmail(String email);
}
