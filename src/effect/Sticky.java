package src.effect;

import src.room.Room;

public class Sticky extends Effect {

    @Override
    public void triggerEffect(Room r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'triggerEffect'");
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
