package src.gui;

import javax.swing.*;
import java.awt.*;
import src.character.Character;
import src.effect.Cursed;
import src.effect.Effect;
import src.effect.Gassy;
import src.effect.Sticky;
import src.item.Item;
import src.room.Room;

import java.util.ArrayList;
import java.util.List;

public class StudentView extends JPanel {
    public Character character;
    public List<ItemView> inventory;

    public StudentView(Character c) { //ez a jatekos viewja, minden jatekos viewja egy uj tabon
        character = c;
        inventory = new ArrayList<ItemView>();
        Room currentRoom = character.getCurrentRoom();

        for (Item i : character.getInventory()) { //ItemView-ok lekérése character inventoryjából
            inventory.add(i.getView());
        }
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Panel 1: random kép Panel in row=0, col=0
        RoomView room = new RoomView(currentRoom); //igazabol a current room roomview-ja
        gbc.gridx = 0; //a gridben hanyadik oszlop
        gbc.gridy = 0; //a gridben hanyadik sor
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 3;  //oszlop relativ szelesseg
        gbc.weighty = 3; //sor relativ szelesseg
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around the panel
        add(room, gbc);

        // Panel 2: Scrollable Panel in row=0, col=1
        JPanel listPanel1 = new JPanel(new GridLayout(0, 1));  // Using GridLayout for list of panels
        for (Room r : currentRoom.getNeighbours()) {
            JPanel smallPanel = new JPanel();
            smallPanel.setMaximumSize(new Dimension(1000, 75));
            smallPanel.setBackground(new Color((int)(Math.random() * 0x1000000)));

            JLabel label = new JLabel(r.toString() + r.getId());
            smallPanel.add(label);
            listPanel1.add(smallPanel);
        }
        JScrollPane scrollPane1 = new JScrollPane(listPanel1);
        scrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        gbc.gridx = 1;
        gbc.weightx = 1;  // Give more weight to scrollable panels
        gbc.insets = new Insets(10, 10, 10, 10);  // Adjust padding
        add(scrollPane1, gbc);

        // Panel 3: Scrollable Panel in row=0, col=2, similar to Panel 2
        JPanel listPanel2 = new JPanel();
        listPanel2.setLayout(new BoxLayout(listPanel2, BoxLayout.Y_AXIS));
        for (ItemView item : inventory) {
            JPanel smallPanel = new JPanel();
            smallPanel.setMaximumSize(new Dimension(1000, 75));  // Limit the max height
            smallPanel.setBackground(new Color((int)(Math.random() * 0x1000000)));  // Random colors

            JLabel label = new JLabel(item.icon);
            label.setText(item.toString());
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setVerticalTextPosition(JLabel.CENTER);
            smallPanel.add(label);

            listPanel2.add(smallPanel);
        }
        JScrollPane scrollPane2 = new JScrollPane(listPanel2);
        gbc.gridx = 2;
        gbc.insets = new Insets(10, 10, 10, 10);  // Adjust padding
        add(scrollPane2, gbc);

        // Panel 4: szoba tulajdonságai
        JPanel RoomAttributePanel = new JPanel();
        RoomAttributePanel.setLayout(new BoxLayout(RoomAttributePanel, BoxLayout.Y_AXIS));
        
        JLabel szobanevlabel = new JLabel("Jelenlegi szoba: " + currentRoom.toString() + currentRoom.getId());
        RoomAttributePanel.add(szobanevlabel);

        JLabel szobacapacitylabel = new JLabel("Kapacitás: " + currentRoom.getCapacity());
        RoomAttributePanel.add(szobacapacitylabel);

        StringBuilder szobaeffektekstring = new StringBuilder("Effektek: ");
        for (Effect e : currentRoom.getEffects()) {
            szobaeffektekstring.append(e.toString() + " ");
        }
        RoomAttributePanel.add(new JLabel(szobaeffektekstring.toString()));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.2;
        add(RoomAttributePanel, gbc);

        // Panel 5: Button Panel in row=1 spanning the last 2 columns
        JPanel buttonPanel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Button" + i);
            buttonPanel.add(button);
        }
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;  // Span across all columns
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 0.2;  // Adjust weight for the button panel
        gbc.insets = new Insets(10, 10, 10, 10);  // Padding around the panel
        add(buttonPanel, gbc);
    }

    public String toString() {
        return character.toString() + character.getId();
    }
}
