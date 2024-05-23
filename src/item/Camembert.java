package src.item;

import src.gui.ItemView;
import src.character.Character;
import src.effect.Gassy;

public class Camembert extends Item {
    int durability;
    boolean isFake;
    public Camembert(int id, boolean isFake, int durability) {
        super(id);
        this.durability = durability;
        this.isFake = isFake;
    }
    public Camembert() {
        super();
    }
    /** 
     * Camembert hasznalata, elgazositja a jelenlegi szobat
     * @param c
     * @return boolean
     */

    @Override
    public boolean useItem(Character c) {
        if (isFake) {
            System.out.println(c.toString() + "'s Camembert was fake!");
            c.removeItem(this);
            return false;
        }
        owner.getCurrentRoom().addEffect(new Gassy());
        c.removeItem(this);
        return true;
    }

    public boolean isFake() {
        return isFake;
    }

    @Override
    public String toString() {
        return "Camembert";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
