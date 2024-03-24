package src.effect;

import src.character.Character;
import src.game.ConsoleApp;
import src.room.Room;

public class Gassy extends Effect {

    public Gassy() {
        super();
    }

    @Override
    public void triggerEffect(Room r) {
        ConsoleApp.funcLog("room.getCharacters()");
        for(Character c : r.getCharacters()){
            ConsoleApp.funcLog("character.tryStun()");
            if(c.tryStun()) {
                ConsoleApp.funcLog("character.dropItems()");
                c.dropItems();
                ConsoleApp.funcLog("character.beStunnedFor(int: 1)");
                c.beStunnedFor(1);
            }
        }
        ConsoleApp.returnLog("return");
    }
    
    /* private void stunCharacters(Room r) { class diagramról, valszeg nem kell

    } */

    @Override
    public String toString() {
        return "Gassy";
    }
}
