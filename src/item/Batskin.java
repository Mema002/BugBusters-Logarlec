package src.item;

import src.character.Teacher;
import src.game.ConsoleApp;

public class Batskin extends Item {
    private int durability;

    public Batskin() {
        super();
        this.durability = 3;
    }

    @Override
    public boolean checkDefense(Teacher attacker) {
        if(durability > 0){
            durability--;
        ConsoleApp.returnLog("return true");
            return true;
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public String toString() {
        return "BatSkin";
    }
}
