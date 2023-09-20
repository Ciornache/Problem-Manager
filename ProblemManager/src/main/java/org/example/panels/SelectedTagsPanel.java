package org.example.panels;

import org.example.buttons.Tag;
import org.example.utils.Config;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SelectedTagsPanel extends JPanel {

    private List<Tag> tagList;

    public SelectedTagsPanel() {
        super();
        init();
    }

    private void init() {

        this.setBackground(Config.mainFrameEastPanelColor);
        this.setLayout(new FlowLayout());
        Dimension dimension = Config.selectedTagsPanelSize;

        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
//        this.setBackground(Color.BLUE);
        tagList = new ArrayList<>();
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public void addToTagList(Tag tag) {
        tagList.add(tag);
        this.add(tag);
        repaint();
        revalidate();
    }

    public void removeFromTagList(Tag tag) {
        tagList.add(tag);
        this.remove(tag);
        repaint();
        revalidate();
    }

}
