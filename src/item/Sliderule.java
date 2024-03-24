package src.item;

import src.game.GameLogic;
import src.room.Room;
import src.character.Character;

public class Sliderule extends Item {

    public Sliderule(Room r) {
        super(r);
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
    public void initItem(Character c) {
        owner = c;
        GameLogic.endGame();
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
