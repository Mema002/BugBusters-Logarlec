package src.item;

import src.character.Character;
import src.room.Room;

public abstract class Item {

    private int id;
    protected Room currentRoom;

    public Item(Room r) {
        this.currentRoom = r;
    }

    public int getId() {
        return id;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room r) {
        this.currentRoom = r;
    }

    public boolean useItem(Character c){
        return true;
    }

    public boolean IsUnpaired(){
        return false;
    }

    public void decrRemainingTime() {};

    public void initItem() {};

    public boolean isActive(){
        return false;
    }

    public abstract void drop();

    public boolean checkDefense() { return false; }

    public boolean defendStun() { return false; }
}
