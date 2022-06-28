package com.aliaskar.crmPhone.repository;

import com.aliaskar.crmPhone.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 28.06.2022
 */
@Repository
public interface RoleRepository extends JpaRepository< Role, Long> {
    @Query(value = "SELECT r FROM Role r WHERE r.nameRole=:role")
    Role findByNameRole(String role);

}
