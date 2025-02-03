package org.tebogomkhize.projects.controller;

import org.tebogomkhize.projects.common.AuthStatus;


public interface AuthController {
    AuthStatus loginUser(String username, char[] password);

    AuthStatus signupUser(String username, String email, char[] password);
}