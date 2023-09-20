package org.example.buttons;

import org.example.frames.FormFrame;
import org.example.frames.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormCloseButton extends JButton {

    private FormCloseButton instance = this;
    private final String text;

    public FormCloseButton(String text)
    {
        super(text);
        this.text = text;
        init();
    }

    private void init() {
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == instance) {
                    MainFrame.getInstance().setVisible(true);
                    FormFrame.getInstance().setVisible(false);
                    revalidate();
                    repaint();
                }
            }
        });
    }

}
