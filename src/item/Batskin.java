package src.item;

import src.room.Room;
import src.character.Character;

public class Batskin extends Item {
    private int durability;

    public Batskin(Room r) {
        super(r);
        this.durability = 3;
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
        return;
    }

    @Override
    public void initItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initItem'");
    }


    @Override
    public boolean isActive() {
        return false;
    }
    
}
