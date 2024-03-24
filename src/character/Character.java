package src.character;

import java.util.ArrayList;

import src.game.ConsoleApp;
import src.item.Item;
import src.room.Room;
import static src.game.SingletonLogger.logger;

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
        inventory.add(i);
    }

    public void removeItem(Item i) {
        inventory.remove(i);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getStunnedFor() {
        return stunnedFor;
    }

    public void beStunnedFor(int i) {
        stunnedFor = i;
    }

    public void dropItem(Item i) {
        inventory.remove(i);
        currentRoom.addItem(i);
        i.drop();
    }

    public void dropItems() {
        for (Item i : inventory) {
            currentRoom.addItem(i);
        }
        inventory.clear();
    }

    public abstract void move(int targetIndex);

    public void pickUpItem(int targetIndex) {
        ConsoleApp.consoleLog(this, currentRoom, "Tester - Room getItems");
        ArrayList<Item> options = currentRoom.getItems();
        if (options.isEmpty()) return;
        Item chosen = options.get(targetIndex);
        if(inventory.size()<5){
            ConsoleApp.consoleLog(this, this, "Tester - Character addToInventory");
            addToInventory(chosen);
            ConsoleApp.consoleLog(this, currentRoom, "Tester - Room removeitem");
            currentRoom.removeItem(chosen);
            ConsoleApp.consoleLog(this, currentRoom, "Tester - Item initItem");
            chosen.initItem(this);
        }
    }

    public void skipTurn() {
        return; //sztem csak ennyi (?)
    }

    public boolean setExpelled() {
        return false;
    }

    public void setRoom(Room r) {
        currentRoom = r;
    }

    public void useItem(int idx) { return; };

    public abstract Item chooseItem();

    public abstract boolean triggerExpelling(Student s);

    public boolean tryStun() {return true; };

    public abstract boolean tryExpell(Teacher attacker);

    public void endOfRound() {
        for (Item item : inventory) {
            item.decrRemainingTime();
        }
    }

    public void clearInventory() { inventory.clear(); }

    public abstract String toString();
}
