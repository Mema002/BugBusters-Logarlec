package src.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.game.ConsoleApp;
import src.game.GameLogic;
import src.item.Item;
import src.room.Room;

public class Teacher extends Character {

    private int id;
    public Teacher(Room currentRoom, int id) {
        super(currentRoom);
        this.id = id;
    }
    @Override
    public int getId() {
        return id;
    }
    
/*     private void expellStudent(Student s) {
        s.setExpelled();
    } */

    @Override
    public void move(int targetIndex) {
        ConsoleApp.consoleLog(this, currentRoom, "Teacher to Room getNeighbours");
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
        ConsoleApp.consoleLog(this, currentRoom, "Teacher to Room requestChange");
        if (targetRoom.requestChange()) {
            ConsoleApp.consoleLog(this, currentRoom, "Teacher to Room removeCharacter");
            currentRoom.removeCharacter(this);
            ConsoleApp.consoleLog(this, currentRoom, "Teacher to Room addCharacter");
            targetRoom.addCharacter(this);
            setRoom(targetRoom);
            ConsoleApp.consoleLog(this, currentRoom, "Teacher to Room getCharacters");
            for (Character c : targetRoom.getCharacters()) {
                ConsoleApp.consoleLog(this, c, "Teacher to Character tryExpell");
                if (c.tryExpell(this)) {
                    ConsoleApp.consoleLog(this, c, "Teacher to Character setExpelled");
                    c.setExpelled();
                }
            }
        }
    }

    @Override
    public boolean triggerExpelling(Student s) {
        if(s.tryExpell(this) && this.stunnedFor==0){
            s.setExpelled();
        }
        return true;
    }

    @Override
    public boolean tryExpell(Teacher attacker) {
        return false;
    }
    @Override
    public Item chooseItem() {
        ArrayList<Item> il = currentRoom.getItems();
        return il.get(0); //Jelenleg elég hardcodeolva benne lennie, később itt kelleni fog input.
    }
}
