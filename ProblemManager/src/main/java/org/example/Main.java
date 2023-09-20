package org.example;


import org.example.frames.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = MainFrame.getInstance(    );
        });
    }
}