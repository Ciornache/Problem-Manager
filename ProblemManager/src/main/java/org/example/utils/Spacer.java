package org.example.utils;

import javax.swing.*;
import java.awt.*;

public class Spacer {

    public Spacer() {

    }

    public static JLabel getSpacer(int offset, boolean type) {

        JLabel spacer = new JLabel("");
        Dimension dimension;

        if(type)
            dimension = new Dimension(0, offset);
        else
            dimension = new Dimension(offset, 10);

        spacer.setPreferredSize(dimension);
        spacer.setMinimumSize(dimension);
        spacer.setMaximumSize(dimension);
        spacer.setVisible(false);
        return spacer;
    }

}
