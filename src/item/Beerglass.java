package src.item;

import src.character.Character;
import src.character.Teacher;
import src.game.ConsoleApp;
import src.gui.ItemView;

public class Beerglass extends Item {
    private int remainingTime;
    private boolean isFake;

    /**
     * Beerglass konstruktor
     */
    public Beerglass(int id, boolean isFake, int remainingTime) {
        super();
        this.remainingTime = remainingTime;
        this.isFake = isFake;
    }
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
        if (isFake) {
            System.out.println(owner.toString() + "'s Beerglass was fake!");
            owner.removeItem(this);
            return false;
        }
        if (remainingTime > 0) {
            ConsoleApp.returnLog("return true");
            return true;
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    public boolean isFake() {
        return isFake;
    }

    @Override
    public String toString() {
        return "Beerglass";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
