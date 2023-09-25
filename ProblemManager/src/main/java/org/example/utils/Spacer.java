package org.example.utils;

import javax.swing.*;
import java.awt.*;

/**
 * The {@code Spacer} class provides utility methods for creating spacer components
 * to add empty space in graphical user interfaces.
 */
public class Spacer {

    /**
     * Constructs a new Spacer instance. This class is intended to be used
     * for static utility methods, so it does not require instantiation.
     */
    private Spacer() {
        // Private constructor to prevent instantiation
    }

    /**
     * Creates a spacer component with the specified offset.
     *
     * @param offset The size of the spacer (width or height, depending on the type).
     * @param type   Specifies the orientation of the spacer:
     *              - {@code true} for a vertical spacer (height).
     *              - {@code false} for a horizontal spacer (width).
     * @return A {@code JLabel} component that serves as a spacer.
     */
    public static JLabel getSpacer(int offset, boolean type) {
        JLabel spacer = new JLabel("");
        Dimension dimension;

        if (type) {
            // Vertical spacer (height)
            dimension = new Dimension(0, offset);
        } else {
            // Horizontal spacer (width)
            dimension = new Dimension(offset, 10);
        }

        spacer.setPreferredSize(dimension);
        spacer.setMinimumSize(dimension);
        spacer.setMaximumSize(dimension);
        spacer.setVisible(false);
        return spacer;
    }
}
