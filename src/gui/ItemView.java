package src.gui;

import java.awt.Color;

import javax.swing.ImageIcon;

import src.item.*;

public class ItemView {
    public Item item;
    private ImageIcon icon;
    private Color color;

    public ItemView(Airfreshener a) {
        item = a;
        icon = new ImageIcon("images/Airfreshener.png");
        color = new Color(102, 214, 242);
    }

    public ItemView(Batskin b) {
        item = b;
        icon = new ImageIcon("images/Batskin.png");
        color = new Color(181, 101, 29);
    }

    public ItemView(Beerglass b) {
        item = b;
        icon = new ImageIcon("images/Beerglass.png");
        color = new Color(238, 216, 24);
    }

    public ItemView(Camembert c) {
        item = c;
        icon = new ImageIcon("images/Camembert.png");
        color = new Color(249, 184, 6);
    }

    public ItemView(FFP2 f) {
        item = f;
        icon = new ImageIcon("images/FFP2.png");
        color = new Color(64, 198, 193);
    }

    public ItemView(Rag r) {
        item = r;
        icon = new ImageIcon("images/Rag.png");
        color = new Color(144, 144, 144);
    }

    public ItemView(Sliderule s) {
        item = s;
        icon = new ImageIcon("images/Sliderule.png");
        color = new Color(230, 0, 0);
    }

    public ItemView(Transistor t) {
        item = t;
        icon = new ImageIcon("images/Transistor.png");
        color = new Color(100, 100, 255);
    }

    public String toString() {
        return item.toString();
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public Color getColor() {
        return color;
    }
}

