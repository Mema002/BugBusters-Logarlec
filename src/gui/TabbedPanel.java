package src.gui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class TabbedPanel extends JTabbedPane {
    //tabpanel egy container, paneleket tárol tabos formában
    //ugy gondoltam h minden studentnek legyen egy tabja(panelja)
    //es miután választottak actiont átugrunk a következő tabra
    //es csak a current student tabján klikkelhetőek az action gombok

    public TabbedPanel(ArrayList<StudentView> svs) {
        for (int i = 0; i < svs.size(); i++) {
            StudentView sv = svs.get(i);
            this.addTab(null, sv);
            JLabel tabTitle = new JLabel(sv.toString());
            tabTitle.setForeground(Color.RED);
            this.setTabComponentAt(i, tabTitle);
        }
        JLabel tabTitle = new JLabel(svs.get(1).toString());
        tabTitle.setForeground(Color.BLACK);
        this.setTabComponentAt(1, tabTitle);
    }
}
