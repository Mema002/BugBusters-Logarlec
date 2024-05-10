package src.item;

import src.character.Character;
import src.effect.Effect;
import src.gui.ItemView;
import src.room.Room;

import java.util.List;

public class Airfreshener extends Item {
    private int durability;


    public Airfreshener(int id, boolean param2, int durability){
        super(id);
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
            //for (Effect e : c.getCurrentRoom().getEffects())
            //    e.clearGas(c.getCurrentRoom());

            List<Effect> GassyEffects = c.getCurrentRoom().getEffects().stream().filter(e -> e.toString().equals("Gassy")).toList();
            for (Effect e : GassyEffects)
                e.clearGas(c.getCurrentRoom());

            c.dropItem(c.getInventory().indexOf(this));

            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Airfreshener";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
    
}
