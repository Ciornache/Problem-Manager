package org.example.buttons;

import org.example.frames.FormFrame;
import org.example.frames.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;

public class AddButton extends EastButtonParent {

    private final AddButton addButton = this;

    public AddButton(String name) {
        super(name);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addButton) {
                    MainFrame.getInstance().setVisible(false);
                    FormFrame.getInstance().setVisible(true);
                    revalidate();
                    repaint();
                }
            }
        });
    }

}
