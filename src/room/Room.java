package src.room;

import java.util.ArrayList;

import src.effect.Effect;
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
        return id;
    }

    //TODO character get set
    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void removeCharacter(Character c) {
        characters.remove(c);
    }

    public void addCharacter(Character c) {
        characters.add(c);
    }
    //items get set
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void removeItem(Item i) {
        items.remove(i);
    }
    //effects get set
    public ArrayList<Effect> getEffects() {
        return effects;
    }

    public void addEffect(Effect e) {
        effects.add(e);
    }

    public void removeEffect(Effect e) {
        effects.remove(e);
    }
    //neighbours get set
    public ArrayList<Room> getNeighbours() { //wtf
        return null;
    }

    public void addNeighbour(Room r) {
        neighbours.add(r);
    }

    public void removeNeighbour(Room r) {
        neighbours.remove(r);
    }
    //capactiy get set
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int i) {
        capacity = i;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean requestChange() { //aka requestMove 7. szekvencián
        return capacity > characters.size();
    }

    public void triggerRoomEffects() {
        for (Effect effect : effects) {
            effect.triggerEffect(this);
        }
    }

    public void clearItems() { items.clear(); }
}
