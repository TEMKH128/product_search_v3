package org.tebogomkhize.projects.model;

import org.tebogomkhize.projects.common.AuthStatus;


public interface AuthService {
    AuthStatus loginUser(String username, char[] password);

    AuthStatus signupUser(String username, String email, char[] password);
}