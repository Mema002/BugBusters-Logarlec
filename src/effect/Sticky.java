package src.effect;

import src.room.Room;

public class Sticky extends Effect {

    @Override
    public void triggerEffect(Room r) {
        return;
    }

    @Override
    public void clearGas(Room r) {
        return;
    }

    @Override
    public String toString() {
        return "Sticky";
    }

}
