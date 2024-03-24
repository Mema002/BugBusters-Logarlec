package src.item;

import src.room.Room;

public class Rag extends Item {
    private int remainingTime;

    public Rag(Room r) {
        super(r);
        this.remainingTime = 5;
    }

    @Override
    public boolean IsUnpaired() {
        return false;
    }

    @Override
    public void decrRemainingTime() {
        this.remainingTime -= 1;
    }

    private void stunTeachers() { //szekvencián nincs használva
    }
}
