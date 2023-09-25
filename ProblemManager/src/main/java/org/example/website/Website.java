package org.example.website;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.Table;
import org.example.group.Group;
import org.example.utils.Model;

import java.io.Serializable;
@Entity
@Table(name = "Website")
@NamedNativeQuery(name = "Website.selectAll", query = "Select * from website", resultClass = Website.class)
@NamedNativeQuery(name = "Website.findById", query = "Select * from website WHERE id = :id", resultClass = Website.class)
@NamedNativeQuery(name = "Website.findByName", query = "Select * from website WHERE name = :name", resultClass = Website.class)
@NamedNativeQuery(name = "Website.reset", query = "Delete from website")
public class Website extends Model implements Serializable {
    public Website() {};

    public Website(String name) {
        this.name = name;
    }
}
