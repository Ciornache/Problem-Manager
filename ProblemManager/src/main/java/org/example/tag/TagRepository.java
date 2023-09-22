package org.example.tag;

import org.example.utils.CrudRepository;

public class TagRepository extends CrudRepository<Tag> {
    public TagRepository(String entityName, Class<Tag> className) {
        super(entityName, className);
    }
}
