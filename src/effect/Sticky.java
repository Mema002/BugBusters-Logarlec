package src.effect;

import javax.swing.ImageIcon;

import src.room.Room;

public class Sticky extends Effect {

    private int counter=0;
    private boolean isActive=false;

    @Override
    public void triggerEffect(Room r) {
        isActive=true;
    }

    @Override
    public void increaseCounter(Room r) {
        if(isActive) {
            counter++;
        }
    }

    @Override
    public boolean isSticky(Room r) {
        return counter >= 5;
    }

    @Override
    public void clearGas(Room r) {}

    @Override
    public String toString() {
        return "Sticky";
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Sticky.png");
    }

}
