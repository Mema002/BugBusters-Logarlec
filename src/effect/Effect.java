package src.effect;

import src.room.Room;

public abstract class Effect {
    protected boolean active;

    /**
     * Abstract, effektus meghivasa
     * @param r
     */
    public abstract void triggerEffect(Room r);

    public abstract void clearGas(Room r);

    public abstract String toString();
}
