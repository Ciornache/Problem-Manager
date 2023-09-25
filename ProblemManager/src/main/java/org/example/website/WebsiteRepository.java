package org.example.website;

import org.example.utils.CrudRepositoryImpl;

public class WebsiteRepository extends CrudRepositoryImpl<Website> {
    public WebsiteRepository(String entityName, Class<Website> className) {
        super(entityName, className);
    }
}
