package src.effect;

import src.character.Character;
import src.room.Room;

public class Gassy extends Effect {

    public Gassy() {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public void triggerEffect(Room r) {
        for(Character c : r.getCharacters()){
            if(c.checkStun()) {
                c.dropItems();
                c.beStunnedFor(1);
            }
        }
    }
    
    /* private void stunCharacters(Room r) { class diagramról, valszeg nem kell

    } */
}
