package src.effect;

import src.room.Room;

public abstract class Effect {
    protected boolean active;

    public Effect() {
    }

    public abstract void triggerEffect(Room r);

    public abstract String toString();
}
