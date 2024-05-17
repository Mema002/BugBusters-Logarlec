package src.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import src.dto.ChangeType;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;
import src.character.Character;

public class RoomView extends JPanel implements ModelObserver {
    private Image background;
    private Room room;
    private ArrayList<ItemView> items;
    private ArrayList<CharacterView> characters;

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
            ImageIcon resizedIcon = resizeIcon(cv.getIcon(), 75, 75);
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

    public void addItemView(ItemView iv) {
        items.add(iv);
    }

    public void removeItemView(ItemView iv) {
        items.remove(iv);
    }

    public void print() {
        System.out.println("Room " + room.getId() + ":");
        for (CharacterView cv : characters) {
            System.out.println(cv.toString());
        }
        System.out.println("Room items:");
        for (ItemView iv : items) {
            System.out.println(iv.toString());
        }
        System.out.println();
    }

    @Override
    public void update(Character character, ChangeType type) {
        CharacterView cv = GUIController.characters.stream().filter(c -> c.getCharacter() == character).findFirst().orElse(null);
        if (cv == null)
            return;
        if (type == ChangeType.ADD) {
            addCharacterView(cv);
        } else if (type == ChangeType.REMOVE) {
            removeCharacterView(cv);
        }
    }

    @Override
    public void update(Item item, ChangeType type) {
        ItemView iv = GUIController.items.stream().filter(i -> i.item == item).findFirst().orElse(null);
        if (iv == null)
            return;
        if (type == ChangeType.ADD) {
            addItemView(iv);
        } else if (type == ChangeType.REMOVE) {
            removeItemView(iv);
        }
    }

    @Override
    public void update(Room room, ChangeType type) {
        return;
    }

    @Override
    public void update(Effect effect, ChangeType type) {
        return;
    }
}
