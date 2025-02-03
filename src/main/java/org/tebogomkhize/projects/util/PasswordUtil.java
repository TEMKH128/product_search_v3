package org.tebogomkhize.projects.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordUtil {
    static BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();

    public static String hashPassword(char[] password) {
        return pwdEncoder.encode(new String(password));
    }

    public static boolean passwordMatches(
        char[] rawPassword, String hashedPassword) {

        return pwdEncoder.matches(new String(rawPassword), hashedPassword);
    }
}