package org.example.problem;

import org.example.utils.Config;
import org.example.utils.CustomFonts;
import org.example.utils.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Problem {
    private String name;
    private String link;
    private String solutionLink;
    int difficulty;

    public Problem(String name, String link, String solutionLink, int difficulty) {
        this.name = name;
        this.link = link;
        this.solutionLink = solutionLink;
        this.difficulty = difficulty;
    }

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

}
