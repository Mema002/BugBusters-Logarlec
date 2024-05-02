package src.game;

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

        List<String> testFileNames = new ArrayList<>();
        testFileNames.add("FFP2.txt");
        testFileNames.add("Camembert.txt");
        testFileNames.add("Airfreshener.txt");
        testFileNames.add("Beerglass.txt");
        testFileNames.add("Batskin.txt");
        // Random aktiválódik, így a teszt vagy jó vagy rossz xd
        testFileNames.add("CursedRoom.txt");
        testFileNames.add("FakeSliderule.txt");
        testFileNames.add("GameStart.txt");
        testFileNames.add("GassyRoom.txt");
        testFileNames.add("ItemDrop.txt");
        // TODO Janitor kiküldi a karaktereket implementálása
        // testFileNames.add("JanitorStep.txt");
        // TODO Stcky effekt implementálása
        // testFileNames.add("JanitorStepgassy.txt");
        testFileNames.add("Move.txt");
        //TODO Szerintem töröljük ki ez az összetettet
        // testFileNames.add("Osszetett.txt");
        testFileNames.add("PickUpItem.txt");
        testFileNames.add("Rag.txt");
        testFileNames.add("RoomSplitMerge.txt");
        testFileNames.add("Sliderule.txt");
        testFileNames.add("StudentMoveAndExpell.txt");
        testFileNames.add("TeacherStepAndExpell.txt");
        //FIXME A transistor drop pickup nem működik megfelelően
        testFileNames.add("Transistor.txt");

        TestFileLoader loader = new TestFileLoader();
        Tester tester = new Tester();

        for (String fileName : testFileNames) {
            TestCase testCaseTest = loader.load(fileName);
            tester.addTestCase(testCaseTest);
        }
        System.out.println();
        //System.out.println(testCaseTest);

        

        Scanner scanner = new Scanner(System.in);
        String option = "";

        while (!option.equalsIgnoreCase("9")) {
            System.out.println("1. Run tests");
            System.out.println("2. Run game");
            System.out.println("9. Exit");
            option = scanner.nextLine();

            switch(option) {
                case "1": {
                    System.out.println("Running tests...\n");
                    tester.runTests();
                    System.out.println();
                    break;
                }
                case "2": {
                    //futtatni a játékot ide
                    break;
                }
                case "9": System.out.println("byebye"); break;
                default: System.out.println("Rossz input");
            }
        }

        scanner.close();
    }
}
