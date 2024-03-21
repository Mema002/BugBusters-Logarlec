package src.character;

import java.util.ArrayList;

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
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void changeRoom(Room r) { //lehetne setCurrentRoom
        currentRoom = r;
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

    public abstract void move();

    public abstract void pickUpItem();

    public abstract void chooseAction();

    public void skipTurn() { //TODO

    }

    public boolean setExpelled() { //TODO
        return false;
    }

    public void setRoom(Room r) { //TODO

    }

    public abstract void useItem(Item i);

    public abstract void chooseItem();

    public abstract boolean triggerExpelling(Student s);

    public abstract boolean checkStun();

    public abstract boolean tryExpell();
}
