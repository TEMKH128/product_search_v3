package org.tebogomkhize.projects.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tebogomkhize.projects.dto.ImageResult;
import org.tebogomkhize.projects.controller.ImageController;
import org.tebogomkhize.projects.controller.ImageControllerImpl;


@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    private ImageController imageController;

    @Override
    public void init() throws ServletException {
        super.init();
        this.imageController = new ImageControllerImpl();
    }

    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ImageResult imageResult = this.imageController.findImgById(id);

        if (imageResult.isOutcome()) {
            response.setContentType("image/jpeg");
            OutputStream os = response.getOutputStream();
            os.write(imageResult.getImage());
            os.flush();
        }
    }
}