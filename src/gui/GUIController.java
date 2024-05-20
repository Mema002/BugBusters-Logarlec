package src.gui;

import src.game.GameLogic;
import src.item.Item;

import java.util.ArrayList;
import java.util.List;
public class GUIController {
    static private List<RoomView> rooms; // A szobák megjelenítéséért felelős objektumok listája
    static private List<CharacterView> characters; // A karakterek megjelenítéséért felelős objektumok listája
    static private List<ItemView> items; // A tárgyak megjelenítéséért felelős objektumok listája
    static public boolean isSet;

    // Konstruktor
    static {
        rooms = new ArrayList<>();
        characters = new ArrayList<>();
        items = new ArrayList<>();
        isSet = false;
    }

    static public List<RoomView> getRoomViews() { return rooms; }

    static public List<CharacterView> getCharacterViews() { return characters; }

    static public List<ItemView> getItemViews() { return items; }

    static public void addRoomView(RoomView room) {
        rooms.add(room);
    }

    static public void addCharacterView(CharacterView character) {
        characters.add(character);
    }

    static public void addItemView(ItemView item) {
        items.add(item);
    }

    static public void removeRoomView(RoomView room) {
        rooms.remove(room);
    }

    static public void removeCharacterView(CharacterView character) {
        characters.remove(character);
    }

    static public void removeItemView(ItemView item) {
        items.remove(item);
    }

    static public void displayCharacter(Character character) {
        // Karakter állapotának megjelenítése
    }

    static public void roomSelect(Character character) {
        // Szoba kiválasztása lépéshez
    }

    static public void actionSelect(Character character) {
        // Akció kiválasztása
    }

    static public void itemSelect(Character character) {
        // Item kiválasztása használathoz
    }

    public static void pickupSelect(Character character) {
        // Item felvételének kiválasztása
    }

    public static void dropSelect(Character character) {
        // Item eldobásának kiválasztása
    }

    public static void setAction() {
        GameLogic.setAction();
    }
}
