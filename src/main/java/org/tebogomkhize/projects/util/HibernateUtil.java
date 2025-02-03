package org.tebogomkhize.projects.util;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory;

    private static final StandardServiceRegistry registry;


    // Static blocks run once when class is loaded (Not initialised) into
    // JVM (Once, not at initialisation of all objects). Useful for
    // initialising static variables, database connections, etc.
    static {
        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata()
            .buildSessionFactory();
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}