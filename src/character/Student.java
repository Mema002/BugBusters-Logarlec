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
        ConsoleApp.returnLog("return id");
        return this.id;
    }

    public void addToInventory(Item i) {
        ConsoleApp.returnLog("return");
        inventory.add(i);
    }

    public void removeItem(Item i) {
        inventory.remove(i);
        ConsoleApp.funcLog("currentRoom.addItem(i)");
        currentRoom.addItem(i);
        ConsoleApp.funcLog("i.drop()");
        i.drop();
        ConsoleApp.returnLog("return");
    }

    @Override
    public void move(int targetIndex) {
        ConsoleApp.funcLog("currentRoom.getNeighbours()");
        ArrayList<Room> options = currentRoom.getNeighbours();
        //choose?
        Room targetRoom = options.get(targetIndex);
        ConsoleApp.funcLog("targetRoom.requestChange()");
        if (targetRoom.requestChange()) {
            ConsoleApp.funcLog("currentRoom.removeCharacter(this)");
            currentRoom.removeCharacter(this);
            ConsoleApp.funcLog("targetRoom.addCharacter(this)");
            targetRoom.addCharacter(this);
            ConsoleApp.funcLog("this.setRoom(targetRoom)");
            setRoom(targetRoom);
            ConsoleApp.funcLog("targetRoom.getCharacters()");
            for(Character c : targetRoom.getCharacters()){
                ConsoleApp.funcLog("c.triggerExpelling(this)");
                c.triggerExpelling(this);
            }
        }
        ConsoleApp.returnLog("return");
    }

    @Override
    public void useItem(int idx) {
        if(idx >= inventory.size()){
            ConsoleApp.returnLog("return");
            return;
        }
        ConsoleApp.funcLog("item.useItem(this)");
        inventory.get(idx).useItem(this);
        ConsoleApp.returnLog("return");
    }

    @Override
    public Item chooseItem() {
        ArrayList<Item> il = currentRoom.getItems();
        ConsoleApp.returnLog("return Item");
        return il.get(0); //Jelenleg elég hardcodeolva benne lennie, később itt kelleni fog input.
    }

    @Override
    public boolean triggerExpelling(Student s) { //param?
        ConsoleApp.returnLog("return false");
        return false;
    }

    @Override
    public boolean tryStun() {
        for (Item item : inventory) {
            ConsoleApp.funcLog("item.defendStun()");
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
        for (Item item : inventory){
            ConsoleApp.funcLog("item.checkDefense(attacker)");
            if(item.checkDefense(attacker)){
                ConsoleApp.returnLog("return false");
                return false;
            }

        }
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public boolean setExpelled(){
        ConsoleApp.funcLog("removeCharacter(this)");
        currentRoom.removeCharacter(this);
        expelled=true;
        ConsoleApp.funcLog("dropItems()");
        dropItems();
        ConsoleApp.funcLog("GameLogic.removeCharacter(this)");
        GameLogic.removeCharacter(this);
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public String toString() {
        return "Student";
    }
}
