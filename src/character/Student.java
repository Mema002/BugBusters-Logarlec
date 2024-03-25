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
        ConsoleApp.funcLog("Student.getId()");
        ConsoleApp.returnLog("return id");
        return this.id;
    }

    public void addToInventory(Item i) {
        ConsoleApp.funcLog("Student.addToInventory(item: i)");
        ConsoleApp.returnLog("return");
        inventory.add(i);
    }

    public void removeItem(Item i) {
        ConsoleApp.funcLog("Student.removeItem(item: i)");
        inventory.remove(i);
        currentRoom.addItem(i);
        i.drop();
        ConsoleApp.returnLog("return");
    }

    @Override
    public void move(int targetIndex) {
        ConsoleApp.funcLog("Student.move(int: targetIdx)");
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
        ConsoleApp.returnLog("return");
    }

    @Override
    public void useItem(int idx) {
        ConsoleApp.funcLog("Student.useItem(int: idx)");
        if(idx >= inventory.size()){
            ConsoleApp.returnLog("return");
            return;
        }
        inventory.get(idx).useItem(this);
        ConsoleApp.returnLog("return");
    }

    @Override
    public Item chooseItem() {
        ConsoleApp.funcLog("Student.chooseItem()");
        ArrayList<Item> il = currentRoom.getItems();
        ConsoleApp.returnLog("return Item");
        return il.get(0); //Jelenleg elég hardcodeolva benne lennie, később itt kelleni fog input.
    }

    @Override
    public boolean triggerExpelling(Student s) { //param?
        ConsoleApp.funcLog("Student.triggerexpelling(Student: s)");
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public boolean tryStun() {
        ConsoleApp.funcLog("Student.tryStun()");
        for (Item item : inventory) {
            if(item.defendStun()){
                ConsoleApp.returnLog("return true");
                return true;
            }
                
        }
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public boolean tryExpell(Teacher attacker) {
        ConsoleApp.funcLog("Student.tryExpell(Teacher: t)");
        for (Item item : inventory){
            if(item.checkDefense(attacker))
            ConsoleApp.returnLog("return false");
                return false;
        }
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public boolean setExpelled(){
        ConsoleApp.funcLog("Student.setExpelled()");
        currentRoom.removeCharacter(this);
        expelled=true;
        dropItems();
        GameLogic.removeCharacter(this);
        ConsoleApp.returnLog("return true");
        return true;
    }
}
