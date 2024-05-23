package src.effect;

import javax.swing.ImageIcon;

import src.room.Room;

public abstract class Effect {
    protected boolean active;

    /**
     * Abstract, effektus meghivasa
     * @param r
     */
    public abstract void triggerEffect(Room r);

    public void clearGas(Room r){
        return;
    }

    public boolean canClearGas(Room r){return false;}

    public void clearSticky(Room r) {
        return;
    }

    public void increaseCounter(Room r) {}

    public abstract boolean isSticky(Room r);

    public boolean hasSticky(Room r) {return false;}

    public abstract String toString();

    public abstract ImageIcon getIcon();
}
