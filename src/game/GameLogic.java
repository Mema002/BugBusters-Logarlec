package src.game;

import java.util.ArrayList;
import java.util.Random;

import src.character.Character;
import src.character.Student;
import src.character.Teacher;
import src.item.Batskin;
import src.item.Beerglass;
import src.item.Camembert;
import src.item.FFP2;
import src.item.Item;
import src.item.Rag;
import src.item.Sliderule;
import src.item.Transistor;
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
            if(currentPlayerIdx >= characters.size()){
                endOfTurn();
                currentPlayerIdx = 0;
            }
                


            //Karakter akcio
            Character currentPlayer = characters.get(currentPlayerIdx);

            //Itt fogja majd az ActionListener meghívni a fuggvenyeket

            currentPlayerIdx++;
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

        ArrayList<Room> rooms = roomManager.getRooms();
        int roomCount = rooms.size();

        for (int i = 0; i < characters.size(); i++) {
            Room randomRoom = rooms.get(random.nextInt(roomCount)); //melyik szobaba
            randomRoom.addCharacter(characters.get(i));
        }
    }

    public static void generateItems(int count) {
        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Room> rooms = roomManager.getRooms();
        int roomCount = rooms.size();
        items.add(new Sliderule()); //1 sliderule fix
        for (int i = 0; i < count - 1; i++) {
            int type = random.nextInt(6); //milyen itemet generaljunk
            Room randomRoom = rooms.get(random.nextInt(roomCount)); //melyik szobaba
            switch (type) {
                case 0:
                    randomRoom.addItem(new Batskin());
                    break;
                case 1:
                    randomRoom.addItem(new Beerglass());
                    break;
                case 2:
                    randomRoom.addItem(new Camembert());
                    break;
                case 3:
                    randomRoom.addItem(new FFP2());
                    break;
                case 4:
                    randomRoom.addItem(new Rag());
                    break;
                case 5:
                    randomRoom.addItem(new Transistor());
                    break;
                default: break;
            }
        }
    }

    public static ArrayList<Character> getStudents() { //wtf
        return null;
    }


    public static void endOfTurn() {
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