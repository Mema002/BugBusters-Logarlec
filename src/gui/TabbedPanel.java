package src.gui;

import java.util.ArrayList;

import javax.swing.JTabbedPane;

public class TabbedPanel extends JTabbedPane {
    //tabpanel egy container, paneleket tárol tabos formában
    //ugy gondoltam h minden studentnek legyen egy tabja(panelja)
    //es miután választottak actiont átugrunk a következő tabra
    //es csak a current student tabján klikkelhetőek az action gombok

    public TabbedPanel(ArrayList<StudentView> cvs) {
        for (StudentView cv : cvs) {
            this.addTab(cv.toString(), cv);
        }
    }
}
