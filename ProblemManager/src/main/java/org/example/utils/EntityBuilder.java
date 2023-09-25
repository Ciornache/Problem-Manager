package org.example.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * The {@code EntityBuilder} class provides a singleton factory for creating and
 * managing instances of the {@code EntityManagerFactory} in a Java Persistence API (JPA)
 * application.
 */
public class EntityBuilder {

    /**
     * The singleton instance of the {@code EntityManagerFactory}.
     */
    private static EntityManagerFactory instance = null;

    /**
     * Private constructor to prevent direct instantiation of the {@code EntityBuilder} class.
     * This class is intended to be used as a singleton.
     */
    private EntityBuilder() {
        super();
    }

    /**
     * Returns the singleton instance of the {@code EntityManagerFactory}.
     * If the instance does not exist, it will be created.
     *
     * @return The singleton {@code EntityManagerFactory} instance.
     */
    public static EntityManagerFactory getInstance() {
        if (instance == null) {
            // Create the EntityManagerFactory if it doesn't exist
            instance = Persistence.createEntityManagerFactory("problem_manager");
        }
        return instance;
    }
}


