package src.item;

import src.character.Teacher;
import src.game.ConsoleApp;

public class Batskin extends Item {
    private int durability;
    private boolean isValid;

     public Batskin(int id, boolean isValid, int durability){
         super(id);
         this.durability = durability;
         this.isValid = isValid;
    }
    /**
     * Batskin konstruktor
     */
    public Batskin(boolean isValid) {
        super();
        this.durability = 3;
        this.isValid = isValid;
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
            ConsoleApp.returnLog("return !isValid");
            return isValid;
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public String toString() {
        return "BatSkin";
    }
}
