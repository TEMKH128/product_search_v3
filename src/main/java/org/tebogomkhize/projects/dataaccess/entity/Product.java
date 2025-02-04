package org.tebogomkhize.projects.dataaccess.entity;


import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "product")
@Getter @Setter @NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String size;

    private String title;

    @Lob
    private byte[] image;

    private int quantity;


    public Product(String size, String title, int quantity, byte[] image) {
        this.size = size;
        this.title = title;
        this.image = image;
        this.quantity = quantity;
    }
}