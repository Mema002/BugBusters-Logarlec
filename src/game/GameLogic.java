package src.game;

import java.util.ArrayList;
import java.util.Random;

import src.character.Character;
import src.character.Student;
import src.character.Teacher;
import src.item.Batskin;
import src.item.Item;
import src.item.Sliderule;
import src.room.Room;
import src.room.RoomManager;
import static src.game.SingletonLogger.logger;


public class GameLogic{
    private static boolean isGameRunning;
    private static RoomManager roomManager;
    private static ArrayList<Character> characters;
    private static ArrayList<Character> deadCharacters;

    //A consoleApp-hoz nem statikus Objektum
    private static Object gameLogic = new Object();

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

    public static void generateCharacters(int studentCount, int teacherCount) {
        for (int i = 0; i < studentCount; i++) {
            characters.add(new Student(null, i)); //null az most ideiglenes, lehet inkább ki kéne venni a konstruktorból
        }
        for (int i = 0; i < teacherCount; i++) {
            characters.add(new Teacher(null, i /*+ studentCount*/));
        }
    }

    public static void generateItems(int count) {
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Room> rooms = roomManager.getRooms();
        int roomCount = rooms.size();
        items.add(new Sliderule(null));
        for (int i = 0; i < count - 1; i++) {
            int type = random.nextInt(6);
            switch (type) {
                case 0:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                case 1:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                case 2:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                case 3:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                case 4:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                case 5:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                case 6:
                    rooms.get(random.nextInt(roomCount)).addItem(new Batskin(null));
                    break;
                default: break;
            }
        }
    }

    public static ArrayList<Character> getStudents() { //wtf
        return null;
    }

    private static void triggerRoomEffects() {

    }

    private static void endOfTurn() {
        for (Character c : characters) {
            ConsoleApp.consoleLog(gameLogic, c, "GameLogic to Character endOfRound");
            c.endOfRound();
        }
        //1 a 3 hoz esely
        if(1 == random.nextInt(0, 3)) {
            ConsoleApp.consoleLog(gameLogic, roomManager, "RoomManager to RoomManager triggerAllEffect");
            roomManager.triggerAllEffects();
        }
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