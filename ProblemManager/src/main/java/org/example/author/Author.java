package org.example.author;

import jakarta.persistence.*;
import org.example.problem.Problem;
import org.example.tag.Tag;

import java.io.Serializable;
import java.util.List;
import org.example.utils.Model;

@Entity
@Table(name = "author")
@NamedNativeQuery(name = "Author.selectAll", query = "Select * from author", resultClass = Author.class)
@NamedNativeQuery(name = "Author.findById", query = "Select * from author WHERE id = :id", resultClass = Author.class)
@NamedNativeQuery(name = "Author.findByName", query = "Select * from author WHERE name = :name", resultClass = Author.class)
@NamedNativeQuery(name = "Author.reset", query = "Delete from author")
public class Author extends Model implements Serializable  {

    public Author() {};
    public Author(String name) {
        this.name = name;
    }

}
