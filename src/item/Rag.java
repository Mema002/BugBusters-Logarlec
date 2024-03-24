package src.item;

import src.character.Teacher;
import src.room.Room;

public class Rag extends Item {
    private int remainingTime;

    public Rag(Room r) {
        super(r);
        this.remainingTime = 5;
    }

    @Override
    public void decrRemainingTime() {
        remainingTime -= 1;
    }

    @Override
    public boolean checkDefense(Teacher attacker){
        if(remainingTime>0){
            attacker.beStunnedFor(1);
            return true;
        }
        return false;
    }
}
