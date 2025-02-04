package org.tebogomkhize.projects.model;

import java.util.List;
import org.tebogomkhize.projects.dataaccess.dao.ProductDAO;
import org.tebogomkhize.projects.dataaccess.entity.Product;


public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

     public ProductServiceImpl() {
         this.productDAO = new ProductDAO();
     }


    @Override
    public void saveProduct(
        String size, String title, int quantity, byte[] image) {

         this.productDAO.saveProduct(size, title, quantity, image);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }

    @Override
    public void deleteProductById(int id) {
        this.productDAO.deleteProductById(id);
    }

    @Override
    public Product findProductById(int id) {
        return this.productDAO.findProductById(id);
    }

    @Override
    public void updateProduct(
        int id, String size, String title, int quantity, byte[] image) {

         this.productDAO.updateProduct(id, size, title, quantity, image);
    }
}