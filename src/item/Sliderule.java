package src.item;

import src.game.ConsoleApp;
import src.game.GameLogic;
import src.character.Character;

public class Sliderule extends Item {    
    /** 
     * Inicializalja az itemet, egyben veget is vet a jateknak
     * @param c
     */
    @Override
    public void initItem(Character c) {
        owner = c;
        ConsoleApp.returnLog("return");
        GameLogic.endGame();
    }

    @Override
    public String toString() {
        return "Sliderule";
    }
}
