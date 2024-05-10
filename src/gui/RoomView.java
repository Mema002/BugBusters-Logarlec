package src.gui;

import src.character.Character;
import src.dto.RoomChangeDto;
import src.dto.RoomChangeType;
import src.item.Item;
import src.room.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RoomView extends JPanel implements Observer {
    private Image background;
    public Room room;
    public ArrayList<ItemView> items;
    public ArrayList<CharacterView> characters;
 
    public RoomView(Room r) {
        room = r;
        items = new ArrayList<>();
        characters = new ArrayList<>();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        try { //hatterkep beolvasas sheesh
            background = ImageIO.read(new File("images/background2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Item i : room.getItems()) { //itemview-k
            items.add(i.getView());
        }

        for (Character c : room.getCharacters()) { //characterview-k
            characters.add(c.getView());
        }

        for (CharacterView cv : characters) { //random bedobálva
            ImageIcon resizedIcon = resizeIcon(cv.icon, 75, 75);
            JLabel label = new JLabel(resizedIcon);
            label.setText(cv.toString());
            label.setForeground(Color.WHITE);
            add(label);
        }

        for (ItemView iv : items) { //random bedobálva
            ImageIcon resizedIcon = resizeIcon(iv.icon, 75, 75);
            JLabel label = new JLabel(resizedIcon);
            label.setText(iv.toString());
            label.setForeground(Color.WHITE);
            add(label);
        }

        room.addObserver(this);
    }

    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void addCharacter(CharacterView cv) {
        characters.add(cv);
    }

    public void removeCharacter(CharacterView cv) {
        characters.remove(cv);
    }
 
    @Override //hatterkep kirajzolas
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // image scaled
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof RoomChangeDto) {
            RoomChangeDto change = (RoomChangeDto) arg;
            if (change.type == RoomChangeType.ADD) {
                CharacterView characterView = GUIController.characters.stream().filter(c -> c.character == change.character).findFirst().get();
                if (characterView != null)
                    characters.add(characterView);
            } else if (change.type == RoomChangeType.REMOVE) {
                CharacterView characterView = GUIController.characters.stream().filter(c -> c.character == change.character).findFirst().get();
                if (characterView != null)
                    characters.remove(characterView);
            }
        }
    }

    public void print() {
        System.out.println("Room " + room.getId() + ":");
        characters.forEach(c -> System.out.println(c));
    }
}
