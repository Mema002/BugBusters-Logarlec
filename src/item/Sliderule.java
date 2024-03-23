package src.item;

import src.room.Room;

public class Sliderule extends Item {

    public Sliderule(Room r) {
        super(r);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean IsUnpaired() {
        return false;
    }

    @Override
    public void decrRemainingTime() {
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

    @Override
    public void drop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drop'");
    }
    
}
