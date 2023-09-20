package org.example.panels;

import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;

public class MainFrameWestPanel extends JPanel {

    public MainFrameWestPanel() {
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(Config.offset.x, 0));
        this.setBackground(Config.westBackgroundColor);
    }

}
