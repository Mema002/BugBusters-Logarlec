package src.character;

import java.util.ArrayList;
import java.util.List;

import src.game.ConsoleApp;
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
    public void pickUpItem() {
        ArrayList<Item> options = currentRoom.getItems();
        if (options.isEmpty()) return;
        Item chosen = this.chooseItem(); 
        addToInventory(chosen);
        currentRoom.removeItem(chosen);
        chosen.initItem(this);
    }

    @Override
    public void move() {
        ArrayList<Room> options = currentRoom.getNeighbours();
        //choose?
        Room targetRoom = options.get(0);
        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            changeRoom(targetRoom);
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
        if (tryExpell()) {

        }
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

    public boolean checkDefense() {
        for (Item item : inventory){
            if(item.checkDefense())
                return true;
        }
        return false;
    }

    @Override
    public boolean tryExpell() {
        return !checkDefense();
    }

    @Override
    public void endOfRound() {
        for (Item item : inventory) {
            item.decrRemainingTime();
        }
    }
}
