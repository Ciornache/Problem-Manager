package org.example.frames;

import org.example.author.Author;
import org.example.author.AuthorRepository;
import org.example.buttons.FormCloseButton;
import org.example.buttons.FormSubmitButton;
import org.example.group.Group;
import org.example.group.GroupRepository;
import org.example.problem.Problem;
import org.example.problem.ProblemRepository;
import org.example.problem.ProblemRepositoryImpl;
import org.example.utils.Config;
import org.example.utils.CrudRepositoryImpl;
import org.example.utils.CrudRepositoryInterface;
import org.example.website.Website;
import org.example.website.WebsiteRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class FormFrame extends JFrame {

    private final List<String> tags = new ArrayList<>();
    private static FormFrame instance = null;

    private FormFrame() {
        super();
        init();
    }

    public static FormFrame getInstance() {
        if(instance == null)
            instance = new FormFrame();
        return instance;
    }

    private void init() {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private  void createAndShowGUI() {
        this.setTitle("Form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Config.formSize);

        JPanel panel = new JPanel(new GridBagLayout());
        this.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Name
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);
        gbc.gridx = 1;
        panel.add(nameField, gbc);

        // Link
        JLabel linkLabel = new JLabel("Link:");
        JTextField linkField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(linkLabel, gbc);
        gbc.gridx = 1;
        panel.add(linkField, gbc);

        // Solution
        JLabel solutionLabel = new JLabel("Solution:");
        JTextField solutionField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(solutionLabel, gbc);
        gbc.gridx = 1;
        panel.add(solutionField, gbc);

        // Difficulty
        JLabel difficultyLabel = new JLabel("Difficulty:");
        JTextField difficultyField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(difficultyLabel, gbc);
        gbc.gridx = 1;
        panel.add(difficultyField, gbc);

        // Author
        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(authorLabel, gbc);
        gbc.gridx = 1;
        panel.add(authorField, gbc);

        // Website
        JLabel websiteLabel = new JLabel("Website:");
        JTextField websiteField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(websiteLabel, gbc);
        gbc.gridx = 1;
        panel.add(websiteField, gbc);

        /// Group
        JLabel groupLabel = new JLabel("Group:");
        JTextField groupField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(groupLabel, gbc);
        gbc.gridx = 1;
        panel.add(groupField, gbc);

        JLabel tagsLabel = new JLabel("Tags:");
        JTextField tagsField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 7; // Adjust the row position
        panel.add(tagsLabel, gbc);
        gbc.gridx = 1;
        panel.add(tagsField, gbc);


        // Submit Button
        JButton submitButton = new FormSubmitButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(submitButton, gbc);

        JButton closeButton = new FormCloseButton("Close");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(closeButton, gbc);


        CrudRepositoryInterface<Author> authorRepository = new AuthorRepository("Author", Author.class);
        CrudRepositoryInterface<Group> groupRepository = new GroupRepository("Grup", Group.class);
        ProblemRepository problemRepository = new ProblemRepositoryImpl();
        WebsiteRepository websiteRepository = new WebsiteRepository("Website", Website.class);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields
                String name = nameField.getText();
                String link = linkField.getText();
                String solution = solutionField.getText();
                String difficulty = difficultyField.getText();
                String authorName = authorField.getText();
                String websiteName = websiteField.getText();
                String groupName = groupField.getText();

                // Display the submitted information
                JOptionPane.showMessageDialog(instance,
                        "Name: " + name + "\nLink: " + link + "\nSolution: " + solution
                                + "\nDifficulty: " + difficulty + "\nAuthor: " + authorName + "\nWebsite: " + websiteName + "\nGroup: " + groupName,
                        "Form Submission",
                        JOptionPane.INFORMATION_MESSAGE);


                ///  public Problem(String name, String link, String solutionLink, int difficulty, Author author, Group group)


                /// Adding the information to the database

                Author author = new Author(authorName);
                Group group = new Group(groupName);
                Website website = new Website(websiteName);
                Problem problem = new Problem(name, link, solution, Integer.decode(difficulty), author, group, website);

                authorRepository.addItem(author);
                groupRepository.addItem(group);
                problemRepository.addItem(problem);
                websiteRepository.addItem(website);

                /// Reseting the fields
                nameField.setText("");
                solutionField.setText("");
                groupField.setText("");
                authorField.setText("");
                websiteField.setText("");
                difficultyField.setText("");
                linkField.setText("");

            }
        });

        // Center the frame on the screen
        this.setLocationRelativeTo(null);

        // Make the frame visible
        this.setVisible(true);
    }
    public List<String> getTags() {
        return tags;
    }
}
