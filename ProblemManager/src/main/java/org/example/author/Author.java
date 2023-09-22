package org.example.author;

import jakarta.persistence.*;
import org.example.problem.Problem;
import org.example.tag.Tag;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "author")
@NamedNativeQuery(name = "Author.selectAll", query = "Select * from author", resultClass = Author.class)
@NamedNativeQuery(name = "Author.findById", query = "Select * from author WHERE id = :id", resultClass = Author.class)
@NamedNativeQuery(name = "Author.findByName", query = "Select * from author WHERE name = :name", resultClass = Author.class)
public class Author implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;


    public Author() {};

    public Author(String name) {
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
