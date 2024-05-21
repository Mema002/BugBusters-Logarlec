package src.effect;

import javax.swing.ImageIcon;

import src.character.Character;
import src.game.ConsoleApp;
import src.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Gassy extends Effect {
    /** 
     * Gassy effektus meghivasa, elgazositja a szobat es
     * stunolja a karaktereket
     * @param r
     */
    @Override
    public void triggerEffect(Room r) {
        ConsoleApp.funcLog("room.getCharacters()");
        List<Character> toMove = new ArrayList<>();
        for(Character c : r.getCharacters()){
            ConsoleApp.funcLog("character.tryStun()");
            if(c.tryStun()) {
                ConsoleApp.funcLog("character.dropItems()");
                c.dropItems();
                ConsoleApp.funcLog("character.beStunnedFor(int: 1)");
                c.beStunnedFor(1);
                if (c.getCurrentRoom().getNeighbours().size() > 0) {
                    toMove.add(c);
                }
            }
        }
        toMove.forEach(c -> c.move(0));
        ConsoleApp.returnLog("return");
    }
    
    /* private void stunCharacters(Room r) { class diagramról, valszeg nem kell

    } */

    @Override
    public String toString() {
        return "Gassy";
    }

    @Override
    public void clearGas(Room r) {
        r.removeEffect(this);
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon("images/Gassy.png");
    }
}
