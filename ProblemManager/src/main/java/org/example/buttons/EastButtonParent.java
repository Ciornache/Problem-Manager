package org.example.buttons;

import org.example.frames.MainFrame;
import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class EastButtonParent extends JButton {

    private String text;

    public EastButtonParent(String text) {
        super();
        this.text = text;
        init();
    }

    public EastButtonParent() {};

    private void init() {

        Dimension dimension = new Dimension(Config.parentButtonSize);

        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);

        this.setText(text);
        this.setForeground(Color.BLACK);
        this.setVerticalTextPosition(JButton.CENTER);
        this.setHorizontalTextPosition(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setOpaque(true);
        this.setBackground(Config.parentButtonColor);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setOpaque(false);
                setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(true);
                setContentAreaFilled(false);
            }
        });
    }

}
