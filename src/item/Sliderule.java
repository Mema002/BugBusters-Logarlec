package src.item;

import src.game.ConsoleApp;
import src.game.GameLogic;
import src.gui.ItemView;
import src.character.Character;

public class Sliderule extends Item {
    private boolean isFake;
    int durability;

    public Sliderule(boolean isFake) {
        super();
        this.isFake = isFake;
    }
    public Sliderule(int id, boolean isFake, int durability) {
        super(id);
        this.isFake = isFake;
        this.durability = durability;
    }

    /** 
     * Inicializalja az itemet, egyben veget is vet a jateknak
     * @param c
     */
    @Override
    public void initItem(Character c) {
        owner = c;
        ConsoleApp.returnLog("return");
        if (!isFake) {
            GameLogic.endGame();
            System.out.println(c.toString() + " picked up the Sliderule! The Game is over!");
        }
    }

    @Override
    public String toString() {
        return "Sliderule";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
