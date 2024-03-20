package src.item;

import src.character.Character;
import src.game.Room;

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

    public abstract boolean useItem(Character c);

    public abstract boolean IsUnpaired();

    public abstract void setRemainingTime(int i);

    public abstract void initItem();

    public abstract boolean isActive();
}
