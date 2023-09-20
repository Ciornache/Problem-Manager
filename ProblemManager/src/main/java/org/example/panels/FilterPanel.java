package org.example.panels;

import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

public class FilterPanel extends JPanel {

    private JPanel northPanel;
    private JPanel southPanel;

    private JPanel centerPanel;


    public FilterPanel() {
        super();
        init();
    }
    private void init() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(Config.filterPanelSize);
        this.setBackground(Config.mainFrameEastPanelColor);

        centerPanel = new SelectedTagsPanel();
        this.add(centerPanel, BorderLayout.CENTER);

        northPanel = new TagPanel((SelectedTagsPanel) centerPanel);
        this.add(northPanel, BorderLayout.NORTH);

        southPanel = new GroupPanel();
        this.add(southPanel, BorderLayout.SOUTH);

    }

}
