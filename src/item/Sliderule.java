package src.item;

import src.game.ConsoleApp;
import src.game.GameLogic;
import src.character.Character;

import java.io.Console;

public class Sliderule extends Item {

    public Sliderule() {
        super();
    }

    @Override
    public void decrRemainingTime() {
        ConsoleApp.returnLog("return");
        return;
    }

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
