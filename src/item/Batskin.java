package src.item;

import src.character.Teacher;
import src.room.Room;

public class Batskin extends Item {
    private int durability;

    public Batskin(Room r) {
        super(r);
        this.durability = 3;
    }

    @Override
    public boolean checkDefense(Teacher attacker) {
        if(durability > 0){
            durability--;
            return true;
        }
        return false;
    }
}
