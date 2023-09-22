package org.example.group;

import org.example.utils.CrudRepository;

public class GroupRepository extends CrudRepository<Group> {
    public GroupRepository(String entityName, Class<Group> className) {
        super(entityName, className);
    }
}
