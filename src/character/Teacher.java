package src.character;
import java.util.ArrayList;
import src.game.ConsoleApp;
import src.item.Item;
import src.room.Room;

public class Teacher extends Character {

    /**
     * Teacher konstruktor
     * @param currentRoom
     * @param id
     */
    public Teacher(Room currentRoom, int id) {
        super(currentRoom);
        this.id = id;
    }
    
    /** 
     * Mozgas a kapott indexu szobaba
     * @param targetIndex
     */
    @Override
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
            for (Character c : targetRoom.getCharacters()) {
                ConsoleApp.funcLog("character.tryExpell(this)");
                if (c.tryExpell(this)) {
                    ConsoleApp.funcLog("character.setExpelled()");
                    c.setExpelled();
                }
            }
        }
        ConsoleApp.returnLog("return");
    }

    
    /** 
     * Automatikus buktatas folyamatat indito fuggveny a paramul kapott studentre
     * @param s
     * @return boolean
     */
    @Override
    public boolean triggerExpelling(Student s) {
        ConsoleApp.funcLog("student.tryExpell(this)");
        if(s.tryExpell(this) && this.stunnedFor==0){
            ConsoleApp.funcLog("student.setExpelled()");
            s.setExpelled();
        }
        ConsoleApp.returnLog("return true");
        return true;
    }
    
    /** 
     * Item kivalasztas fuggveny
     * @return Item
     */
    @Override
    public Item chooseItem() {
        ConsoleApp.funcLog("currentRoom.getItems()");
        ArrayList<Item> il = currentRoom.getItems();
        ConsoleApp.returnLog("return Item");
        return il.get(0); //Jelenleg elég hardcodeolva benne lennie, később itt kelleni fog input.
    }

    @Override
    public String toString() {
        return "Teacher";
    }
}
