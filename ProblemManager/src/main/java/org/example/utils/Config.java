package org.example.utils;

import org.example.author.Author;
import org.example.author.AuthorRepository;
import org.example.group.Group;
import org.example.group.GroupRepository;
import org.example.problem.ProblemRepository;
import org.example.problem.ProblemRepositoryImpl;
import org.example.problem_tag.ProblemTagRepository;
import org.example.problem_tag.ProblemTagRepositoryImpl;
import org.example.tag.Tag;
import org.example.tag.TagRepository;
import org.example.website.Website;
import org.example.website.WebsiteRepository;

import javax.swing.*;
import java.awt.*;

public class Config {
    public static Dimension windowSize;
    public static Dimension formSize;
    public static Dimension mainCenterPanelSize;
    public static Dimension mainEastPanelSize;
    public static Dimension tagPanelSize;
    public static Dimension selectedTagsPanelSize;
    public static Dimension groupPanelSize;
    public static Dimension filterPanelSize;
    public static Dimension parentButtonSize;
    public static Dimension submitButtonSize;
    public static Dimension bigButtonSize;
    public static Dimension tagPanelComboBoxSize;
    public static Point offset;
    public static Color fontColor;
    public static Color centerBackgroundColor;
    public static Color westBackgroundColor;
    public static Color mainFrameEastPanelColor;
    public static Color mainFrameEastPanelTextColor;
    public static Color parentButtonColor;



    static {

        /// Frame's dimensions \\\

        windowSize = new Dimension(1200, 10000);
        formSize = new Dimension(400, 400);

        /// Panel's dimensions \\\

        mainCenterPanelSize = new Dimension((windowSize.width * 2) / 3, windowSize.height);
        mainEastPanelSize = new Dimension(windowSize.width / 3, windowSize.height);
        tagPanelSize = new Dimension(mainEastPanelSize.width, 200);
        selectedTagsPanelSize = new Dimension(mainEastPanelSize.width / 2, 100);
        groupPanelSize = new Dimension(mainEastPanelSize.width, 100);
        filterPanelSize = new Dimension(mainEastPanelSize.width, mainEastPanelSize.height - 200);

        /// Buttons \\\

        parentButtonSize = new Dimension(mainEastPanelSize.width / 2, 100);
        submitButtonSize = new Dimension(mainEastPanelSize.width / 3, 25);
        bigButtonSize = new Dimension(new Dimension(2 * Config.mainCenterPanelSize.width / 3, 40));

        /// JComboBox Dimension \\\

        tagPanelComboBoxSize = new Dimension(mainEastPanelSize.width / 2, 20);

        /// Offsets for spacer labels \\\

        offset = new Point(40, 150);

        /// Colors \\\

        centerBackgroundColor = Color.decode("#331B3F");
        fontColor = Color.decode("#ACC7B4");
        westBackgroundColor = Color.decode("#331B3F");
        mainFrameEastPanelColor = new Color( 210, 210, 230);
        mainFrameEastPanelTextColor = new Color(90, 0, 90);
        parentButtonColor = new Color(180, 180, 200);

    }

    public static void resetDatabase()  {

        ProblemTagRepositoryImpl.reset();
        ProblemRepositoryImpl.reset();

        AuthorRepository authorRepository = new AuthorRepository("Author", Author.class);
        authorRepository.reset();

        GroupRepository groupRepository = new GroupRepository("Grup", Group.class);
        groupRepository.reset();

        TagRepository tagRepository = new TagRepository("Tag", Tag.class);
        tagRepository.reset();

        WebsiteRepository websiteRepository = new WebsiteRepository("Website", Website.class);
        websiteRepository.reset();

    }
}
