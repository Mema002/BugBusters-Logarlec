package src.item;

import src.game.GameLogic;
import src.room.Room;
import src.character.Character;

public class Sliderule extends Item {

    public Sliderule() {
        super();
    }

    @Override
    public void decrRemainingTime() {
        return;
    }

    @Override
    public void initItem(Character c) {
        owner = c;
        GameLogic.endGame();
    }
}
