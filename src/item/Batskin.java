package src.item;

import src.character.Teacher;
import src.gui.ItemView;

public class Batskin extends Item {
    private int durability;
    private boolean isFake;

     public Batskin(int id, boolean isFake, int durability){
         super(id);
         this.durability = durability;
         this.isFake = isFake;
    }
    /**
     * Batskin konstruktor
     */
    public Batskin(boolean isValid) {
        super();
        this.durability = 3;
        this.isFake = isValid;
    }

    public int getDurability() {
        return durability;
    }

    /** 
     * Vedelmet nyujt az attacker ellen
     * @param attacker
     * @return boolean
     */
    @Override
    public boolean checkDefense(Teacher attacker) {
        if (isFake) {
            System.out.println(owner.toString() + "'s Batskin was fake!");
            owner.removeItem(this);
            return false;
        }
        if (durability > 0) {
            durability--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Batskin";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
