package src.item;

import src.room.Room;
import src.character.Character;
import src.effect.Gassy;

public class Camembert extends Item {
    private int remainingTime;

    public Camembert(Room r) {
        super(r);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean useItem(Character c) {
        owner.getCurrentRoom().addEffect(new Gassy());
        return true;
    }

    @Override
    public boolean IsUnpaired() {
        return false;
    }

    @Override
    public void decrRemainingTime() {
        remainingTime -= 1;
    }

    private void makeRoomGassy() {

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
