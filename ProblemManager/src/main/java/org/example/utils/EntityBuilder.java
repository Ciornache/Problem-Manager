package org.example.utils;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityBuilder {

    private static EntityManagerFactory instance = null;

    private EntityBuilder() {
        super();
    }

    public static EntityManagerFactory getInstance() {
        if(instance == null) {
            instance = Persistence.createEntityManagerFactory("problem_manager");
        }
        return instance;
    }

}
