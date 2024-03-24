package src.character;

import java.util.ArrayList;

import src.game.ConsoleApp;
import src.game.GameLogic;
import src.item.Item;
import src.room.Room;

public class Student extends Character {
    private int id;

    public Student(Room currentRoom, int id) {
        super(currentRoom);
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    public void addToInventory(Item i) {
        inventory.add(i);
    }

    public void removeItem(Item i) {
        inventory.remove(i);
        currentRoom.addItem(i);
        i.drop();
    }

    @Override
    public void move(int targetIndex) {
        ArrayList<Room> options = currentRoom.getNeighbours();
        //choose?
        Room targetRoom = options.get(targetIndex);
        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            setRoom(targetRoom);
            for(Character c : targetRoom.getCharacters()){
                c.triggerExpelling(this);
            }
        }
    }

    @Override
    public void useItem(int idx) {
        if(idx >= inventory.size())
            return;
        ConsoleApp.consoleLog(this, inventory.get(idx), "Student - useItem");
        inventory.get(idx).useItem(this);
    }

    @Override
    public Item chooseItem() {
        ArrayList<Item> il = currentRoom.getItems();
        return il.get(0); //Jelenleg elég hardcodeolva benne lennie, később itt kelleni fog input.
    }

    @Override
    public boolean triggerExpelling(Student s) { //param?
        return false;
    }

    @Override
    public boolean tryStun() {
        for (Item item : inventory) {
            if(item.defendStun())
                return true;
        }
        return false;
    }

    @Override
    public boolean tryExpell(Teacher attacker) {
        for (Item item : inventory){
            if(item.checkDefense(attacker))
                return false;
        }
        return true;
    }

    @Override
    public boolean setExpelled(){
        currentRoom.removeCharacter(this);
        expelled=true;
        dropItems();
        GameLogic.removeCharacter(this);
        return true;
    }
}
