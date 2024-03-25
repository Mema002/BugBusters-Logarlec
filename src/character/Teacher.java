package src.character;
import java.util.ArrayList;
import src.game.ConsoleApp;
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
        ConsoleApp.funcLog("Teacher.getId()");
        ConsoleApp.returnLog("return int");
        return id;
    }
    

    @Override
    public void move(int targetIndex) {
        ConsoleApp.funcLog("Teacher.move()");
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
                if (c.tryExpell(this)) {
                    c.setExpelled();
                }
            }
        }
        ConsoleApp.returnLog("return");
    }

    @Override
    public boolean triggerExpelling(Student s) {
        ConsoleApp.funcLog("Teacher.tryExpelling(Student s)");
        if(s.tryExpell(this) && this.stunnedFor==0){
            s.setExpelled();
        }
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public boolean tryExpell(Teacher attacker) {
        ConsoleApp.funcLog("Teacher.tryExpell(Teacher: t)");
        ConsoleApp.returnLog("return false");
        return false;
    }
    @Override
    public Item chooseItem() {
        ConsoleApp.funcLog("Teacher.chooseItem()");
        ArrayList<Item> il = currentRoom.getItems();
        ConsoleApp.returnLog("return Item");
        return il.get(0); //Jelenleg elég hardcodeolva benne lennie, később itt kelleni fog input.
    }

    @Override
    public String toString() {
        return "Teacher";
    }
}
