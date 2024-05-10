package src.gui;

import javax.swing.ImageIcon;

import src.item.*;

public class ItemView {
    public Item item;
    public ImageIcon icon;

    public ItemView(Airfreshener a) {
        item = a;
        icon = new ImageIcon("images/Airfreshener.png");
    }

    public ItemView(Batskin b) {
        item = b;
        icon = new ImageIcon("images/Batskin.png");
    }

    public ItemView(Beerglass b) {
        item = b;
        icon = new ImageIcon("images/Beerglass.png");
    }

    public ItemView(Camembert c) {
        item = c;
        icon = new ImageIcon("images/Camembert.png");
    }

    public ItemView(FFP2 f) {
        item = f;
        icon = new ImageIcon("images/FFP2.png");
    }

    public ItemView(Rag r) {
        item = r;
        icon = new ImageIcon("images/Rag.png");
    }

    public ItemView(Sliderule s) {
        item = s;
        icon = new ImageIcon("images/Sliderule.png");
    }

    public ItemView(Transistor t) {
        item = t;
        icon = new ImageIcon("images/Transistor.png");
    }

    public String toString() {
        return item.toString();
    }
}

