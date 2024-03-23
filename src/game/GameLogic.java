package src.game;

import java.util.ArrayList;
import java.util.Random;

import src.character.Character;
import src.room.Room;
import src.room.RoomManager;
import static src.game.SingletonLogger.logger;


public class GameLogic{
    private static boolean isGameRunning;
    private static RoomManager roomManager;
    private static ArrayList<Character> characters;
    private static ArrayList<Character> deadCharacters;

    //A veletlen actionokhoz
    private static Random random = new Random();

    static {
        roomManager = new RoomManager();
        characters = new ArrayList<Character>();
        isGameRunning = false;
    }

    public static void startGame() {
        isGameRunning = true;
    }

    public static void endGame() {
        isGameRunning = false;
    }

    private static void runGame() {
        //Itt fut a jatek

        int currentPlayerIdx = 0;

        while(isGameRunning) {
            //Ha halt meg jatekos
            if(!deadCharacters.isEmpty()){
                for (Character deadCharacter : deadCharacters){
                    //A sorrend miatt fontos
                    if(characters.indexOf(deadCharacter) < currentPlayerIdx)
                        currentPlayerIdx -= 1;

                    characters.remove(deadCharacter);
                }

                deadCharacters.clear();
            }

            //Ujbol indul ha az utolso karakter is meg volt
            if(currentPlayerIdx >= characters.size())
                currentPlayerIdx = 0;


            //Karakter akcio
            Character currentPlayer = characters.get(currentPlayerIdx);

            //Itt fogja majd az ActionListener meghívni a fuggvenyeket

        }
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
        //1 a 3 hoz esely
        if(1 == random.nextInt(0, 3))
            roomManager.triggerAllEffects();
    }

    public static void removeCharacter(Character character) {
        deadCharacters.add(character);
    }

    public static void resetGame() {
        //item torles
        for (Character character : characters)
            character.clearInventory();

        roomManager.clearRoomItems();

        //karakter torles
        characters.clear();

        //szoba torles
        roomManager.clearRooms();


    }
}