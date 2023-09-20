package org.example.frames;

import org.example.buttons.FormCloseButton;
import org.example.buttons.FormSubmitButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormFrame extends JFrame {

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
        this.setSize(400, 300);

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

        // Submit Button
        JButton submitButton = new FormSubmitButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(submitButton, gbc);

        JButton closeButton = new FormCloseButton("Close");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(closeButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get values from text fields
                String name = nameField.getText();
                String link = linkField.getText();
                String solution = solutionField.getText();
                String difficulty = difficultyField.getText();
                String author = authorField.getText();
                String website = websiteField.getText();

                // Display the submitted information
                JOptionPane.showMessageDialog(instance,
                        "Name: " + name + "\nLink: " + link + "\nSolution: " + solution
                                + "\nDifficulty: " + difficulty + "\nAuthor: " + author + "\nWebsite: " + website,
                        "Form Submission",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Center the frame on the screen
        this.setLocationRelativeTo(null);

        // Make the frame visible
        this.setVisible(true);
    }
}
