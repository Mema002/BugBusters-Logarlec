package src.item;

import src.room.Room;
import src.character.Character;
import src.effect.Gassy;

public class Camembert extends Item {
    public Camembert(Room r) {
        super(r);
    }

    @Override
    public boolean useItem(Character c) {
        owner.getCurrentRoom().addEffect(new Gassy());
        return true;
    }
}
