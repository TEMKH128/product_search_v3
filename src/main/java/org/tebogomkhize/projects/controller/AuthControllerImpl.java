package org.tebogomkhize.projects.controller;

import org.tebogomkhize.projects.common.AuthStatus;
import org.tebogomkhize.projects.model.AuthService;
import org.tebogomkhize.projects.model.AuthServiceImpl;


public class AuthControllerImpl implements AuthController {
    private AuthService authService;


    public AuthControllerImpl() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    public AuthStatus loginUser(String username, char[] password) {
        return this.authService.loginUser(username, password);
    }

    @Override
    public AuthStatus signupUser(String username, String email, char[] password) {
        return this.authService.signupUser(username, email, password);
    }
}