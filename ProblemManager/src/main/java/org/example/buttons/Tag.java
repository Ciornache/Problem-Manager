package org.example.buttons;

import org.example.panels.SelectedTagsPanel;
import org.example.panels.TagPanel;
import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;

public class Tag extends JButton {
    private final String text;

    private final Tag instance = this;

    public Tag(String text) {
        super();
        this.text = text;
        init();
    }

    private void init() {

        Color color = new Color(240, 240, 240);

        this.setText(text);
        this.setForeground(Color.BLACK);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setOpaque(true);
        this.setBackground(Config.mainFrameEastPanelColor);
        repaint();
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);


        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == instance) {
                    SelectedTagsPanel stp = TagPanel.getSelectedTagsPanel();
                    JComboBox comboBox = TagPanel.getComboBox();
                    comboBox.addItem(instance.getText());
                    stp.removeFromTagList(instance);
                    revalidate();
                    repaint();
                }
            }
        });

    }


}
