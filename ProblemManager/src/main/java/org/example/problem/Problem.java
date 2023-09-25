package org.example.problem;

import jakarta.persistence.*;
import org.example.author.Author;
import org.example.group.Group;
import org.example.utils.Config;
import org.example.utils.CustomFonts;
import org.example.utils.Spacer;
import org.example.website.Website;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "problem")
@NamedNativeQuery(name = "Problem.selectAll", query = "Select * from problem", resultClass = Problem.class)
@NamedNativeQuery(name = "Problem.findById", query = "Select * from problem WHERE id = :id", resultClass = Problem.class)
@NamedNativeQuery(name = "Problem.findByName", query = "Select * from problem WHERE name = :name", resultClass = Problem.class)
@NamedNativeQuery(name = "Problem.reset", query = "Delete from problem")
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "problem_link")
    private String link;
    @Column(name = "solution_link")
    private String solutionLink;
    @Column(name = "difficulty")
    private int difficulty;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToOne()
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne()
    @JoinColumn(name = "website_id")
    private Website website;

    public Problem(String name, String link, String solutionLink, int difficulty, Author author, Group group, Website website) {
        this.name = name;
        this.link = link;
        this.solutionLink = solutionLink;
        this.difficulty = difficulty;
        this.author = author;
        this.group = group;
        this.website = website;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Problem(String name, String link, String solutionLink, int difficulty) {
        this.name = name;
        this.link = link;
        this.solutionLink = solutionLink;
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", solutionLink='" + solutionLink + '\'' +
                ", difficulty=" + difficulty +
                ", author=" + author +
                ", group=" + group +
                ", website=" + website +
                '}';
    }

    public Problem() {};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSolutionLink() {
        return solutionLink;
    }

    public void setSolutionLink(String solutionLink) {
        this.solutionLink = solutionLink;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<JLabel> convertToLabels() {

        List<JLabel> list = new ArrayList<>();

        JLabel spacer = Spacer.getSpacer(30, true);

        list.add(this.getProblemLabel());
        list.add(this.getDifficultyLabel());
        list.add(this.getLinkLabel());
        list.add(this.getSolutionLabel());

        for(int i = 1;i <= 3; ++i)
            list.add(spacer);

        return list;
    }

    private JLabel getProblemLabel() {
        JLabel label = new JLabel("Nume: "+ name);
        label.setFont(CustomFonts.createProblemNameFont());
        label.setForeground(Config.fontColor);
        label.setVisible(false);
        return label;
    }

    private JLabel getLinkLabel() {
        JLabel label = new JLabel("        Link: "+ link);
        label.setFont(CustomFonts.createLinkFont());
        label.setForeground(Config.fontColor);
        label.setVisible(false);
        return label;
    }

    private JLabel getSolutionLabel() {
        JLabel label = new JLabel("       Solutie: "+ solutionLink);
        label.setFont(CustomFonts.createLinkFont());
        label.setForeground(Config.fontColor);
        label.setVisible(false);
        return label;
    }

    private JLabel getDifficultyLabel() {
        JLabel label = new JLabel("       Dificultate: " + difficulty);
        label.setFont(CustomFonts.createDifficultyFont());
        label.setForeground(Config.fontColor);
        label.setVisible(false);
        return label;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
