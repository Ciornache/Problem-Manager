package org.example.author;

import org.example.utils.CrudRepositoryImpl;

public class AuthorRepository extends CrudRepositoryImpl<Author> {
    public AuthorRepository(String entityName, Class<Author> className) {
        super(entityName, className);
    }
}
