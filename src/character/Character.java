package src.character;

import java.util.ArrayList;

import src.game.ConsoleApp;
import src.item.Item;
import src.room.Room;

public abstract class Character {

    protected ArrayList<Item> inventory;
    protected Room currentRoom;
    protected int stunnedFor;
    protected boolean expelled;

    public Character(Room currentRoom) {
        this.inventory = new ArrayList<Item>();
        this.currentRoom = currentRoom;
        this.stunnedFor = 0;
        this.expelled = false;
    }

    public abstract int getId();

    public void addToInventory(Item i) {
        ConsoleApp.funcLog("Character.addToInventory(Item: i)");
        ConsoleApp.returnLog("return");
        inventory.add(i);
    }

    public void removeItem(Item i) {
        ConsoleApp.funcLog("Character.removeInventory(Item: i)");
        ConsoleApp.returnLog("return");
        inventory.remove(i);
    }

    public ArrayList<Item> getInventory() {
        ConsoleApp.funcLog("Character.getInventory()");
        ConsoleApp.returnLog("return inventory");
        return inventory;
    }

    public Room getCurrentRoom() {
        ConsoleApp.funcLog("Character.getCurrentRoom()");
        ConsoleApp.returnLog("return currentRoom");
        return currentRoom;
    }

    public int getStunnedFor() {
        ConsoleApp.funcLog("Character.getStunnedFor()");
        ConsoleApp.returnLog("return stunnedFor");
        return stunnedFor;
    }

    public void beStunnedFor(int i) {
        ConsoleApp.funcLog("Character.beStunnedFor(int: i)");
        ConsoleApp.returnLog("return");
        stunnedFor = i;
    }

    public void dropItem(Item i) {
        ConsoleApp.funcLog("Character.dropItem()");
        inventory.remove(i);
        currentRoom.addItem(i);
        ConsoleApp.funcLog("i.dropItem()");
        i.drop();
        ConsoleApp.returnLog("return");
    }

    public void dropItems() {
        ConsoleApp.funcLog("Character.dropItems()");
        for (Item i : inventory) {
            ConsoleApp.funcLog("currentRoom.addItem(Item: i)");
            currentRoom.addItem(i);
        }
        inventory.clear();
        ConsoleApp.returnLog("return");
    }

    public abstract void move(int targetIndex);

    public void pickUpItem(int targetIndex) {
        ConsoleApp.funcLog("Character.pickUpItems(int: targetIdx)");
        ArrayList<Item> options = currentRoom.getItems();
        if (options.isEmpty()){
            ConsoleApp.returnLog("return");
           return; 
        }
        Item chosen = options.get(targetIndex);
        if(inventory.size()<5){
            addToInventory(chosen);
            currentRoom.removeItem(chosen);
            chosen.initItem(this);
        }
        ConsoleApp.returnLog("return");
    }

    public void skipTurn() {
        ConsoleApp.funcLog("Character.skipTurn()");
        ConsoleApp.returnLog("return");
        return; //sztem csak ennyi (?)
    }

    public boolean setExpelled() {
        ConsoleApp.funcLog("Character.setExpelled()");
        ConsoleApp.returnLog("return false");
        return false;
    }

    public void setRoom(Room r) {
        ConsoleApp.funcLog("Character.setRoom(Room: r)");
        ConsoleApp.returnLog("return");
        currentRoom = r;
    }

    public void useItem(int idx) { 
        ConsoleApp.funcLog("Character.useItem(int: idx)");
        ConsoleApp.returnLog("return");
        return; };

    public abstract Item chooseItem();

    public abstract boolean triggerExpelling(Student s);

    public boolean tryStun() {
        ConsoleApp.funcLog("Character.tryStun()");
        ConsoleApp.returnLog("return true");
        return true; };

    public abstract boolean tryExpell(Teacher attacker);

    public void endOfRound() {
        ConsoleApp.funcLog("Character.endOfRound()");
        for (Item item : inventory) {
            item.decrRemainingTime();
        }
        ConsoleApp.returnLog("return");
    }

    public void clearInventory() { 
        ConsoleApp.funcLog("Character.clearInventory()");
        ConsoleApp.returnLog("return");
        inventory.clear(); }
}
