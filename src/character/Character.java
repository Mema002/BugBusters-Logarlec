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
    protected int id;

    /**
     * Character osztaly konstruktor, a paramul kapott szobaba helyezi a karaktert
     * @param currentRoom
     */
    public Character(Room currentRoom) {
        this.inventory = new ArrayList<Item>();
        this.currentRoom = currentRoom;
        this.stunnedFor = 0;
        this.expelled = false;
    }

    /**
     * Visszater a karakter Id-jevel
     * @return id
     */
    public int getId() {
        return id;
    }

    /** 
     * Hozzaad egy itemet az inventoryhoz
     * @param i
     */
    public void addToInventory(Item i) {
        ConsoleApp.returnLog("return");
        inventory.add(i);
    }

    
    /** 
     * Kiszed egy itemet az inventorybol
     * @param i
     */
    public void removeItem(Item i) {
        ConsoleApp.returnLog("return");
        inventory.remove(i);
    }

    
    /** 
     * Visszater az inventoryval
     * @return ArrayList<Item>
     */
    public ArrayList<Item> getInventory() {
        ConsoleApp.returnLog("return inventory");
        return inventory;
    }

    
    /** 
     * Visszater a jelenlegi szobaval
     * @return Room
     */
    public Room getCurrentRoom() {
        ConsoleApp.returnLog("return currentRoom");
        return currentRoom;
    }

    
    /** 
     * Visszater az elkabitas idejevel
     * @return int
     */
    public int getStunnedFor() {
        ConsoleApp.returnLog("return stunnedFor");
        return stunnedFor;
    }

    
    /** 
     * Kabitas setter, parameter korig elkabitja a karaktert
     * @param i
     */
    public void beStunnedFor(int i) {
        ConsoleApp.returnLog("return");
        stunnedFor = i;
    }

    
    /** 
     * Targyeldobas, eldobja a paramul kapott targyat
     * @param i
     */
    public void dropItem(Item i) {
        inventory.remove(i);
        ConsoleApp.funcLog("currentRoom.addItem(i)");
        currentRoom.addItem(i);
        ConsoleApp.funcLog("i.dropItem()");
        i.drop();
        ConsoleApp.returnLog("return");
    }

    /**
     * Az inventoryban levo osszes item eldobasa a currentRoomba
     */
    public void dropItems() {
        for (Item i : inventory) {
            ConsoleApp.funcLog("currentRoom.addItem(Item: i)");
            currentRoom.addItem(i);
        }
        inventory.clear();
        ConsoleApp.returnLog("return");
    }

    /**
     * mozgas abstract fuggveny
     * @param targetIndex
     */
    public abstract void move(int targetIndex);

    
    /** 
     * Targyfelvetel fuggveny, atmozgatja a forras szobabol/inventorybol, a cel szobaba/inventoryba
     * @param targetIndex
     */
    public void pickUpItem(int targetIndex) {
        ConsoleApp.funcLog("currentRoom.getItems()");
        ArrayList<Item> options = currentRoom.getItems();
        if (options.isEmpty()) {
            ConsoleApp.returnLog("return");
            return; 
        }
        Item chosen = options.get(targetIndex);
        if(inventory.size() < 5){
            ConsoleApp.funcLog("this.addToInventory(chosen)");
            addToInventory(chosen);
            ConsoleApp.funcLog("currentRoom.removeItem(chosen)");
            currentRoom.removeItem(chosen);
            ConsoleApp.funcLog("chosen.initItem(this)");
            chosen.initItem(this);
        }
        ConsoleApp.returnLog("return");
    }

    /**
     * Kor passzolas akcio, szimpla void return
     */
    public void skipTurn() {
        ConsoleApp.returnLog("return");
        return; //sztem csak ennyi (?)
    }

    
    /** 
     * Megbuktatas flag setter, Studentben felulirva
     * @return boolean
     */
    public boolean setExpelled() {
        ConsoleApp.returnLog("return false");
        return false;
    }

    
    /** 
     * currentRoom attributum setter
     * @param r
     */
    public void setRoom(Room r) {
        ConsoleApp.returnLog("return");
        currentRoom = r;
    }

    
    /** 
     * A parameterul kapott indexu targy hasznalata, Studentben felulirva van
     * @param idx
     */
    public void useItem(int idx) {
        ConsoleApp.returnLog("return");
        return;
    };

    /**
     * Item kivalasztasa abstract fuggveny, az akciovalasztasnal szukseges
     * @return
     */
    public abstract Item chooseItem();

    /**
     * Buktatasi folyamat meginditasa a paramul kapott Studentre
     * @param s
     * @return
     */
    public abstract boolean triggerExpelling(Student s);

    
    /** 
     * Elkabithatosag visszajelzes, Student osztalyban felulirva van
     * @return true
     */
    public boolean tryStun() {
        ConsoleApp.returnLog("return true");
        return true;
    };

    /**
     * Buktatasi folyamat resze
     * @param attacker
     * @return
     */
    public boolean tryExpell(Teacher attacker) {
        ConsoleApp.returnLog("return false");
        return false;
    }

    /**
     * Egy kor vegen meghivando fuggveny
     * Csokkenti az ideiglenes itemek idejet
     */
    public void endOfRound() {
        for (Item item : inventory) {
            ConsoleApp.funcLog("item.decrRemainingTime()");
            item.decrRemainingTime();
        }
        ConsoleApp.returnLog("return");
    }

    /**
     * Kitolri az inventoryt
     */
    public void clearInventory() {
        ConsoleApp.returnLog("return");
        inventory.clear(); }

    /**
     * Szkeletonhoz szukseges
     */
    public abstract String toString();
}
