package src.character;
import java.util.ArrayList;
import src.game.ConsoleApp;
import src.gui.CharacterView;
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
        ArrayList<Room> options = currentRoom.getNeighbours();

        //ez még nem kell mert 
        /* int targetIndex;
        if (options.isEmpty()) return;
        if (options.size() == 1) targetIndex = 0;
        else {
            Random random = new Random();
            targetIndex = random.nextInt(options.size() /*+ 1);
        } */

        ArrayList<Character> toExpell = new ArrayList<Character>();

        Room targetRoom = options.get(targetIndex);
        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            setRoom(targetRoom);
            for (Character c : targetRoom.getCharacters()) {
                if (c.tryExpell(this)) {
                    toExpell.add(c);
                }
            }
            toExpell.forEach(c -> c.setExpelled());
        }
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
        return "Teacher" + id;
    }

    @Override
    public CharacterView getView() {
        return new CharacterView(this);
    }
}
