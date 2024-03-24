package src.game;

import src.character.Student;

import java.io.Console;

import static src.game.SingletonLogger.logger;

public class Main {
    public static void main(String[] args) {

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
        logger.warning("Ejnye, bebugzott valami! (mock warning)");

        Tester tester = new Tester();
        tester.test1();
        tester.test2();
    }
}
