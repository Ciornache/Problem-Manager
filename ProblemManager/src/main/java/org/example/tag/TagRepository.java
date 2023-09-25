package org.example.tag;

import org.example.utils.CrudRepositoryImpl;

public class TagRepository extends CrudRepositoryImpl<Tag> {
    public TagRepository(String entityName, Class<Tag> className) {
        super(entityName, className);
    }
}
