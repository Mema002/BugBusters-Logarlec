package src.gui;

import src.item.Item;

import java.util.ArrayList;
import java.util.List;
public class GUIController {
    static public List<RoomView> rooms; // A szobák megjelenítéséért felelős objektumok listája
    static public List<CharacterView> characters; // A karakterek megjelenítéséért felelős objektumok listája
    static public List<ItemView> items; // A tárgyak megjelenítéséért felelős objektumok listája

    // Konstruktor
    static {
        rooms = new ArrayList<>();
        characters = new ArrayList<>();
        items = new ArrayList<>();
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
}
