package org.tebogomkhize.projects.dataaccess.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;


@Entity
@Table(name = "admin")
@Getter @NoArgsConstructor @AllArgsConstructor
public class Admin {

    @Id
    private int id;

    private String username;

    private String email;

    private String password;
}