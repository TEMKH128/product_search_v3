package org.tebogomkhize.projects.dataaccess.entity;

import lombok.Getter;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;


@Entity
@Getter
public class Product {
    @Id
    private long id;
}
