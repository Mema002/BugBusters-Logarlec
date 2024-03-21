package src.item;

import src.room.Room;
import src.character.Character;

public class Beerglass extends Item {
    private int remainingTime;

    public Beerglass(Room r) {
        super(r);
        this.remainingTime = 5;
    }

    @Override
    public boolean useItem(Character c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
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

    public int getRemainingTime() { //valszeg inkább abstractba kéne overrideolnia mindenkinek
        return remainingTime;
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
