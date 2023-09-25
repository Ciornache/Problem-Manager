package org.example.group;

import org.example.utils.CrudRepositoryImpl;

public class GroupRepository extends CrudRepositoryImpl<Group> {
    public GroupRepository(String entityName, Class<Group> className) {
        super(entityName, className);
    }
}
