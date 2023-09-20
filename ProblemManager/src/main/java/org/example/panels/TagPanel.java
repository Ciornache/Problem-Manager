package org.example.panels;

import org.example.buttons.Tag;
import org.example.utils.Config;
import org.example.utils.CustomFonts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.Objects;

public class TagPanel extends JPanel {

    private static  SelectedTagsPanel selectedTagsPanel = null;

    private final String[] tags = {"-", "Graphs", "Greedy", "DP", "Backtracking", "Binary Search", "Random Tag"};

    private static JComboBox comboBox;

    public TagPanel(SelectedTagsPanel selectedTagsPanel) {
        super();
        TagPanel.selectedTagsPanel = selectedTagsPanel;
        init();
    }

    private void init() {

        this.setBackground(Config.mainFrameEastPanelColor);
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        Dimension dimension = Config.tagPanelSize;

        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
//        this.setBackground(Color.RED);

        dimension = Config.tagPanelComboBoxSize;

        comboBox = new JComboBox(tags);
        comboBox.setPreferredSize(dimension);
        comboBox.setMaximumSize(dimension);
        comboBox.setMinimumSize(dimension);

        JLabel label = new JLabel("  Select tags:        ");
        label.setForeground(Color.BLACK);
        label.setFont(CustomFonts.createButtonFont());

        this.add(label);
        this.add(comboBox);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = comboBox.getSelectedItem().toString();
                if(!Objects.equals(text, "-")) {
                    Tag tagButton = new Tag(text);
                    selectedTagsPanel.addToTagList(tagButton);
                    comboBox.removeItem(text);
                    comboBox.setSelectedIndex(0);
                    revalidate();
                    repaint();
                }

            }
        });

        timer.start();

    }

    public static SelectedTagsPanel getSelectedTagsPanel() {
        return selectedTagsPanel;
    }

    public String[] getTags() {
        return tags;
    }

    public static JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }
}
