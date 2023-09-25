package org.example.group;

import jakarta.persistence.*;
import org.example.author.Author;
import org.example.tag.Tag;
import org.example.utils.Model;

import java.io.Serializable;

@Entity
@Table(name = "Grup")
@NamedNativeQuery(name = "Grup.selectAll", query = "Select * from grup", resultClass = Group.class)
@NamedNativeQuery(name = "Grup.findById", query = "Select * from grup WHERE id = :id", resultClass = Group.class)
@NamedNativeQuery(name = "Grup.findByName", query = "Select * from grup WHERE name = :name", resultClass = Group.class)
@NamedNativeQuery(name = "Grup.reset", query = "Delete from grup")
public class Group extends Model implements Serializable {

    public Group() {};

    public Group(String name) {
        this.name = name;
    }

}
