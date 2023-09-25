package org.example.utils;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Model implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @TableGenerator(name = "your_table_generator", table = "id_generator_table", pkColumnName = "pk_name", valueColumnName = "pk_value", allocationSize = 1)
    protected int id;
    @Column(name = "name")
    protected String name;

    public Model(Model model) {
        this.name = model.getName();
    }

    public Model() {};

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
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void make(Model model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
