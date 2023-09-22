package org.example.problem_tag;

import jakarta.persistence.*;
import org.example.problem.Problem;
import org.example.tag.Tag;

import java.io.Serializable;

@Entity
@Table(name = "problem_tag")
public class ProblemTag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    @JoinColumn(name = "tag_id")
    private Tag tag;
    @OneToMany
    @JoinColumn(name = "problem_id")
    private Problem problem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "ProblemTag{" +
                "id=" + id +
                ", tag=" + tag +
                ", problem=" + problem +
                '}';
    }
}
