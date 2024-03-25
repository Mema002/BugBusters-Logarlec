package src.room;

import java.util.ArrayList;

import src.effect.Effect;
import src.game.ConsoleApp;
import src.item.Item;
import src.character.Character;

public class Room {
    private ArrayList<Character> characters;
    private ArrayList<Item> items;
    private ArrayList<Effect> effects;
    private ArrayList<Room> neighbours;
    private int capacity;

    private final int id;

    /**
     * Room konstruktor
     * @param capacity
     * @param id
     */
    public Room(int capacity, int id) {
        this.characters = new ArrayList<Character>();
        this.items = new ArrayList<Item>();
        this.effects = new ArrayList<Effect>();
        this.neighbours = new ArrayList<Room>();
        this.capacity = capacity;
        this.id = id;
    }

    /**
     * Visszater az id-vel
     * @return id
     */
    public int getId() {
        ConsoleApp.returnLog("return id");
        return id;
    }

    /**
     * Visszater a szobaban levo karakterekkel
     * @return characters
     */
    public ArrayList<Character> getCharacters() {
        ConsoleApp.returnLog("return ArrayList<> characters");
        return characters;
    }

    /**
     * Kiszedi a paramul kapott karaktert a szobabol
     * @param c
     */
    public void removeCharacter(Character c) {
        ConsoleApp.returnLog("return");
        characters.remove(c);
    }

    /**
     * Hozzaadja a paramul kapott karaktert a szobahoz
     * @param c
     */
    public void addCharacter(Character c) {
        ConsoleApp.returnLog("return");
        characters.add(c);
    }

    //items get set

    /**
     * Visszater a szobaban levo itemekkel
     * @return items
     */
    public ArrayList<Item> getItems() {
        ConsoleApp.returnLog("return ArrayList<> items");
        return items;
    }

    /**
     * Hozzaadja a paramul kapott itemet a szobahoz
     * @param i
     */
    public void addItem(Item i) {
        ConsoleApp.returnLog("return");
        items.add(i);
    }

    /**
     * Kiszedi a paramul kapott itemet a szobabol
     * @param i
     */
    public void removeItem(Item i) {
        ConsoleApp.returnLog("return");
        items.remove(i);
    }

    //effects get set

    /**
     * Visszater a szoba effektjeivel
     * @return effects
     */
    public ArrayList<Effect> getEffects() {
        ConsoleApp.returnLog("return ArrayList<> effects");
        return effects;
    }

    /**
     * Hozzaadja a param effektet a szobahoz
     * @param e
     */
    public void addEffect(Effect e) {
        ConsoleApp.returnLog("return");
        effects.add(e);
    }

    /**
     * Kiszedi a paramul kapott effektet a szobabol
     * @param e
     */
    public void removeEffect(Effect e) {
        ConsoleApp.returnLog("return");
        effects.remove(e);
    }

    //neighbours get set

    /**
     * Visszater a szoba szomszedjaival
     * (szomszedok = azok a szobak, amikbe el lehet jutni ebbol a szobabol)
     * @return neighbours
     */
    public ArrayList<Room> getNeighbours() {
        ConsoleApp.returnLog("return ArrayList<> neighbours");
        return neighbours;
    }

    /**
     * Hozzadja a paramul kapott szobat a szomszedokhoz
     * @param r
     */
    public void addNeighbour(Room r) {
        ConsoleApp.returnLog("return");
        neighbours.add(r);
    }

    /**
     * Kitorli a paramul kapott szobat a szomszedok kozul
     * @param r
     */
    public void removeNeighbour(Room r) {
        ConsoleApp.returnLog("return");
        neighbours.remove(r);
    }

    //capactiy get set

    /**
     * Visszater a szoba befogadokepessegevel
     * @return capacity
     */
    public int getCapacity() {
        ConsoleApp.returnLog("return capacity");
        return capacity;
    }

    /**
     * Beallitja a szoba befogadokepesseget
     * @param i
     */
    public void setCapacity(int i) {
        ConsoleApp.returnLog("return");
        capacity = i;
    }

    /**
     * Visszater azzal, hogy a szoba ures-e vagy sem
     * @return boolean
     */
    public boolean isEmpty() {
        ConsoleApp.returnLog("return " + String.valueOf(capacity == 0));
        return capacity == 0;
    }

    /**
     * Visszater azzal, hogy kepes karaktert befogadni
     * @return
     */
    public boolean requestChange() { //aka requestMove 7. szekvencián
        ConsoleApp.returnLog("return " + String.valueOf(capacity > characters.size()));
        return capacity > characters.size();
    }

    /**
     * Aktivalja a szoba effektusait
     */
    public void triggerRoomEffects() {
        for (Effect effect : effects) {
            ConsoleApp.funcLog("effect.triggereffect(Room: room)");
            effect.triggerEffect(this);
        }
        ConsoleApp.returnLog("return");
    }

    /**
     * Kitorli a szoba itemjeit
     */
    public void clearItems() {
        items.clear();
    }

    public String toString() {
        return "Room";
    }
}
