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

    public int getDurability() {
        return durability;
    }

    /** 
     * Override, megved a gazos effektustol
     * @return boolean
     */
    @Override
    public boolean defendStun() {
        if (isFake) {
            System.out.println(owner.toString() + "'s FFP2 Mask was fake!");
            owner.removeItem(this);
            return false;
        }
        if (durability > 0) {
            durability--;
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
        return "FFP2";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
