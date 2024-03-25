package src.item;

import src.character.Teacher;
import src.game.ConsoleApp;

public class Rag extends Item {
    private int remainingTime;

    public Rag() {
        super();
        this.remainingTime = 5;
    }

    @Override
    public void decrRemainingTime() {
        ConsoleApp.returnLog("return");
        this.remainingTime -= 1;
    }

    @Override
    public boolean checkDefense(Teacher attacker){
        if (remainingTime > 0) {
            ConsoleApp.funcLog("attacker.beStunnedFor(1)");
            attacker.beStunnedFor(1);
            ConsoleApp.returnLog("return true");
            return true;
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public String toString() {
        return "Rag";
    }
}
