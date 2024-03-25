package src.item;

import src.game.ConsoleApp;

public class FFP2 extends Item {
    private int durability;

    public FFP2() {
        super();
        this.durability = 3;
    }

    @Override
    public boolean IsUnpaired() {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean defendStun() {
        if(durability > 0) {
            ConsoleApp.returnLog("return true");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "FFP2";
    }
}
