package src.game;

import java.util.ArrayList;

import src.character.Character;
import src.room.Room;
import src.room.RoomManager;
import static src.game.SingletonLogger.logger;


public class GameLogic{
    private static RoomManager roomManager;
    private static ArrayList<Character> characters;

    static {
        roomManager = new RoomManager();
        characters = new ArrayList<Character>();
    }


    public static void startGame() {

    }

    public static void endGame() {

    }

    public static void changeRoomTo(Room r) {

    }

    public static void generateCharacters() {

    }

    public static void generateItems() {

    }

    public static ArrayList<Character> getStudents() { //wtf
        return null;
    }

    private static void triggerRoomEffects() {

    }

    private static void endOfTurn() {
        for (Character c : characters) {
            c.endOfRound();
        }
    }

    public static void removeCharacter(Character character) {
        characters.remove(character);
    }
}