package src.item;

import src.game.ConsoleApp;

public class FFP2 extends Item {
    private boolean isFake;

    /**
     * FFP2-es maszk konstruktor
     */
    public FFP2(boolean isFake) {
        super();
        this.durability = 3;
        this.isFake = isFake;
    }

    /** 
     * Override, megved a gazos effektustol
     * @return boolean
     */
    @Override
    public boolean defendStun() {
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
        return "FFP2";
    }
}
