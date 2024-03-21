package src.item;

import src.room.Room;
import src.character.Character;

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
    public void setRemainingTime(int i) {
        remainingTime = i;
    }

    @Override
    public void initItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initItem'");
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
