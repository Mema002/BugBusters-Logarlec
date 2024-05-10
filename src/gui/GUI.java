package src.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import src.character.Character;

public class GUI extends JFrame {
    public TabbedPanel tabpanel;

    public GUI(List<Character> characters, int studentCount) {
        setTitle("BugBusters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<StudentView> cvs = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) { //csak studentcount-nyi characterviewt csinal
            cvs.add(new StudentView(characters.get(i)));
        }

        tabpanel = new TabbedPanel(cvs);
        add(tabpanel);

        setSize(1400, 800);
        setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //pack();
        setVisible(true);
    }
}
