package org.tebogomkhize.projects.servlet;

import java.util.Arrays;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tebogomkhize.projects.common.AuthStatus;
import org.tebogomkhize.projects.controller.AuthController;
import org.tebogomkhize.projects.controller.AuthControllerImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private AuthController authController;

    /**
     * init() method called once when servlet created, before handling
     * requests (doGet, etc.). Used for initialising resources. Helps avoid
     * re-initialising objects (Slow performance).
     * @throws ServletException
     */
    @Override
    public void init() throws ServletException {
        super.init();
        authController = new AuthControllerImpl();
    }

    /**
     * char[] used as it limits scope of String thus making it for garbage
     * collection quicker (Good for safety). char[] can be cleared from mem.
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String username = request.getParameter("username");
        char[] password = request.getParameter("password").toCharArray();

        AuthStatus authStatus = authController.loginUser(username, password);
        Arrays.fill(password, '0');

        switch (authStatus) {
            case INVALID_USERNAME:
            case INVALID_PASSWORD:
                response.sendRedirect("LoginErrInvalidCredentials.jsp");
                break;

            case ADMIN_NOT_CREATED:
                response.sendRedirect("LoginErrAdminNotPresent.jsp");
                break;

            case LOGIN_SUCCESS:
                response.sendRedirect("ProductManagementPage.jsp");
        }
    }
}