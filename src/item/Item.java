package src.item;

import src.character.Character;
import src.character.Teacher;
import src.game.ConsoleApp;
import src.room.Room;

public abstract class Item {
    private int id;
    protected Character owner;

    /**
     * Item konstruktor, kezdetben nincs tulajdonos
     */
    public Item() {
        owner = null;
    }

    /** 
     * Visszater az id-vel
     * @return int
     */
    public int getId() {
        ConsoleApp.returnLog("return id");
        return id;
    }

    /** 
     * Item hasznalata, a hasznalhato itemek overrideoljak
     * @param c
     * @return boolean
     */
    public boolean useItem(Character c) {
        ConsoleApp.returnLog("return true");
        return true;
    }

    /** 
     * Visszater azzal, hogy parositett-e az item
     * Overrideolva van, a transistornal relevans
     * @return boolean
     */
    public boolean IsUnpaired() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    /**
     * Overrideolando, csak a releveans itemeknel kell
     */
    public void decrRemainingTime() {};

    /** 
     * Felvetelkor beallitja a tulajdonost
     * @param c
     */
    public void initItem(Character c) {
        ConsoleApp.returnLog("return");
        owner = c;
    };

    /** 
     * Visszater azzal, hogy aktiv-e az item
     * Overrideolva van, a transistornal relevans
     * @return boolean
     */
    public boolean isActive() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    /**
     * Item eldobasa fuggveny, kinullazza a tulajdonost
     */
    public void drop() {
        ConsoleApp.returnLog("return");
        owner = null;
    };

    /**
     * Vedelem ellenorzese fuggveny, relevans itemeknel overrideolva van
     * @param attacker
     * @return false
     */
    public boolean checkDefense(Teacher attacker) {
        ConsoleApp.returnLog("return false");
        return false;
    }

    /**
     * Vedelem ellenorzese fuggveny, relevans itemeknel overrideolva van
     * @return false
     */
    public boolean defendStun() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    /**
     * Item parositasa, a transistornal relevans
     * @param item
     */
    public void pair(Item t) {};
    
    /**
     * Visszater az item parjanak szobajval, a transistornal relevans
     */
    public Room getLocation() {
        ConsoleApp.returnLog("return null");
        return null;
    };

    /**
     * Beallitja a tulajdonost a parameter karakterre
     * @param owner
     */
    public void setOwner(Character owner) {
        ConsoleApp.returnLog("return");
        this.owner = owner;
    }

    public abstract String toString();
}
