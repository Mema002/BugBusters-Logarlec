package src.effect;

import src.character.Character;
import src.room.Room;

public abstract class Effect {
    protected boolean active;

    public Effect() {
    }

    public abstract void triggerEffect(Room r);
}
