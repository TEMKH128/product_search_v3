package org.tebogomkhize.projects.servlet;

import java.util.Arrays;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tebogomkhize.projects.common.AuthStatus;
import org.tebogomkhize.projects.controller.AuthController;
import org.tebogomkhize.projects.controller.AuthControllerImpl;


@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    private AuthController authController;

    @Override
    public void init() throws ServletException {
        super.init();
        this.authController = new AuthControllerImpl();
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        char[] password = request.getParameter("password").toCharArray();
        AuthStatus authStatus = this.authController.signupUser(
            username, email, password);

        Arrays.fill(password, '0');

        switch (authStatus) {
            case ADMIN_ALREADY_EXISTS:
                response.sendRedirect("signupErrUserExists.jsp");
                break;

            case SIGNUP_SUCCESS:
                response.sendRedirect("productManagementPage.jsp");
        }
    }
}