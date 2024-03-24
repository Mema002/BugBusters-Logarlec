package src.item;

import src.game.ConsoleApp;
import src.room.Room;
import src.character.Character;
import src.effect.Gassy;

public class Camembert extends Item {
    public Camembert(Room r) {
        super(r);
    }

    @Override
    public boolean useItem(Character c) {
        ConsoleApp.consoleLog(this, owner.getCurrentRoom(), "Camembert to Room addEffect");
        owner.getCurrentRoom().addEffect(new Gassy());
        return true;
    }
}
