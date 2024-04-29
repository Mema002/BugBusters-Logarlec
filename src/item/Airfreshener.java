package src.item;

import src.character.Character;
import src.effect.Effect;

public class Airfreshener extends Item {
    private int durability;

    public Airfreshener(Integer.parseInt(int id, int param2, int durability){
        this.id = id;
        this.durability=durability;
    }
    /** 
     * Airfreshener hasznalata, kiszelloztet egy gazos szobat
     * @param c
     * @return boolean
     */
    @Override
    public boolean useItem(Character c) {
        if(durability > 0){
            durability--;
            for (Effect e : c.getCurrentRoom().getEffects())
                e.clearGas(c.getCurrentRoom());
    
            owner.removeItem(this);
            return true;
        }
    }

    @Override
    public String toString() {
        return "Airfreshener";
    }
    
}
