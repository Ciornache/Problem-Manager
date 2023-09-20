    package org.example.datacontainer;

    import org.example.panels.MainFrameCenterPanel;
    import org.example.problem.Problem;
    import org.example.utils.Config;
    import org.example.utils.Spacer;

    import javax.swing.*;
    import javax.xml.crypto.Data;
    import java.awt.*;
    import java.io.DataInput;
    import java.util.ArrayList;
    import java.util.*;
    import java.util.List;

    public class DataContainer {

        private List<JLabel> labelList = new ArrayList<>();

        public DataContainer(JPanel panel) {

            BigButton bigButton = new BigButton("Codeforces", this);
            JLabel spacer = Spacer.getSpacer(25, true);
            labelList.add(spacer);

            panel.add(bigButton);

            Problem pb = new Problem("Liceu", "blla", "adada", 2);
            Problem pb2 = new Problem("Scoala", "sada", "dafas", 3);

            labelList.addAll(pb.convertToLabels());
            labelList.addAll(pb2.convertToLabels());
            labelList.addAll(pb.convertToLabels());
            labelList.addAll(pb2.convertToLabels());
            labelList.addAll(pb.convertToLabels());
            labelList.addAll(pb2.convertToLabels());

            for(JLabel lab : labelList)
                panel.add(lab);

            JLabel label = new JLabel("");

            Dimension dimension = new Dimension(100, 30);

            label.setMaximumSize(dimension);
            label.setMinimumSize(dimension);
            label.setPreferredSize(dimension);

            panel.add(label);
        }

        public List<JLabel> getLabelList() {
            return labelList;
        }
    }
