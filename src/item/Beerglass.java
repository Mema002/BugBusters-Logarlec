package src.item;

import src.room.Room;
import src.character.Character;
import src.character.Teacher;

public class Beerglass extends Item {
    private int remainingTime;

    public Beerglass() {
        super();
        this.remainingTime = 5;
    }

    @Override
    public boolean useItem(Character c) {
        return false;
    }

    @Override
    public void decrRemainingTime() {
        remainingTime -= 1;
    }

    public int getRemainingTime() { //valszeg inkább abstractba kéne overrideolnia mindenkinek
        return remainingTime;
    }

    @Override
    public boolean checkDefense(Teacher attacker) {
        if (remainingTime > 0)
            return true;
        return false;
    }
}
