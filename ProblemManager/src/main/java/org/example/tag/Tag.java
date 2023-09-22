package org.example.tag;

import jakarta.persistence.*;
import org.example.author.Author;

import java.io.Serializable;

@Entity
@Table(name = "tag")
@NamedNativeQuery(name = "Tag.selectAll", query = "Select * from tag", resultClass = Tag.class)
@NamedNativeQuery(name = "Tag.findById", query = "Select * from tag WHERE id = :id", resultClass = Tag.class)
@NamedNativeQuery(name = "Tag.findByName", query = "Select * from tag WHERE name = :name", resultClass = Tag.class)
public class Tag implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Tag() {};

    public Tag(String name) {
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
