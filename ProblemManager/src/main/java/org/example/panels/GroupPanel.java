package org.example.panels;

import org.example.buttons.AddButton;
import org.example.buttons.SubmitButton;
import org.example.utils.Config;
import org.example.utils.Spacer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GroupPanel extends JPanel {

    private int numberOfSpacers = 2;
    private static ButtonGroup buttonGroup;
    private final String[] groups = {"Incepatori", "Intermediari", "Avansati"};

    private JButton submitButton;

    public GroupPanel() {
        super();
        init();
    }

    private void init() {

//        this.setBackground(Color.GREEN);

        Dimension dimension = Config.groupPanelSize;

        this.setMaximumSize(dimension);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setBackground(Config.mainFrameEastPanelColor);

        List<JRadioButton> radioButtonList = new ArrayList<>();
        for(String s : groups)
            radioButtonList.add(new JRadioButton(s));

        buttonGroup = new ButtonGroup();

        for(JRadioButton button : radioButtonList) {
            button.setBackground(Config.mainFrameEastPanelColor);
            buttonGroup.add(button);
            this.add(button);
        }


        for(int i = 1;i <= numberOfSpacers; ++i) {
            JLabel spacer = Spacer.getSpacer(Config.mainEastPanelSize.width, false);
            spacer.setVisible(true);
            this.add(spacer);
        }

        submitButton = new SubmitButton();
        this.add(submitButton);

    }

    public static void resetRadioButtons() {
        buttonGroup.clearSelection();
    }

}
