package src.effect;

import src.character.Character;
import src.game.ConsoleApp;
import src.room.Room;

public class Gassy extends Effect {

    public Gassy() {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public void triggerEffect(Room r) {
        ConsoleApp.consoleLog(this, r, "Gassy to Room getCharacters");
        for(Character c : r.getCharacters()){
            ConsoleApp.consoleLog(this, c, "Gassy to Character tryStun");
            if(c.tryStun()) {
                ConsoleApp.consoleLog(this, c, "Gassy to Character dropItems");
                c.dropItems();
                ConsoleApp.consoleLog(this, c, "Gassy to Character beStunnedFor");
                c.beStunnedFor(1);
            }
        }
    }
    
    /* private void stunCharacters(Room r) { class diagramról, valszeg nem kell

    } */
}
