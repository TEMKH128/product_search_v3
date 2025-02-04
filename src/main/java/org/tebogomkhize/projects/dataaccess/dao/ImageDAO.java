package org.tebogomkhize.projects.dataaccess.dao;

import org.hibernate.Session;
import org.tebogomkhize.projects.dataaccess.entity.Product;
import org.tebogomkhize.projects.dto.ImageResult;
import org.tebogomkhize.projects.util.HibernateUtil;


public class ImageDAO {
    public ImageResult findImgById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Product product = session.get(Product.class, id);

            if (product != null && product.getImage() != null) {
                return new ImageResult(true, product.getImage());
            }

            return new ImageResult(false, null);
        }
    }
}