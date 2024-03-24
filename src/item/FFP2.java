package src.item;

import src.room.Room;

public class FFP2 extends Item {
    private int durability;

    public FFP2() {
        super();
        this.durability = 3;
    }

    @Override
    public boolean IsUnpaired() {
        return false;
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
    public boolean defendStun() {
        if(durability > 0)
            return true;
        return false;
    }
}
