package org.tebogomkhize.projects.controller;

import java.util.List;
import org.tebogomkhize.projects.model.ProductService;
import org.tebogomkhize.projects.model.ProductServiceImpl;
import org.tebogomkhize.projects.dataaccess.entity.Product;


public class ProductControllerImpl implements ProductController {
    private ProductService productService;

    public ProductControllerImpl() {
        this.productService = new ProductServiceImpl();
    }

    @Override
    public void saveProduct(
        String size, String title, int quantity, byte[] image) {

        this.productService.saveProduct(size, title, quantity, image);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productService.getAllProducts();
    }

    @Override
    public void deleteProductById(int id) {
        this.productService.deleteProductById(id);
    }

    @Override
    public Product findProductById(int id) {
        return this.productService.findProductById(id);
    }

    @Override
    public void updateProduct(
        int id, String size, String title, int quantity, byte[] image) {

        this.productService.updateProduct(id, size, title, quantity, image);
    }
}