package src.effect;

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

    public void clearSticky(Room r) {
        return;
    }

    public abstract String toString();
}
