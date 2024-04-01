package src.item;

import src.character.Teacher;
import src.game.ConsoleApp;

public class Batskin extends Item {
    private int durability;
    private boolean isFake;

    /**
     * Batskin konstruktor
     */
    public Batskin(boolean isFake) {
        super();
        this.durability = 3;
        this.isFake = isFake;
    }

    /** 
     * Vedelmet nyujt az attacker ellen
     * @param attacker
     * @return boolean
     */
    @Override
    public boolean checkDefense(Teacher attacker) {
        if (durability > 0) {
            durability--;
            ConsoleApp.returnLog("return !isFake");
            return !isFake;
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public String toString() {
        return "BatSkin";
    }
}
