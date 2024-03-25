package src.item;

import src.character.Teacher;

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
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "BatSkin";
    }
}
