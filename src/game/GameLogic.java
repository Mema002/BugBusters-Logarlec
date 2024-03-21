package src.game;

import java.util.ArrayList;

import src.character.Character;
import src.room.Room;
import src.room.RoomManager;
import static src.game.SingletonLogger.logger;


public class GameLogic{
    private RoomManager roomManager;
    private ArrayList<Character> characters;

    public GameLogic() {
        this.roomManager = new RoomManager();
        this.characters = new ArrayList<Character>();
    }

    public void startGame() {

    }

    public void endGame() {

    }

    public void changeRoomTo(Room r) {

    }

    public void generateCharacters() {

    }

    public void generateItems() {

    }

    public ArrayList<Character> getStudents() { //wtf
        return null;
    }

    private void triggerRoomEffects() {

    }

    private void endOfTurn() {

    }
}