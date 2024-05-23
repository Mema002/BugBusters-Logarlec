package src.item;

import src.room.Room;
import src.character.Character;
import src.game.ConsoleApp;
import src.gui.ItemView;

public class Transistor extends Item {
    private boolean isActive;
    private Item pair;
    private Room location;
    int durability;
    boolean isFake;

    /**
     * Transistor konstruktor
     */
    public Transistor() {
        super();
        this.isActive = false;
        this.pair = null;
    }
    public Transistor(int id, boolean isFake, int durability) {
        super(id);
        this.isActive = false;
        this.pair = null;
        this.isFake = isFake;
        this.durability = durability;
    }

    /** 
     * Inicializalja a transistort, ha lehetseges parositja is
     * @param c
     */
    @Override
    public void initItem(Character c) {
        owner = c;
        for (Item i : c.getInventory()) {
            if (i.IsUnpaired() && !i.equals(this)) {
                this.pair(i);
                i.pair(this);
                return;
            }
        }
        ConsoleApp.returnLog("return");
    }

    /** 
     * Hasznalja a transistort, azaz aktivalja
     * @param c
     * @return boolean
     */
    @Override
    public boolean useItem(Character c) {
        if(!isActive) {
            ConsoleApp.funcLog("activate()");
            activate();
        }
        ConsoleApp.returnLog("return true");
        return true;
    }

    /** 
     * Visszater azzal, hogy parositott-e a transistor vagy sem
     * @return boolean
     */
    @Override
    public boolean IsUnpaired() {
        ConsoleApp.returnLog("return " + String.valueOf(pair == null));
        return pair == null; //lehet nem pontos a compare
    }
    
    /** 
     * Aktivalja a transistort
     */
    private void activate() { //ha paired akkor lehet csak aktiválni
        if (!IsUnpaired()) {
            ConsoleApp.funcLog("IsUnpaired()");
            isActive = true;
        }
        ConsoleApp.returnLog("return");
    }
    /**
     * Deaktivalja a transistort
     */
    private void deActivate() {
        ConsoleApp.returnLog("return");
        isActive = false;
    }

    /** 
     * Parositja a transistort a paramul kapott transistorral
     * @param t
     */
    @Override
    public void pair(Item t) {
        ConsoleApp.returnLog("return");
        pair = t;
    }

    /** 
     * Visszater a parja szobajaval
     * @return Room
     */
    private Room getPairLocation() { //itembe kene rakni abstractként
        ConsoleApp.returnLog("return location");
        return pair.getLocation();
    }

    
    /** 
     * isActive getter
     * @return boolean
     */
    @Override
    public boolean isActive() {
        ConsoleApp.returnLog("return" + String.valueOf(isActive));
        return isActive;
    }

    /**
     * Eldobja a transistort
     * Ha aktiv, elvegzi a teleportalast
     */
    @Override
    public void drop() {
        if (pair != null){
            if (isActive()) {
                Room targetRoom = getPairLocation();
                Room currentRoom = owner.getCurrentRoom();
                if (targetRoom.requestChange()) {
                    currentRoom.removeCharacter(owner);
                    targetRoom.addCharacter(owner);
                    owner.setRoom(targetRoom);
                    deActivate();
                    pair.pair(null);
                    pair(null);
                }
            }
            /* ConsoleApp.funcLog("pair.pair(null)");
            pair.pair(null);
            ConsoleApp.funcLog("this.pair(null)");
            this.pair(null); */
        }
        location=owner.getCurrentRoom();
        owner=null;
        ConsoleApp.returnLog("return");
    }

    
    /** 
     * Visszater a szobajaval
     * @return Room
     */
    @Override
    public Room getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Transistor";
    }
    
    @Override
    public ItemView getView() {
        return new ItemView(this);
    }
}
