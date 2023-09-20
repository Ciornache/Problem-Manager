package org.example.buttons;

import org.example.panels.GroupPanel;
import org.example.panels.SelectedTagsPanel;
import org.example.panels.TagPanel;
import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SubmitButton extends JButton {


    private final SubmitButton instance = this;

    public SubmitButton() {
        super();
        init();
    }

    private void init() {

        Dimension dimension = new Dimension(Config.submitButtonSize);

        Color color = new Color(240, 240, 240);

        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
        this.setText("Submit");
        this.setForeground(Color.BLACK);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == instance) {

                    SelectedTagsPanel selectedTagsPanel = TagPanel.getSelectedTagsPanel();
                    JComboBox comboBox = TagPanel.getComboBox();

                    List<Tag> tags = new ArrayList<>();
                    tags.addAll(selectedTagsPanel.getTagList());
                    for(Tag tag : tags) {
                        selectedTagsPanel.removeFromTagList(tag);
                        comboBox.addItem(tag.getText());
                    }

                    GroupPanel.resetRadioButtons();

                    repaint();
                    revalidate();

                }
            }
        });

    }

}
