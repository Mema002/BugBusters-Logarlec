package src.gui;

import src.game.GameLogic;
import src.item.Item;

import java.util.ArrayList;
import java.util.List;
public class GUIController {
    static private List<RoomView> rooms; // A szobák megjelenítéséért felelős objektumok listája
    static private List<StudentView> characters; // A karakterek megjelenítéséért felelős objektumok listája
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

    static public List<StudentView> getStudentViews() { return characters; }

    static public List<ItemView> getItemViews() { return items; }

    //change RoomView in StudentViews
    static public void changeRoomView(RoomView newRoomView) {
        RoomView roomForDelete = rooms.stream().filter(r -> r.getRoom() == newRoomView.getRoom()).findFirst().orElse(null);
        if (roomForDelete != null) {
            rooms.remove(roomForDelete);
            rooms.add(newRoomView);
        }
        for (StudentView student : characters) {
            student.updateRoomView(newRoomView);
        }
    }

    static public void addRoomView(RoomView room) {
        rooms.add(room);
    }

    static public void addStudentView(StudentView character) {
        characters.add(character);
    }

    static public void addItemView(ItemView item) {
        items.add(item);
    }

    static public void removeRoomView(RoomView room) {
        rooms.remove(room);
    }

    static public void removeStudentView(StudentView character) {
        characters.remove(character);
    }

    static public void removeItemView(ItemView item) {
        items.remove(item);
    }


    public static void setAction() {
        GameLogic.setAction();
    }
}
