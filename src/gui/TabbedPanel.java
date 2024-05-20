package src.gui;

import src.character.Character;
import src.dto.ChangeType;
import src.effect.Effect;
import src.game.GameLogic;
import src.item.Item;
import src.room.Room;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class TabbedPanel extends JTabbedPane implements ModelObserver {
    //tabpanel egy container, paneleket tárol tabos formában
    //ugy gondoltam h minden studentnek legyen egy tabja(panelja)
    //es miután választottak actiont átugrunk a következő tabra
    //es csak a current student tabján klikkelhetőek az action gombok

    private List<StudentView> studentViews;

    public TabbedPanel(ArrayList<StudentView> svs) {
        GameLogic.addObserver(this);

        studentViews = svs;
        for (int i = 0; i < svs.size(); i++) {
            StudentView sv = svs.get(i);
            this.addTab(null, sv);
            JLabel tabTitle = new JLabel(sv.toString());
            tabTitle.setForeground(Color.BLACK);
            this.setTabComponentAt(i, tabTitle);
        }
    }

    @Override
    public void update() {
        for (int i = 0;i < studentViews.size();i++) {
            if (studentViews.get(i).character == GameLogic.getCurrentPlayer()) {
                this.setSelectedIndex(i);
                this.getTabComponentAt(i).setForeground(Color.RED);
                break;
            } else {
                this.getTabComponentAt(i).setForeground(Color.BLACK);
            }
        }
    }

    @Override
    public void update(Room room, ChangeType type) {

    }

    @Override
    public void update(Character character, ChangeType type) {

    }

    @Override
    public void update(Item item, ChangeType type) {

    }

    @Override
    public void update(Effect effect, ChangeType type) {

    }
}
