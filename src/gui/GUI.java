package src.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import src.character.Character;
import src.dto.ChangeType;
import src.effect.Effect;
import src.game.GameLogic;
import src.item.Item;
import src.room.Room;

public class GUI extends JFrame implements GameLogicObserver{
    public TabbedPanel tabpanel;

    public GUI(List<Character> characters, int studentCount) {
        GameLogic.addObserver(this);
        setTitle("BugBusters");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<StudentView> cvs = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) { //csak studentcount-nyi characterviewt csinal
            StudentView sv = new StudentView(characters.get(i));
            cvs.add(sv);
            GUIController.addStudentView(sv);
            GameLogic.addObserver(sv);
        }

        tabpanel = new TabbedPanel(cvs);
        add(tabpanel);

        setSize(1400, 800);
        setLocationRelativeTo(null);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //pack();
        setVisible(true);
    }
    @Override
    public void update() {
        repaint();
    }

    @Override
    public void update(Character character) {

    }
}
