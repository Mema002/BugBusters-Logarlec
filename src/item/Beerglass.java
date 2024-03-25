package src.item;

import src.character.Character;
import src.character.Teacher;
import src.game.ConsoleApp;

public class Beerglass extends Item {
    private int remainingTime;

    /**
     * Beerglass konstruktor
     */
    public Beerglass() {
        super();
        this.remainingTime = 5;
    }

    /** 
     * Override, beerglass-t nem lehet aktivan hasznalni
     * @param c
     * @return boolean
     */
    @Override
    public boolean useItem(Character c) {
        ConsoleApp.returnLog("return false");
        return false;
    }

    /**
     * Fennmarado ido csokkentese
     */
    @Override
    public void decrRemainingTime() {
        ConsoleApp.returnLog("return");
        remainingTime -= 1;
    }

    /** 
     * Visszater a fennmarado idovel
     * @param attacker
     * @return int
     */
    public int getRemainingTime() { //valszeg inkább abstractba kéne overrideolnia mindenkinek
        ConsoleApp.returnLog("return remainingTime");
        return remainingTime;
    }

    /** 
     * Vedelmet nyujt az attacker ellen
     * @param attacker
     * @return boolean
     */
    @Override
    public boolean checkDefense(Teacher attacker) {
        if (remainingTime > 0) {
            ConsoleApp.returnLog("return true");
            return true;
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public String toString() {
        return "Beerglass";
    }
}
