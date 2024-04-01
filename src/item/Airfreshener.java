package src.item;

import src.character.Character;
import src.effect.Effect;

public class Airfreshener extends Item {

    /** 
     * Airfreshener hasznalata, kiszelloztet egy gazos szobat
     * @param c
     * @return boolean
     */
    @Override
    public boolean useItem(Character c) {
        for (Effect e : c.getCurrentRoom().getEffects())
            e.clearGas(c.getCurrentRoom());

        owner.removeItem(this);
        return true;
    }

    @Override
    public String toString() {
        return "Airfreshener";
    }
    
}
