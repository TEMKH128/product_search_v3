package org.tebogomkhize.projects.dataaccess.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import org.tebogomkhize.projects.common.AuthStatus;
import org.tebogomkhize.projects.util.PasswordUtil;
import org.tebogomkhize.projects.util.HibernateUtil;
import org.tebogomkhize.projects.dataaccess.entity.Admin;


public class AdminDAO {
    public AuthStatus loginUser(String username, char[] password) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            if (! anyAdminPresent(session)) {
                return AuthStatus.ADMIN_NOT_CREATED;
            }

            if (! validUsernameProvided(session, username)) {
                return AuthStatus.INVALID_USERNAME;
            }

            if (! validPasswordProvided(session, password, username)) {
                return AuthStatus.INVALID_PASSWORD;
            }

            return AuthStatus.LOGIN_SUCCESS;
        }
    }

    private boolean anyAdminPresent(Session session) {
        String hql = "Select a from Admin a";
        List<Admin> admin = session.createQuery(hql, Admin.class).list();

        return ! admin.isEmpty();
    }

    private boolean validUsernameProvided(Session session, String username) {
        String hql = "FROM Admin a WHERE a.username = :username";
        Query<Admin> usernameQuery = session.createQuery(hql, Admin.class);
        usernameQuery.setParameter("username", username);

        return usernameQuery.uniqueResultOptional().isPresent();
    }

    private boolean validPasswordProvided(
        Session session, char[] password, String username) {
        String hql = "SELECT a.password from Admin a WHERE a.username = :username";
        Query<String> passwordQuery = session.createQuery(hql, String.class);
        passwordQuery.setParameter("username", username);

        return PasswordUtil.passwordMatches(password,
            passwordQuery.uniqueResult());
    }

    public AuthStatus signupUser(
        String username, String email, char[] password) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (anyAdminPresent(session)) {
                return AuthStatus.ADMIN_ALREADY_EXISTS;
            }

            session.beginTransaction();

            Admin admin = new Admin(1, username, email,
                PasswordUtil.hashPassword(password));

            session.persist(admin);

            session.getTransaction().commit();

            return AuthStatus.SIGNUP_SUCCESS;
        }
    }
}