package src.game;

import src.character.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static src.game.SingletonLogger.logger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

        String number = "";
        while(number != "q"){
            ConsoleApp.writeOutInventory(new Student(null, 0));
        logger.info("BugBusters ProjLab tesztprogram");
        logger.info("Tesztesetek:");
        logger.info("1.  Logarlec");
        logger.info("2.  Camembert");
        logger.info("3.  TVSZ Deneverbor");
        logger.info("4.  Szent sorospohar");
        logger.info("5.  Nedves Torlorongy");
        logger.info("6.  FFP2-es maszk");
        logger.info("7.  Tranzisztor");
        logger.info("8.  Lepes");
        logger.info("9.  Elatkozott szoba");
        logger.info("10. Gazos szoba");
        logger.info("11. Targyfelvetel");
        logger.info("12. Tanar lepes es buktatas");
        logger.info("13. Hallgato lepes es megbukas");
        logger.info("14. Szoba osztodas es osszeolvadas");
        logger.info("15. Jatek kezdete");
        logger.info("16. Osszetett eset");
        logger.info("17. Targyeldobasa");
        logger.info("q: Exit");
        logger.warning("Ejnye, bebugzott valami! (mock warning)");
        
        number = reader.readLine();
        Tester tester = new Tester();
        switch(number){
            case "1": tester.test1(); break;
            case "2": tester.test2(); break;
            case "3": tester.test3(); break;
            case "4": tester.test4(); break;
            case "5": tester.test5(); break;
            case "6": tester.test6(); break;
            case "7": tester.test7(); break;
            case "8": tester.test8(); break;
            case "9": tester.test9(); break;
            case "10": tester.test10(); break;
            case "11": tester.test11(); break;
            case "12": tester.test12(); break;
            case "13": tester.test13(); break;
            case "14": tester.test14(); break;
            case "15": tester.test15(); break;
            case "16": tester.test16(); break;
            case "17": tester.test17(); break;
            case "q": return;
            default: break;
        }
        System.out.println();
        }
        
    }
}
