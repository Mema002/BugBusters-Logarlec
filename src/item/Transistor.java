package src.item;

import src.room.Room;
import src.character.Character;

public class Transistor extends Item {
    private boolean isActive;
    private Transistor pair;

    public Transistor(Room r) {
        super(r);
        this.isActive = false;
        this.pair = null;
    }

    @Override
    public boolean useItem(Character c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    @Override
    public boolean IsUnpaired() {
        return pair == null; //lehet nem pontos a compare
    }

    @Override
    public void decrRemainingTime() {
        return;
    }

    private void activate() { //ha paired akkor lehet csak aktiválni
        if (!IsUnpaired()) isActive = true;
    }

    private void pair(Transistor t) {
        pair = t;
    }

    private Room getPairLocation() { //itembe kene rakni abstractként
        return pair.getCurrentRoom();
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void drop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'drop'");
    }
    
}
