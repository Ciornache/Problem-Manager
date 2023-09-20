package org.example.datacontainer;

import org.example.frames.MainFrame;
import org.example.utils.Config;
import org.example.utils.CustomFonts;
import org.example.utils.RoundedBorder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.List;

public class BigButton extends JButton {
    private final DataContainer dataContainer;

    private final String name;
    public BigButton(String name, DataContainer dataContainer)  {
        super();
        this.name = name;
        this.dataContainer = dataContainer;
        init();
    }

    private void init() {

        this.setSize(Config.bigButtonSize);
        this.setMaximumSize(Config.bigButtonSize);
        this.setMinimumSize(Config.bigButtonSize);
        this.setText(name);
        this.setHorizontalTextPosition(JButton.LEFT);
        this.setHorizontalAlignment(JButton.LEFT);
        this.setVisible(true);
        this.setFont(CustomFonts.createButtonFont());
        this.setFocusPainted(false);
        this.setEnabled(true);
        this.setBorder(new RoundedBorder(30));
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBackground(Color.decode("#331B3F"));
        this.setForeground(Color.decode("#ACC7B4"));

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                List<JLabel> labelList = dataContainer.getLabelList();
                for(JLabel lab : labelList) {
                    lab.setVisible(!lab.isVisible());
                }
                MainFrame.scrollPane.revalidate();
                MainFrame.scrollPane.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setOpaque(true);
                setContentAreaFilled(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(false);
                setContentAreaFilled(false);
            }
        });
    }
}
