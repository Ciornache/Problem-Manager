package org.example.panels;

import org.example.buttons.AddButton;
import org.example.buttons.DeleteButton;
import org.example.utils.Config;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;

public class MainFrameEastPanel extends JPanel {

    private JPanel southPanel;

    private FilterPanel centerPanel;

    public MainFrameEastPanel() {
        init();
        initButtons();
    }

    private void init() {

        this.setPreferredSize(Config.mainEastPanelSize);
        this.setLayout(new BorderLayout());
        this.initSouthPanel();
        this.setOpaque(true);

        centerPanel = new FilterPanel();
        this.add(centerPanel, BorderLayout.CENTER);


    }

    private void initButtons() {

        AddButton addButton = new AddButton("ADD");
        DeleteButton deleteButton = new DeleteButton("DELETE");

        southPanel.add(addButton);
        southPanel.add(deleteButton);
    }

    private void initSouthPanel() {
        southPanel = new JPanel();
        this.add(southPanel, BorderLayout.SOUTH);
        southPanel.setBackground(Config.mainFrameEastPanelColor);
        southPanel.setOpaque(true);
        southPanel.setVisible(true);

        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));

        Dimension dimension = new Dimension(Config.mainEastPanelSize.width, 200);

        southPanel.setPreferredSize(dimension);
        southPanel.setMaximumSize(dimension);
        southPanel.setMinimumSize(dimension);
    }

}
