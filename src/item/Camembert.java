package src.item;

import src.game.ConsoleApp;
import src.character.Character;
import src.effect.Gassy;

public class Camembert extends Item {
    /** 
     * Camembert hasznalata, elgazositja a jelenlegi szobat
     * @param c
     * @return boolean
     */
    @Override
    public boolean useItem(Character c) {
        ConsoleApp.funcLog("owner.getCurrentRoom().addEffect(new Gassy())");
        owner.getCurrentRoom().addEffect(new Gassy());
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public String toString() {
        return "Camembert";
    }
}
