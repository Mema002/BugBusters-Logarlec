package src.game;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import src.character.Character;
import src.character.Student;
import src.character.Teacher;
import src.item.Batskin;
import src.item.Beerglass;
import src.item.Camembert;
import src.item.FFP2;
import src.item.Rag;
import src.item.Sliderule;
import src.item.Transistor;
import src.room.Room;
import src.room.RoomManager;


public class GameLogic {
    private static boolean isGameRunning;
    public static RoomManager roomManager;
    private static List<Character> characters;
    private static List<Character> deadCharacters;
    //A veletlen actionokhoz
    private static Random random = new Random();

    static {
        roomManager = new RoomManager();
        characters = new ArrayList<Character>();
        deadCharacters = new ArrayList<Character>();
        isGameRunning = false;
    }

    public static void startGame() {
        isGameRunning = true;
    }

    public static void endGame() {
        isGameRunning = false;
    }

    public static void runGame() {
        //Itt fut a jatek

        int currentPlayerIdx = 0;

        while(isGameRunning) {
            //Ha halt meg jatekos
            if(!deadCharacters.isEmpty()){
                for (Character deadCharacter : deadCharacters){
                    //A sorrend miatt fontos
                    if(characters.indexOf(deadCharacter) < currentPlayerIdx)
                        currentPlayerIdx -= 1;
                    ConsoleApp.funcLog("characters.remove(deadCharacter)");
                    characters.remove(deadCharacter);
                    ConsoleApp.returnLog("return");
                }

                deadCharacters.clear();
            }

            //Ujbol indul ha az utolso karakter is meg volt
            if(currentPlayerIdx >= characters.size()){
                ConsoleApp.funcLog("endOfTurn();");
                endOfTurn();
                characters.remove("return");
                currentPlayerIdx = 0;
            }
                


            //Karakter akcio
            Character currentPlayer = characters.get(currentPlayerIdx);

            //Itt fogja majd az ActionListener meghívni a fuggvenyeket

            currentPlayerIdx++;
        }
    }

    public static void setCharacters(List<Character> param) {
        characters = param;
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

        ConsoleApp.funcLog("roomManager.getRooms()");
        List<Room> rooms = roomManager.getRooms();
        int roomCount = rooms.size();

        for (int i = 0; i < characters.size(); i++) {
            Room randomRoom = rooms.get(random.nextInt(roomCount)); //melyik szobaba
            ConsoleApp.funcLog("randomRoom.addCharacter()");
            randomRoom.addCharacter(characters.get(i));
        }
        ConsoleApp.returnLog("return");
    }

    public static void generateItems(int count) {
        ConsoleApp.funcLog("roomManager.getRooms()");
        List<Room> rooms = roomManager.getRooms();
        int roomCount = rooms.size();
        ConsoleApp.funcLog("roomManager.getRooms()");
        ConsoleApp.funcLog("room.addItem()");
        roomManager.getRooms().get(0).addItem(new Sliderule(false)); //1 sliderule fix
        for (int i = 0; i < count - 1; i++) {
            int type = random.nextInt(7); //milyen itemet generaljunk
            Room randomRoom = rooms.get(random.nextInt(roomCount)); //melyik szobaba
            switch (type) {
                case 0:
                    ConsoleApp.funcLog("randomRoom.addItem(new Batskin())");
                    randomRoom.addItem(new Batskin(random.nextBoolean()));
                    break;
                case 1:
                    ConsoleApp.funcLog("randomRoom.addItem(new Beerglass())");
                    randomRoom.addItem(new Beerglass());
                    break;
                case 2:
                    ConsoleApp.funcLog("randomRoom.addItem(new Camembert())");
                    randomRoom.addItem(new Camembert());
                    break;
                case 3:
                    ConsoleApp.funcLog("randomRoom.addItem(new FFP2())");
                    randomRoom.addItem(new FFP2(random.nextBoolean()));
                    break;
                case 4:
                    ConsoleApp.funcLog("randomRoom.addItem(new Rag())");
                    randomRoom.addItem(new Rag());
                    break;
                case 5:
                    ConsoleApp.funcLog("randomRoom.addItem(new Transistor())");
                    randomRoom.addItem(new Transistor());
                    break;
                case 6:
                    randomRoom.addItem(new Sliderule(true));
                    break;
                default: break;
            }
        }
        ConsoleApp.returnLog("return");
    }

    public static ArrayList<Character> getStudents() { //wtf
        return null;
    }


    public static void endOfTurn() {
        for (Character c : characters) {
            ConsoleApp.funcLog("Character.endOfRound()");
            c.endOfRound();
        }
        //1 a 3 hoz esely
        if(1 == random.nextInt(0, 3)) {
            ConsoleApp.funcLog("RoomManager.triggerAllEffects()");
            roomManager.triggerAllEffects();
        }
        ConsoleApp.returnLog("return");
    }

    public static void removeCharacter(Character character) {
        ConsoleApp.returnLog("return");
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