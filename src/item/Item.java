package src.item;

import src.character.Character;
import src.character.Teacher;
import src.game.ConsoleApp;
import src.room.Room;

public abstract class Item {

    private int id;
    protected Character owner;

    public Item() {
        owner = null;
    }

    public int getId() {
        ConsoleApp.returnLog("return id");
        return id;
    }

    public boolean useItem(Character c) {
        ConsoleApp.returnLog("return true");
        return true;
    }

    public boolean IsUnpaired() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    public void decrRemainingTime() {};

    public void initItem(Character c) {
        ConsoleApp.returnLog("return");
        owner = c;
    };

    public boolean isActive() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    public void drop() {
        ConsoleApp.returnLog("return");
        owner = null;
    };

    public boolean checkDefense(Teacher attacker) {
        ConsoleApp.returnLog("return false");
        return false;
    }

    public boolean defendStun() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    public void pair(Item t) {};
    
    public Room getLocation() {
        ConsoleApp.returnLog("return null");
        return null;
    };

    public void setOwner(Character owner) {
        ConsoleApp.returnLog("return");
        this.owner = owner;
    }

    public abstract String toString();
}
