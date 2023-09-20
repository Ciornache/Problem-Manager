package org.example.panels;

import org.example.datacontainer.DataContainer;
import org.example.utils.Config;
import org.example.utils.CustomFonts;
import org.example.utils.Spacer;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameCenterPanel extends JPanel {

    private JLabel title;

    DataContainer dataContainer;

    public MainFrameCenterPanel() {
//        test();
    }

    public void init() {
        this.setPreferredSize(Config.mainCenterPanelSize);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Config.centerBackgroundColor);

        JLabel spacer = Spacer.getSpacer(30, true);
        spacer.setVisible(true);

        this.add(spacer);

        title = new JLabel("                            Problem Manager");
        title.setFont(CustomFonts.createProjectTitleFont());
        title.setForeground(Config.fontColor);

        this.add(title);

        int totalNumberOfSpacers = 3;
        for(int i = 1;i <= totalNumberOfSpacers; ++i) {
            spacer = Spacer.getSpacer(30, true);
            spacer.setVisible(true);
            this.add(spacer);
        }


        dataContainer = new DataContainer(this);
        DataContainer dataContainer2 = new DataContainer(this);
        DataContainer dataContainer3 = new DataContainer(this);

//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(10, 10));
//        panel.setBackground(Color.BLACK);
//        this.add(panel);
    }

    public void test() {

        JButton button = new JButton("Press me");
        button.setOpaque(false);
        button.setForeground(Color.black);
        button.setPreferredSize(new Dimension(200, 200));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);

        JTextField textField1 = new JTextField();
        textField1.setPreferredSize(new Dimension(200, 100));
        textField1.setBackground(Color.black);

        JTextField textField2 = new JTextField();
        textField2.setPreferredSize(new Dimension(200, 100));
        textField2.setBackground(Color.green);


        this.add(button);
        this.add(textField1);
        this.add(textField2);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setVisible(!textField1.isVisible());
                textField2.setVisible(!textField2.isVisible());
            }
        });

    }

}
