package org.tebogomkhize.projects.model;

import java.util.List;
import org.tebogomkhize.projects.dataaccess.entity.Product;


public interface ProductService {
    void saveProduct(String size, String title, int quantity, byte[] image);

    List<Product> getAllProducts();

    void deleteProductById(int id);

    Product findProductById(int id);

    void updateProduct(int id, String size, String title, int quantity, byte[] image);
}