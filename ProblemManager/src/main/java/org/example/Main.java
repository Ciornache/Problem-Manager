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
import org.example.utils.CrudRepositoryInterface;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProblemRepository problemRepository = new ProblemRepositoryImpl();
        CrudRepositoryInterface<Author> authorRepository = new AuthorRepository("Author", Author.class);
        CrudRepositoryInterface<Group> groupRepository = new GroupRepository("Group", Group.class);

        Author author = new Author("Marin Preda");
        Group group = new Group("Intermediate");

        authorRepository.addItem(author);
        groupRepository.addItem(group);

        Problem problem = new Problem("dasda", "fafasdasdas", "fafasdasda", 12, author, group);
        problemRepository.addItem(problem);

//        SwingUtilities.invokeLater(() -> {
//            MainFrame mainFrame = MainFrame.getInstance(    );
//        });
    }
}