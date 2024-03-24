package src.item;

import src.game.ConsoleApp;
import src.game.GameLogic;
import src.room.Room;
import src.character.Character;

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
        ConsoleApp.funcLog("Sliderule to GameLogic endGame");
        GameLogic.endGame();
    }

    @Override
    public String toString() {
        return "Sliderule";
    }
}
