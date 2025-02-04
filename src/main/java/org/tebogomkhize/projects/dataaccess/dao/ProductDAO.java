package org.tebogomkhize.projects.dataaccess.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.tebogomkhize.projects.util.HibernateUtil;
import org.tebogomkhize.projects.dataaccess.entity.Product;


public class ProductDAO {
    public void saveProduct(
        String size, String title, int quantity, byte[] image) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            Product product = new Product(size, title, quantity, image);

            session.persist(product);

            session.getTransaction().commit();
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "Select p from Product p";
            List<Product> products = session
                .createQuery(hql, Product.class).list();

            return products;
        }
    }

    public void deleteProductById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            String hql = "DELETE FROM Product WHERE id =:id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);

            query.executeUpdate();

            session.getTransaction().commit();
        }
    }

    public Product findProductById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "Select p from Product p WHERE id =:id";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("id", id);

            return query.uniqueResult();
        }
    }

    public void updateProduct(
        int id, String size, String title, int quantity, byte[] image) {

        Product product = findProductById(id);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            product.setSize(size);
            product.setTitle(title);
            product.setQuantity(quantity);

            if (image != null) {
                product.setImage(image);
            }

            session.merge(product);

            session.getTransaction().commit();
        }
    }
}