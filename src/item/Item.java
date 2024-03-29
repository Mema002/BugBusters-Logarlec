package src.item;

import src.character.Character;
import src.room.Room;

public abstract class Item {
    protected Room currentRoom;

    public Item(Room r) {
        this.currentRoom = r;
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

    public abstract void setRemainingTime(int i);

    public abstract void initItem();

    public boolean isActive(){
        return false;
    }

    public abstract void drop();
}
