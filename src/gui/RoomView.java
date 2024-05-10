package src.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.dto.RoomChangeDto;
import src.dto.RoomChangeType;
import src.item.Item;
import src.room.Room;
import src.character.Character;

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

    @Override //hatterkep kirajzolas
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // image scaled
    }

    public void addCharacterView(CharacterView cv) {
        characters.add(cv);
    }

    public void removeCharacterView(CharacterView cv) {
        characters.remove(cv);
    }

    public void print() {
        System.out.println("Room " + room.getId() + ":");
        for (CharacterView cv : characters) {
            System.out.println(cv.toString());
        }
        for (ItemView iv : items) {
            System.out.println(iv.toString());
        }
        System.out.println();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof RoomChangeDto) {
            RoomChangeDto dto = (RoomChangeDto) arg;
            CharacterView cv = GUIController.characters.stream().filter(c -> c.character == dto.character).findFirst().orElse(null);
            if (cv == null)
                return;
            if (dto.type == RoomChangeType.ADD) {
                if (dto.character != null)
                    addCharacterView(cv);
            } else if (dto.type == RoomChangeType.REMOVE) {
                if (dto.character != null)
                    removeCharacterView(cv);
            }
        }
    }
}
