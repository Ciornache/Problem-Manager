package org.example.group;

import jakarta.persistence.*;
import org.example.author.Author;
import org.example.tag.Tag;

import java.io.Serializable;

@Entity
@Table(name = "Grup")
@NamedNativeQuery(name = "Grup.selectAll", query = "Select * from grup", resultClass = Group.class)
@NamedNativeQuery(name = "Grup.findById", query = "Select * from grup WHERE id = :id", resultClass = Group.class)
@NamedNativeQuery(name = "Grup.findByName", query = "Select * from grup WHERE name = :name", resultClass = Group.class)
public class Group implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Group() {};

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
