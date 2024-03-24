package src.item;

import src.character.Character;
import src.character.Teacher;
import src.room.Room;

public abstract class Item {

    private int id;
    protected Character owner;

    public Item() {
        owner = null;
    }

    public int getId() {
        return id;
    }

    public boolean useItem(Character c){
        return true;
    }

    public boolean IsUnpaired(){
        return false;
    }

    public void decrRemainingTime() {};

    public void initItem(Character c) {
        owner=c;
    };

    public boolean isActive(){
        return false;
    }

    public void drop(){
        owner = null;
    };

    public boolean checkDefense(Teacher attacker) { return false; }

    public boolean defendStun() { return false; }

    public void pair(Item t){};
    
    public Room getLocation(){ return null; };

    public void setOwner(Character owner) {
        this.owner = owner;
    }
}
