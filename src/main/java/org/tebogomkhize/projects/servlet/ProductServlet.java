package org.tebogomkhize.projects.servlet;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;

import org.tebogomkhize.projects.dataaccess.entity.Product;
import org.tebogomkhize.projects.controller.ProductController;
import org.tebogomkhize.projects.controller.ProductControllerImpl;


@WebServlet("/product")
@MultipartConfig(maxFileSize = 2048 * 2048)  // 1MB.
public class ProductServlet extends HttpServlet {

    private ProductController productController;

    @Override
    public void init() throws ServletException {
        this.productController = new ProductControllerImpl();
        super.init();
    }
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        String size = request.getParameter("size");
        String title = request.getParameter("title");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Part filePart = request.getPart("image");
        byte[] image = null;

        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream inputStream = filePart.getInputStream()) {
                image = inputStream.readAllBytes();
            }
        }

        if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            this.productController.updateProduct(id, size, title, quantity,
                image);

        } else {
            this.productController.saveProduct(size, title, quantity, image);
        }

        response.sendRedirect("product");
    }

    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int  id = Integer.parseInt(request.getParameter("id"));
            this.productController.deleteProductById(id);
            response.sendRedirect("product");

        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productController.findProductById(id);

            if (product == null) {
                response.sendRedirect("product");
                return;
            }

            request.setAttribute("product", product);
            request.getRequestDispatcher("editProduct.jsp").forward(request,
                response);

        } else {
            List<Product> products = this.productController.getAllProducts();

            request.setAttribute("products", products);  // Store list in request

            // Forward to JSP
            request.getRequestDispatcher("productManagementPage.jsp").forward(
                request, response);
        }
    }
}