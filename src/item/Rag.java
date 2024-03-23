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
        remainingTime -= 1;
    }

    private void stunTeachers() { //szekvencián nincs használva

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void drop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drop'");
    }

}
