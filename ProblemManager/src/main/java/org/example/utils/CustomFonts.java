package org.example.utils;

import java.awt.Font;
import java.awt.Color;

public class CustomFonts {
    public static Font createButtonFont() {
        // Customize the button font
        return new Font("Helvetica", Font.BOLD, 18);
    }

    public static Font createProblemNameFont() {
        // Customize the problem name font
        return new Font("Helvetica", Font.ITALIC, 22);
    }

    public static Font createDifficultyFont() {
        // Customize the difficulty font
        return new Font("Helvetica", Font.ITALIC, 15);
    }

    public static Font createLinkFont() {
        // Customize the link font
        return new Font("Arial", Font.ITALIC, 15);
    }

    public static Font createProjectTitleFont() {
        // Customize the project title font
        return new Font("Montserrat", Font.BOLD, 28); // Replace "YourDesiredFont" with the actual font name you want to use
    }

    public static Color createBackgroundColor() {
        // Customize the background color
        return new Color(240, 240, 240); // Light Gray
    }
}
