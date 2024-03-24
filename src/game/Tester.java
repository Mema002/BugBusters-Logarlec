package src.game;

import src.character.Student;
import src.item.Sliderule;
import src.item.Batskin;
import src.room.Room;
import src.room.RoomManager;
import src.character.Character;
import src.character.Teacher;
import src.effect.Effect;
import src.effect.Gassy;
import src.item.Camembert;

public class Tester {
    //Logarléc teszt
    public void test1() {
        GameLogic gl = new GameLogic();
        ConsoleApp.consoleLog(this, gl, "Tester to GameLogic startGame");
        GameLogic.startGame();

        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Sliderule sliderule = new Sliderule();

        ConsoleApp.consoleLog(this, room, "Tester to Room addCharacter");
        room.addCharacter(student);

        ConsoleApp.consoleLog(this, room, "Tester to Room addItem");
        room.addItem(sliderule);

        ConsoleApp.consoleLog(this, student, "Tester to Student pickUpItem");
        student.pickUpItem(0);

        ConsoleApp.reset();
    }

    //Camembert test
    public void test2() {
        Room room1 = new Room(2, 1);
        Teacher teacher1 = new Teacher(room1, 11);
        Student student1 = new Student(room1, 1);
        Camembert camembert1 = new Camembert();
        ConsoleApp.consoleLog(this, room1, "Tester to Room addCharacter");
        room1.addCharacter(teacher1);

        ConsoleApp.consoleLog(this, room1, "Tester to Room addCharacter");
        room1.addCharacter(student1);

        ConsoleApp.consoleLog(this, camembert1, "Tester to Camembert setOwner");
        camembert1.setOwner(student1);

        ConsoleApp.consoleLog(this, student1, "Tester to Student addToInventory");
        student1.addToInventory(camembert1);

        ConsoleApp.consoleLog(this, camembert1, "Tester to Student useItem");
        student1.useItem(0);

        GameLogic.endOfTurn();

        ConsoleApp.reset();
    }

    public void test3() {

    }
    public void test4() {

    }
    public void test5() {

    }
    public void test6() {

    }
    public void test7() {

    }
    public void test8() {

    }
    public void test9() {

    }
    public void test10() {
        Room room1 = new Room(1, 1);
        Room room2 = new Room(1, 2);
        room2.addEffect(new Gassy());
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        ConsoleApp.consoleLog(this, student1, "Tester to Student move");
        student1.move(0);
        ConsoleApp.consoleLog(this, roomManager, "Tester to RoomManager triggerAllEffects");
        roomManager.triggerAllEffects();
    }
    public void test11() {
        GameLogic gl = new GameLogic();
        ConsoleApp.consoleLog(this, gl, "Tester to GameLogic startGame");
        GameLogic.startGame();

        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Batskin batskin = new Batskin();

        ConsoleApp.consoleLog(this, room, "Tester to Room addCharacter");
        room.addCharacter(student);

        ConsoleApp.consoleLog(this, room, "Tester to Room addItem");
        room.addItem(batskin);

        ConsoleApp.consoleLog(this, student, "Tester to Student pickUpItem");
        student.pickUpItem(0);

        ConsoleApp.reset();
    }
    public void test12() {
        Room room1 = new Room(1, 1);
        Room room2 = new Room(1, 2);
        room2.addEffect(new Gassy());
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        Teacher teacher1 = new Teacher(room2, 1);
        ConsoleApp.consoleLog(this, (Teacher)teacher1, "Tester to Teacher move");
        teacher1.move(0);
    }
    public void test13() {

    }
    public void test14() {

    }
    public void test15() {

    }
    public void test16() {

    }
    public void test17() {

    }
}
