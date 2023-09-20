package org.example.frames;

import org.example.Main;
import org.example.panels.MainFrameCenterPanel;
import org.example.panels.MainFrameEastPanel;
import org.example.panels.MainFrameWestPanel;
import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    public static JScrollPane scrollPane;
    private final String title = "My project";

    private MainFrameCenterPanel centerPanel;
    private MainFrameEastPanel eastPanel;

    private MainFrameWestPanel westPanel;

    private MainFrame() {
        super();
        init();
    }

    public static MainFrame getInstance() {
        if(instance == null)
            instance = new MainFrame();
        return instance;
    }

    private void init() {

        this.setTitle(title);
        this.setLayout(new BorderLayout());
        this.setSize(Config.windowSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        centerPanel = new MainFrameCenterPanel();
        eastPanel = new MainFrameEastPanel();
        westPanel = new MainFrameWestPanel();

        scrollPane = new JScrollPane(centerPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        centerPanel.init();

        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.decode("#331B3F"));

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public MainFrameCenterPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(MainFrameCenterPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public MainFrameEastPanel getEastPanel() {
        return eastPanel;
    }

    public void setEastPanel(MainFrameEastPanel eastPanel) {
        this.eastPanel = eastPanel;
    }
}
