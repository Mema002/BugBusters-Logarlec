package src.game;

import src.testing.TestCase;
import src.testing.TestFileLoader;
import src.testing.Tester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> testFileNames = new ArrayList<>();
        testFileNames.add("FFP2.txt");
        testFileNames.add("Camembert.txt");
        testFileNames.add("Airfreshener.txt");
        testFileNames.add("Beerglass.txt");
        testFileNames.add("CursedRoom.txt");
        testFileNames.add("FakeSliderule.txt");
        testFileNames.add("GameStart.txt");
        testFileNames.add("GassyRoom.txt");
        testFileNames.add("ItemDrop.txt");
        testFileNames.add("JanitorStep.txt");
        testFileNames.add("JanitorStepgassy.txt");
        testFileNames.add("Move.txt");
        testFileNames.add("Osszetett.txt");
        testFileNames.add("PickUpItem.txt");
        testFileNames.add("Rag.txt");
        testFileNames.add("RoomSplitMerge.txt");
        testFileNames.add("Sliderule.txt");
        testFileNames.add("StudentMoveAndExpell.txt");
        testFileNames.add("TeacherStepAndExpell.txt");
        testFileNames.add("Transistor.txt");

        TestFileLoader loader = new TestFileLoader();
        Tester tester = new Tester();

        for (String fileName : testFileNames) {
            TestCase testCaseTest = loader.load(fileName);
            tester.addTestCase(testCaseTest);
        }
        System.out.println();
        //System.out.println(testCaseTest);

        System.out.println("Running tests...\n");
        tester.runTests();

//        BufferedReader reader = new BufferedReader(
//            new InputStreamReader(System.in));
//
//        String number = "";
//        while(number != "q") {
//            System.out.println("BugBusters ProjLab tesztprogram");
//            System.out.println("Tesztesetek:");
//            System.out.println("1.  Logarlec");
//            System.out.println("2.  Camembert");
//            System.out.println("3.  TVSZ Deneverbor");
//            System.out.println("4.  Szent sorospohar");
//            System.out.println("5.  Nedves Torlorongy");
//            System.out.println("6.  FFP2-es maszk");
//            System.out.println("7.  Tranzisztor");
//            System.out.println("8.  Lepes");
//            System.out.println("9.  Elatkozott szoba");
//            System.out.println("10. Gazos szoba");
//            System.out.println("11. Targyfelvetel");
//            System.out.println("12. Tanar lepes es buktatas");
//            System.out.println("13. Hallgato lepes es megbukas");
//            System.out.println("14. Szoba osztodas es osszeolvadas");
//            System.out.println("15. Jatek kezdete");
//            System.out.println("16. Osszetett eset");
//            System.out.println("17. Targyeldobasa");
//            System.out.println("q: Exit");
//            //logger.warning("Ejnye, bebugzott valami! (mock warning)");
//
//        number = reader.readLine();
//        Tester tester = new Tester();
//        switch(number){
//            case "1": tester.test1(); break;
//            case "2": tester.test2(); break;
//            case "3": tester.test3(); break;
//            case "4": tester.test4(); break;
//            case "5": tester.test5(); break;
//            case "6": tester.test6(); break;
//            case "7": tester.test7(); break;
//            case "8": tester.test8(); break;
//            case "9": tester.test9(); break;
//            case "10": tester.test10(); break;
//            case "11": tester.test11(); break;
//            case "12": tester.test12(); break;
//            case "13": tester.test13(); break;
//            case "14": tester.test14(); break;
//            case "15": tester.test15(); break;
//            case "16": tester.test16(); break;
//            case "17": tester.test17(); break;
//            case "q": System.out.println("Bye-bye"); return;
//            default: System.out.println("Rossz input!"); break;
//        }
//        System.out.println();
//        }
//
    }
}
