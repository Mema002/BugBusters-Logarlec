package src.effect;

import src.character.Character;

public class Gassy extends Effect {

    public Gassy(boolean a) {
        super(a);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void triggerEffect(Character c) {
        if(c.checkStun()) {
            c.dropItems();
            c.beStunnedFor(1);
        }
    }
    
    /* private void stunCharacters(Room r) { class diagramról, valszeg nem kell

    } */
}
