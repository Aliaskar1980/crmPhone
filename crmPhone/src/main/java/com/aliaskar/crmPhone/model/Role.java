package com.aliaskar.crmPhone.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Admin on 28.06.2022
 */
@Entity
@Data
@Table(name = "roles")
@NoArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_role", nullable = false, unique = true)
    private String nameRole;

    @Override
    public String toString() {
        return  nameRole ;
    }
}
