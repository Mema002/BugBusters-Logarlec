package src.item;

import src.room.Room;

public class Batskin extends Item {
    private int durability;

    public Batskin(Room r) {
        super(r);
        this.durability = 3;
    }

    @Override
    public boolean IsUnpaired() {
        return false;
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

    @Override
    public boolean checkDefense() {
        if(durability > 0){
            durability--;
            return true;
        }
        return false;
    }
}
