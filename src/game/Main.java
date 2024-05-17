package src.game;

import src.character.Student;
import src.gui.*;
import src.item.FFP2;
import src.room.Room;
import src.testing.TestCase;
import src.testing.TestFileLoader;
import src.testing.Tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*int studentCount = 5;
        GameLogic.roomManager.generateRooms(10);
        GameLogic.generateCharacters(studentCount, 2);
        GameLogic.generateItems(20);
        
        GUI gui = new GUI(GameLogic.getCharacters(), studentCount);
*/

        Room room1 = new Room(1, 5);
        RoomView roomView1 = new RoomView(room1);

        Room room2 = new Room(2, 5);
        RoomView roomView2 = new RoomView(room2);

        room1.addNeighbour(room2);
        room2.addNeighbour(room1);

        Student student1 = new Student(room1, 1);
        CharacterView studentView1 = new CharacterView(student1);
        roomView1.addCharacterView(studentView1);

        Student student2 = new Student(room1, 2);
        CharacterView studentView2 = new CharacterView(student2);
        roomView1.addCharacterView(studentView2);

        FFP2 ffp2 = new FFP2(0, false, 3);
        room2.addItem(ffp2);
        ItemView ffp2View = new ItemView(ffp2);
        roomView2.addItemView(ffp2View);

        GUIController.rooms.add(roomView1);
        GUIController.rooms.add(roomView2);
        GUIController.characters.add(studentView1);
        GUIController.characters.add(studentView2);
        GUIController.items.add(ffp2View);

        GUIController.rooms.forEach(r -> r.print());
        System.out.println();

        student1.move(0);
        student1.pickUpItem(0);

        GUIController.rooms.forEach(r -> r.print());


    //     List<String> testFileNames = new ArrayList<>();
    //     testFileNames.add("FFP2.txt");
    //     testFileNames.add("Camembert.txt");
    //     testFileNames.add("Airfreshener.txt");
    //     testFileNames.add("Beerglass.txt");
    //     testFileNames.add("Batskin.txt");
    //     // Random aktiválódik, így a teszt vagy jó vagy rossz xd
    //     testFileNames.add("CursedRoom.txt");
    //     testFileNames.add("FakeSliderule.txt");
    //     testFileNames.add("GameStart.txt");
    //     testFileNames.add("GassyRoom.txt");
    //     testFileNames.add("ItemDrop.txt");
    //     testFileNames.add("JanitorStep.txt");
    //     testFileNames.add("JanitorStepgassy.txt");
    //     testFileNames.add("Move.txt");
    //     testFileNames.add("PickUpItem.txt");
    //     testFileNames.add("Rag.txt");
    //     testFileNames.add("RoomSplitMerge.txt");
    //     testFileNames.add("Sliderule.txt");
    //     testFileNames.add("StudentMoveAndExpell.txt");
    //     testFileNames.add("TeacherStepAndExpell.txt");
    //     //FIXME A transistor drop pickup nem működik megfelelően
    //     testFileNames.add("Transistor.txt");

    //     TestFileLoader loader = new TestFileLoader();
    //     Tester tester = new Tester();

    //     for (String fileName : testFileNames) {
    //         TestCase testCaseTest = loader.load(fileName);
    //         tester.addTestCase(testCaseTest);
    //     }
    //     System.out.println();
    //     //System.out.println(testCaseTest);

        

    //     Scanner scanner = new Scanner(System.in);
    //     String option = "";

    //     while (!option.equalsIgnoreCase("9")) {
    //         System.out.println("1. Run tests");
    //         System.out.println("2. Run game");
    //         System.out.println("9. Exit");
    //         option = scanner.nextLine();

    //         switch(option) {
    //             case "1": {
    //                 System.out.println("Running tests...\n");
    //                 tester.runTests();
    //                 System.out.println();
    //                 break;
    //             }
    //             case "2": {
    //                 GameLogic.roomManager.generateRooms(10);
    //                 GameLogic.generateCharacters(5, 2);
    //                 GameLogic.generateItems(20);

    //                 GameLogic.runGame(true);

    //                 break;
    //             }
    //             case "9": System.out.println("byebye"); break;
    //             default: System.out.println("Rossz input");
    //         }
    //     }

    //     scanner.close();
    }
}
