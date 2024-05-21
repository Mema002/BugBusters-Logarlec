package src.gui;

import src.character.Character;
import src.game.GameLogic;
import src.item.Item;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class GUIController {
    static private List<RoomView> rooms; // A szobák megjelenítéséért felelős objektumok listája
    static private List<StudentView> students; // A karakterek megjelenítéséért felelős objektumok listája
    static private List<ItemView> items; // A tárgyak megjelenítéséért felelős objektumok listája
    static private List<CharacterView> characters; // A karakterek megjelenítéséért felelős objektumok listája
    static public boolean isSet;

    // Konstruktor
    static {
        rooms = new ArrayList<>();
        characters = new ArrayList<>();
        items = new ArrayList<>();
        students = new ArrayList<>();
        isSet = false;
    }

    static public List<RoomView> getRoomViews() { return rooms; }

    static public List<StudentView> getStudentViews() { return students; }

    static public List<ItemView> getItemViews() { return items; }

    static public List<CharacterView> getCharacterViews() { return characters; }

    //change RoomView in StudentViews
    // static public void changeRoomView(RoomView newRoomView) {
    //     RoomView roomForDelete = rooms.stream().filter(r -> r.getRoom() == newRoomView.getRoom()).findFirst().orElse(null);
    //     if (roomForDelete != null) {
    //         rooms.remove(roomForDelete);
    //         rooms.add(newRoomView);
    //     }
    //     for (StudentView student : students) {
    //         student.updateRoomView(newRoomView);
    //     }
    // }

    public static void updateStudentViews() {
        for (StudentView sv : students) {
            sv.updateStudentView();
        }
    }

    static public void addRoomView(RoomView room) {
        rooms.add(room);
    }

    static public void addStudentView(StudentView character) {
        students.add(character);
    }

    static public void addItemView(ItemView item) {
        items.add(item);
    }

    static public void addCharacterView(CharacterView character) {
        characters.add(character);
    }

    static public void removeRoomView(RoomView room) {
        rooms.remove(room);
    }

    static public void removeStudentView(StudentView character) {
        students.remove(character);
    }

    static public void removeItemView(ItemView item) {
        items.remove(item);
    }

    static public void removeCharacterView(CharacterView character) {
        characters.remove(character);
    }

    public static void setAction() {
        GameLogic.setAction();
    }

    public static int selectPlayerNumber() {
        try {
            return Integer.parseInt((String) JOptionPane.showInputDialog(
                    null,
                    "Select number of Students:",
                    "Number of Students",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new Object[]{"2","3","4","5","6","7","8","9","10"},
                    "2"
            ));
        } catch (Exception e) {
            return 2;
        }
    }

    public static void gameOverMessage(Character c) {
        JOptionPane.showMessageDialog(
            null,
            c.toString() + " picked up the Sliderule, you won!",
            "Game Over",
            JOptionPane.PLAIN_MESSAGE
        );
    }
}
