package src.item;

import src.character.Teacher;
import src.game.ConsoleApp;
import src.gui.ItemView;

public class Rag extends Item {
    private int remainingTime;
    boolean isFake;

    /**
     * Rag konstruktor
     */
    public Rag() {
        super();
        this.remainingTime = 5;
    }
    public Rag(int id, boolean isFake, int remainingTime) {
        super(id);
        this.isFake = isFake;
        this.remainingTime = remainingTime;
    }

    /**
     * Csokkenti a fennmarado idot
     */
    @Override
    public void decrRemainingTime() {
        ConsoleApp.returnLog("return");
        this.remainingTime -= 1;
    }

    /** 
     * Vedelmet nyujt az attacker ellen
     * @param attacker
     * @return boolean
     */
    @Override
    public boolean checkDefense(Teacher attacker) {
        if (isFake) {
            System.out.println(owner.toString() + "'s Rag was fake!");
            owner.removeItem(this);
            return false;
        }
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
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
