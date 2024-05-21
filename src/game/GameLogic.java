package src.game;

import java.util.*;
import java.util.random.RandomGenerator;

import src.character.Character;
import src.character.Student;
import src.character.Teacher;
import src.gui.GUIController;
import src.gui.GameLogicObserver;
import src.gui.ModelObserver;
import src.item.*;
import src.room.Room;
import src.room.RoomManager;
import src.testing.TestActionDTO;


public class GameLogic {
    private static int stepCounter;
    private static boolean isGameRunning;
    public static RoomManager roomManager;
    private static List<Character> characters;
    private static List<Character> deadCharacters;
    private static int playerCount;
    private static boolean hasAction;
    private static Character currentPlayer;
    private static List<GameLogicObserver> observers;
    private static List<TestActionDTO> actions = new ArrayList<>();
    //A veletlen actionokhoz
    private static Random random = new Random();

    static {
        roomManager = new RoomManager();
        characters = new ArrayList<Character>();
        deadCharacters = new ArrayList<Character>();
        observers = new ArrayList<>();
        isGameRunning = false;
        stepCounter = 0;
        playerCount = 0;
        hasAction = false;
    }

    public static void startGame() {
        isGameRunning = true;
        System.out.println("Game started");
    }

    public static void endGame() {
        isGameRunning = false;
        System.out.println("Game ended");
    }

    public static void runGame(boolean isRealGame) {
        //Itt fut a jatek

        startGame();

        int currentPlayerIdx = 0;

        ListIterator<TestActionDTO> actionIterator = actions.listIterator();

        while (isGameRunning) {
            //Ha nincs tobb jatekos
            if (playerCount == 0) {
                endGame();
                break;
            }

            //Ujbol indul ha az utolso karakter is meg volt
            if (currentPlayerIdx >= characters.size()) {
                ConsoleApp.funcLog("endOfTurn();");
                currentPlayerIdx = 0;
            }

            currentPlayer = characters.get(currentPlayerIdx);
            notifyObservers();
                
            //Ha van megadott action lista
            if (!isRealGame) {

                if (actionIterator.hasNext()) {
                    TestActionDTO action = actionIterator.next();
                    String actionString = action.action;


                    //Action választás

                    switch (actionString.toLowerCase()) {
                        case "move":
                            currentPlayer.move(Integer.parseInt(action.params[0]));
                            break;
                        case "pickupitem":
                            currentPlayer.pickUpItem(Integer.parseInt(action.params[0]));
                            break;
                        case "dropitem":
                            currentPlayer.dropItem(Integer.parseInt(action.params[0]));
                            break;
                        case "useitem":
                            currentPlayer.useItem(Integer.parseInt(action.params[0]));
                            break;
                        case "skipturn":
                            currentPlayer.skipTurn();
                            break;
                    }
                }
                else{
                    actions.clear();
                    endGame();
                }

            } //Ha nincs megadott action lista
            else {
                //TODO az actionok végre hajtása

                System.out.println(ConsoleApp.getLog(roomManager.getRooms()));
                System.out.println();
                System.out.println("Current player: " + currentPlayer + "" + currentPlayer.getId());
                System.out.println("\tCurrent room: Room " + currentPlayer.getCurrentRoom().getId());
                System.out.println("\t\tNeighbours: ");
                currentPlayer.getCurrentRoom().getNeighbours().forEach(room -> System.out.println("\t\t\tRoom " + room.getId()));
                System.out.println("\tInventory: ");
                currentPlayer.getInventory().forEach(item -> System.out.println("\t\t" + item + " " + item.getId()));
                System.out.println();
                //GameConsoleInterface.getAction(currentPlayer);
                System.out.println();

                //Ha jatekos
                if (currentPlayerIdx < playerCount) {
                    //Ha a játékos nem sunnolt
                    if (currentPlayer.getStunnedFor() == 0){
                        while (!hasAction) {
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        //Action happened
                        GUIController.updateStudentViews();
                        hasAction = false;
                    }
                //Ha AI
                } else {
                    //AI action
                    //TODO AI action
                    if(random.nextInt(3) == 1)
                        currentPlayer.skipTurn();
                    else {
                        int neighbourListSize = currentPlayer.getCurrentRoom().getNeighbours().size();
                        currentPlayer.move(random.nextInt(neighbourListSize-1));
                    }
                }
            }

            //Ha halt meg jatekos
            if (!deadCharacters.isEmpty()) {
                for (Character deadCharacter : deadCharacters){
                    //A sorrend miatt fontos
                    if (characters.indexOf(deadCharacter) < currentPlayerIdx)
                        currentPlayerIdx -= 1;
                    ConsoleApp.funcLog("characters.remove(deadCharacter)");
                    notifyObservers(deadCharacter);
                    characters.remove(deadCharacter);
                    playerCount--;
                    ConsoleApp.returnLog("return");
                }

                deadCharacters.clear();
            }

            if (currentPlayerIdx == 0 && stepCounter != 0)
                endOfTurn();
                GUIController.updateStudentViews();

            currentPlayerIdx++;
            stepCounter++;
        }
    }

    public static void setCharacters(List<Character> param) {
        characters = param;
    }

    public static List<Character> getCharacters() {
        return characters;
    }

    public static Character getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setAction() {
        hasAction = true;
    }

    public static void generateCharacters(int studentCount, int teacherCount) {
        playerCount = studentCount;
        Random random = new Random();
        List<Room> rooms = roomManager.getRooms();

        for (int i = 0; i < studentCount; i++) {
            int rndIdx = random.nextInt(rooms.size());
            Student newStudent = new Student(rooms.get(rndIdx), i);
            rooms.get(rndIdx).addCharacter(newStudent);
            characters.add(newStudent);
        }
        for (int i = 0; i < teacherCount; i++) {
            int rndIdx = random.nextInt(rooms.size());
            Teacher newTeacher = new Teacher(rooms.get(rndIdx), i);
            rooms.get(rndIdx).addCharacter(newTeacher);
            characters.add(newTeacher);
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
            int type = random.nextInt(8); //milyen itemet generaljunk
            int holderType = random.nextInt(2);
            Room randomRoom = rooms.get(random.nextInt(roomCount)); //melyik szobaba
            Character randomCharacter = characters.get(random.nextInt(characters.size())); //melyik karakterhez
            boolean isFake = random.nextInt(4) != 0;
            switch (type) {
                case 0:
                    ConsoleApp.funcLog("randomRoom.addItem(new Batskin())");
                    if (holderType == 1)
                        randomRoom.addItem(new Batskin(i, isFake, 3));
                    else
                        randomCharacter.addToInventory(new Batskin(i, isFake, 3));
                    break;
                case 1:
                    ConsoleApp.funcLog("randomRoom.addItem(new Beerglass())");
                    if (holderType == 1)
                        randomRoom.addItem(new Beerglass(i, isFake, 3));
                    else
                        randomCharacter.addToInventory(new Beerglass(i, isFake, 3));
                    break;
                case 2:
                    ConsoleApp.funcLog("randomRoom.addItem(new Camembert())");
                    if (holderType == 1)
                        randomRoom.addItem(new Camembert(i, isFake, 3));
                    else
                        randomCharacter.addToInventory(new Camembert(i, isFake, 3));
                    break;
                case 3:
                    ConsoleApp.funcLog("randomRoom.addItem(new FFP2())");
                    if (holderType == 1)
                        randomRoom.addItem(new FFP2(i, isFake, 3));
                    else
                        randomCharacter.addToInventory(new FFP2(i, isFake, 3));
                    break;
                case 4:
                    ConsoleApp.funcLog("randomRoom.addItem(new Rag())");
                    if (holderType == 1)
                        randomRoom.addItem(new Rag(i, isFake, 3));
                    else
                        randomCharacter.addToInventory(new Rag(i, isFake, 3));
                    break;
                case 5:
                    ConsoleApp.funcLog("randomRoom.addItem(new Transistor())");
                    if (holderType == 1)
                        randomRoom.addItem(new Transistor(i, false, 3));
                    else
                        randomCharacter.addToInventory(new Transistor(i, false, 3));
                    break;
                case 6:
                    if (holderType == 1)
                        randomRoom.addItem(new Airfreshener(i, isFake, 3));
                    else
                        randomCharacter.addToInventory(new Airfreshener(i, isFake, 3));
                    break;
                case 7: //hamis sliderule csak szobaba kerul
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
        /* if(1 == random.nextInt(0, 3)) {
            ConsoleApp.funcLog("RoomManager.triggerAllEffects()"); */
        roomManager.triggerAllEffects();
        //}
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

    public static void setActions(List<TestActionDTO> paramActions) {
        actions = paramActions;
    }

    public static void addObserver(GameLogicObserver observer) {
        observers.add(observer);
    }

    public static void removeObserver(GameLogicObserver observer) {
        observers.remove(observer);
    }

    private static void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }

    private static void notifyObservers(Character character) {
        observers.forEach(observer -> observer.update(character));
    }
}