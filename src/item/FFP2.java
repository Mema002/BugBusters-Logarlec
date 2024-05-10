package src.item;

import src.game.ConsoleApp;
import src.gui.ItemView;

public class FFP2 extends Item {
    private boolean isFake;
    int durability;

    /**
     * FFP2-es maszk konstruktor
     */
    public FFP2(boolean isFake) {
        super();
        this.durability = 3;
        this.isFake = isFake;
    }
    public FFP2(int id, boolean isFake, int durability) {
        super(id);
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
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
