package src.item;

import src.game.ConsoleApp;
import src.room.Room;
import src.character.Character;
import src.effect.Gassy;

public class Camembert extends Item {
    public Camembert() {
        super();
    }

    @Override
    public boolean useItem(Character c) {
        ConsoleApp.consoleLog(this, owner.getCurrentRoom(), "Camembert to Room addEffect");
        owner.getCurrentRoom().addEffect(new Gassy());
        return true;
    }

    @Override
    public String toString() {
        return "Camembert";
    }
}
