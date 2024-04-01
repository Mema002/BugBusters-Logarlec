package src.character;

import java.util.ArrayList;

import src.effect.Effect;
import src.effect.Sticky;
import src.game.ConsoleApp;
import src.item.Item;
import src.room.Room;

public class Janitor extends Character {

    public Janitor(Room currentRoom) {
        super(currentRoom);
    }

    @Override //teacherbol copy paste
    public void move(int targetIndex) {
        ConsoleApp.funcLog("currentRoom.getNeighbours()");
        ArrayList<Room> options = currentRoom.getNeighbours();

        //ez még nem kell mert 
        /* int targetIndex;
        if (options.isEmpty()) return;
        if (options.size() == 1) targetIndex = 0;
        else {
            Random random = new Random();
            targetIndex = random.nextInt(options.size() /*+ 1);
        } */

        Room targetRoom = options.get(targetIndex);
        ConsoleApp.funcLog("targetRoom.requestChange()");
        if (targetRoom.requestChange()) {
            ConsoleApp.funcLog("currentRoom.removeCharacter(this)");
            currentRoom.removeCharacter(this);
            ConsoleApp.funcLog("targetRoom.addCharacter(this)");
            targetRoom.addCharacter(this);
            ConsoleApp.funcLog("setRoom(targetRoom)");
            setRoom(targetRoom);
            ConsoleApp.funcLog("targetRoom.getCharacters()");

            currentRoom.addEffect(new Sticky());

            for (Effect e : targetRoom.getEffects()) {
                e.clearGas(targetRoom);
            }

            for (Character c : targetRoom.getCharacters()) { //kisöprés majd ide

            }
        }
        ConsoleApp.returnLog("return");
    }

    @Override
    public Item chooseItem() {
        return null;
    }

    @Override
    public boolean triggerExpelling(Student s) {
        return false;
    }

    @Override
    public String toString() {
        return "Janitor";
    }
}
