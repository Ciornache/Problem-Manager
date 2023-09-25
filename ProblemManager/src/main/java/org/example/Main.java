package org.example;


import org.example.author.Author;
import org.example.author.AuthorRepository;
import org.example.frames.MainFrame;
import org.example.group.Group;
import org.example.group.GroupRepository;
import org.example.problem.Problem;
import org.example.problem.ProblemRepository;
import org.example.problem.ProblemRepositoryImpl;
import org.example.tag.Tag;
import org.example.tag.TagRepository;
import org.example.utils.Config;
import org.example.utils.CrudRepositoryInterface;

import javax.swing.*;
import java.util.List;

public class Main {

    ////TODO: Refactor the form a bit
    ////TODO: Add more documentation
    ////TODO: Implement the search functionality
    ////TODO: Make the form look a little bit better
    ////TODO: Refactor where needed
    ////TODO: This is for Tuesday and Wednesday

    public static void main(String[] args) {
        Config.resetDatabase();
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = MainFrame.getInstance(    );
        });
    }
}