package org.tebogomkhize.projects.model;

import org.tebogomkhize.projects.common.AuthStatus;
import org.tebogomkhize.projects.dataaccess.dao.AdminDAO;


public class AuthServiceImpl implements AuthService {
    private AdminDAO adminDAO;

    public AuthServiceImpl() {
        this.adminDAO = new AdminDAO();
    }

    @Override
    public AuthStatus loginUser(String username, char[] password) {
        return this.adminDAO.loginUser(username, password);
    }

    @Override
    public AuthStatus signupUser(String username, String email, char[] password) {
        return this.adminDAO.signupUser(username, email, password);
    }
}