package src.game;

import src.character.Student;
import src.item.Sliderule;
import src.item.Batskin;
import src.item.Beerglass;
import src.room.Room;
import src.room.RoomManager;
import java.io.Console;

import src.character.Character;
import src.character.Teacher;
import src.effect.Effect;
import src.effect.Gassy;
import src.item.Camembert;
import src.item.Rag;

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

    //batskin teszt
    public void test3() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(2, 1);
        Student student = new Student(room2, 2);
        Teacher teacher = new Teacher(room1, 3);
        Batskin batskin = new Batskin();

        room1.addNeighbour(room2);

        ConsoleApp.consoleLog(this, room1, "Tester to Room addCharacter");
        room1.addCharacter(teacher);

        ConsoleApp.consoleLog(this, room2, "Tester to Room addCharacter");
        room2.addCharacter(student);

        ConsoleApp.consoleLog(this, room2, "Tester to Room addItem");
        room2.addItem(batskin);

        ConsoleApp.consoleLog(this, student, "Tester to Student pickUpItem");
        student.pickUpItem(0);

        ConsoleApp.consoleLog(this, teacher, "Tester to Teacher move");
        teacher.move(0);

        ConsoleApp.reset();
    }

    //beerglass test
    public void test4() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(1, 1);
        Teacher teacher = new Teacher(room2, 0);
        Student student = new Student(room1, 0);
        Beerglass beerglass = new Beerglass();

        room2.addNeighbour(room1);

        room1.addCharacter(student);
        student.addToInventory(beerglass);
        room2.addCharacter(teacher);

        teacher.move(0);

        ConsoleApp.reset();
    }


    //rag test
    public void test5() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(1, 0);
        Student student = new Student(room2, 0);
        Teacher teacher = new Teacher(room1, 0);
        Rag rag = new Rag();

        room2.addNeighbour(room1);

        room2.addCharacter(student);
        room1.addCharacter(teacher);

        student.addToInventory(rag);

        student.move(0);

        GameLogic.endOfTurn();

        ConsoleApp.reset();
    }

    //FFP2 test
    public void test6() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(2, 0);
        Gassy gassy = new Gassy();
        room2.addEffect(gassy);
        Student student = new Student(room1, 0);
        room1.addNeighbour(room2);
        room1.addCharacter(student);

        student.move(0);

        GameLogic.endOfTurn();
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
        ConsoleApp.consoleLog(this, GameLogic.getGameLogic(), "Tester to GameLogic startGame");
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

    }
    public void test13() {

    }
    public void test14() {

    }
    public void test15() {
        ConsoleApp.consoleLog(this, GameLogic.getGameLogic(), "Tester to GameLogic startGame");
        GameLogic.startGame();
        GameLogic.roomManager.generateRooms(5);
        GameLogic.generateCharacters(1, 1);
        GameLogic.generateItems(5);
        ConsoleApp.reset();
    }
    public void test16() {

    }
    public void test17() {

    }
}
