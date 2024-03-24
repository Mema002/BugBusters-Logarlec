package src.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            setRoom(targetRoom);
            for (Character c : targetRoom.getCharacters()) {
                if (c.tryExpell(this));
            }
        }
    }

    @Override
    public void chooseItem() {
        return;
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
}
