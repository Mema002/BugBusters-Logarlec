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

    public Room(int capacity, int id) {
        this.characters = new ArrayList<Character>();
        this.items = new ArrayList<Item>();
        this.effects = new ArrayList<Effect>();
        this.neighbours = new ArrayList<Room>();
        this.capacity = capacity;
        this.id = id;
    }

    public int getId() {
        ConsoleApp.returnLog("return id");
        return id;
    }

    public ArrayList<Character> getCharacters() {
        ConsoleApp.returnLog("return ArrayList<> characters");
        return characters;
    }

    public void removeCharacter(Character c) {
        ConsoleApp.returnLog("return");
        characters.remove(c);
    }

    public void addCharacter(Character c) {
        ConsoleApp.returnLog("return");
        characters.add(c);
    }
    //items get set
    public ArrayList<Item> getItems() {
        ConsoleApp.returnLog("return ArrayList<> items");
        return items;
    }

    public void addItem(Item i) {
        ConsoleApp.returnLog("return");
        items.add(i);
    }

    public void removeItem(Item i) {
        ConsoleApp.returnLog("return");
        items.remove(i);
    }
    //effects get set
    public ArrayList<Effect> getEffects() {
        ConsoleApp.returnLog("return ArrayList<> effects");
        return effects;
    }

    public void addEffect(Effect e) {
        effects.add(e);
    }

    public void removeEffect(Effect e) {
        ConsoleApp.returnLog("return");
        effects.remove(e);
    }
    //neighbours get set
    public ArrayList<Room> getNeighbours() {
        ConsoleApp.returnLog("return ArrayList<> neighbours");
        return neighbours;
    }

    public void addNeighbour(Room r) {
        ConsoleApp.returnLog("return");
        neighbours.add(r);
    }

    public void removeNeighbour(Room r) {
        ConsoleApp.returnLog("return");
        neighbours.remove(r);
    }
    //capactiy get set
    public int getCapacity() {
        ConsoleApp.returnLog("return capacity");
        return capacity;
    }

    public void setCapacity(int i) {
        ConsoleApp.returnLog("return");
        capacity = i;
    }

    public boolean isEmpty() {
        ConsoleApp.returnLog("return " + String.valueOf(capacity == 0));
        return capacity == 0;
    }

    public boolean requestChange() { //aka requestMove 7. szekvencián
        ConsoleApp.returnLog("return " + String.valueOf(capacity > characters.size()));
        return capacity > characters.size();
    }

    public void triggerRoomEffects() {
        for (Effect effect : effects) {
            ConsoleApp.funcLog("Room to Effect triggerEffect");
            effect.triggerEffect(this);
        }
        ConsoleApp.returnLog("return");
    }

    public void clearItems() {
        items.clear();
    }

    public String toString() {
        return "Room";
    }
}
