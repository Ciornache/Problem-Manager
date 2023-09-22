package org.example.author;

import org.example.utils.CrudRepository;

import java.io.Serializable;

public class AuthorRepository extends CrudRepository<Author> {
    public AuthorRepository(String entityName, Class<Author> className) {
        super(entityName, className);
    }
}
