package src.game;

import src.character.Student;
import src.item.Sliderule;
import src.item.Transistor;
import src.item.Batskin;
import src.item.Beerglass;
import src.room.Room;
import src.room.RoomManager;
import java.io.Console;

import src.character.Character;
import src.character.Teacher;
import src.effect.Cursed;
import src.effect.Effect;
import src.effect.Gassy;
import src.item.Camembert;
import src.item.FFP2;
import src.item.Rag;

public class Tester {
    //Logarléc teszt
    public void test1() {
        GameLogic gl = new GameLogic();
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Sliderule sliderule = new Sliderule();

        ConsoleApp.funcLog("room.addCharacter(student)");
        room.addCharacter(student);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("room.addItem(sliderule)");
        room.addItem(sliderule);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student.pickUpItem(0)");
        student.pickUpItem(0);
        ConsoleApp.returnLog("return");
    }

    //Camembert test
    public void test2() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 1);
        Teacher teacher1 = new Teacher(room1, 11);
        Student student1 = new Student(room1, 1);
        Camembert camembert1 = new Camembert();

        ConsoleApp.funcLog("room1.addCharacter(teacher1)");
        room1.addCharacter(teacher1);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("room1.addCharacter(student1)");
        room1.addCharacter(student1);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("camembert1.setOwner(student1)");
        camembert1.setOwner(student1);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student1.addToInventory(camembert1)");
        student1.addToInventory(camembert1);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student1.useItem(0)");
        student1.useItem(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("GameLogic.endOfTurn()");
        GameLogic.endOfTurn();
        ConsoleApp.returnLog("return");
    }

    //batskin teszt
    public void test3() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 0);
        Room room2 = new Room(2, 1);
        Student student = new Student(room2, 2);
        Teacher teacher = new Teacher(room1, 3);
        Batskin batskin = new Batskin();

        room1.addNeighbour(room2);

        ConsoleApp.funcLog("room1.addCharacter(teacher)");
        room1.addCharacter(teacher);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("room2.addCharacter(student)");
        room2.addCharacter(student);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("room2.addItem(batskin)");
        room2.addItem(batskin);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student.pickUpItem(0)");;
        student.pickUpItem(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("teacher.move(0)");
        teacher.move(0);
        ConsoleApp.returnLog("return");
    }

    //beerglass test
    public void test4() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 0);
        Room room2 = new Room(1, 1);
        Teacher teacher = new Teacher(room2, 0);
        Student student = new Student(room1, 0);
        Beerglass beerglass = new Beerglass();

        room2.addNeighbour(room1);

        ConsoleApp.funcLog("room1.addCharacter(student)");
        room1.addCharacter(student);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student.addToInventory(beerglass)");
        student.addToInventory(beerglass);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("room2.addCharacter(teacher)");
        room2.addCharacter(teacher);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("teacher.move(0)");
        teacher.move(0);
        ConsoleApp.returnLog("return");
    }


    //rag test
    public void test5() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 0);
        Room room2 = new Room(1, 0);
        Student student = new Student(room2, 0);
        Teacher teacher = new Teacher(room1, 0);
        Rag rag = new Rag();

        room2.addNeighbour(room1);

        ConsoleApp.funcLog("room2.addCharacter(student)");
        room2.addCharacter(student);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("room1.addCharacter(teacher)");
        room1.addCharacter(teacher);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student.addToInventory(rag)");
        student.addToInventory(rag);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student.move(0)");
        student.move(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("GameLogic.endOfTurn()");
        GameLogic.endOfTurn();
        ConsoleApp.returnLog("return");
    }

    //FFP2 test
    public void test6() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");
        
        Room room1 = new Room(2, 0);
        Room room2 = new Room(2, 0);
        Gassy gassy = new Gassy();

        ConsoleApp.funcLog("room2.addEffect(gassy)");
        room2.addEffect(gassy);
        ConsoleApp.returnLog("return");

        Student student = new Student(room1, 0);
        room1.addNeighbour(room2);

        ConsoleApp.funcLog("room1.addCharacter(student)");
        room1.addCharacter(student);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student.move(0)");
        student.move(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("GameLogic.endOfTurn()");
        GameLogic.endOfTurn();
        ConsoleApp.returnLog("return");
    }

    public void test7() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(5, 0);
        Room room2 = new Room(5, 1);
        Student student1 = new Student(room1, 0);
        Transistor transistor1 = new Transistor();
        Transistor transistor2 = new Transistor();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        room1.addItem(transistor2);
        transistor1.setOwner(student1);
        student1.addToInventory(transistor1);

        ConsoleApp.funcLog("student1.pickUpItem(0)");
        student1.pickUpItem(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student1.dropItem(transistor1)");
        student1.dropItem(transistor1);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student1.move(1)");
        student1.move(1);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student1.useItem(0)");
        student1.useItem(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("student1.dropItem(transistor1)");
        student1.dropItem(transistor1);
        ConsoleApp.returnLog("return");
    }

    public void test8() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room r1 = new Room(1, 0);
        Room r2 = new Room(1, 1);
        Room r3 = new Room(1, 2);
        r2.addNeighbour(r1);
        r2.addNeighbour(r3);
        r1.addNeighbour(r2);
        r3.addNeighbour(r2);
        Student s = new Student(r1, 0);

        ConsoleApp.funcLog("r1.addCharacter(s)");
        r1.addCharacter(s);
        ConsoleApp.returnLog("return");

        Teacher t = new Teacher(r3, 1);

        ConsoleApp.funcLog("r3.addCharacter(t)");
        r3.addCharacter(t);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("s.move(0)");
        s.move(0);
        ConsoleApp.returnLog("return");

        ConsoleApp.funcLog("t.move(0)");
        t.move(0);
        ConsoleApp.returnLog("return");
    }

    public void test9() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(1, 0);
        Room room2 = new Room(1, 1);
        room2.addEffect(new Cursed());
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 0);
        student1.move(1);
        roomManager.triggerAllEffects();
    }

    public void test10() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(1, 1);
        Room room2 = new Room(1, 2);
        room2.addEffect(new Gassy());
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        student1.move(0);
        roomManager.triggerAllEffects();
        student1.skipTurn();
    }

    public void test11() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Batskin batskin = new Batskin();

        room.addCharacter(student);

        room.addItem(batskin);

        student.pickUpItem(0);
    }

    public void test12() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 1);
        Room room2 = new Room(2, 2);
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        Teacher teacher1 = new Teacher(room2, 1);
        teacher1.move(0);
    }

    public void test13() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 1);
        Room room2 = new Room(2, 2);
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room1);
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        Teacher teacher1 = new Teacher(room2, 1);
        student1.move(0);
    }

    public void test14() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(1, 1);
        room1.addEffect(new Gassy());
        room1.addEffect(new Cursed());
        RoomManager roomManager = new RoomManager();
        roomManager.getRooms().add(room1);
        roomManager.splitRoom(room1);
        roomManager.mergeRooms(roomManager.getRooms().get(0), roomManager.getRooms().get(1));
    }
    public void test15() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        GameLogic.roomManager.generateRooms(5);
        GameLogic.generateCharacters(1, 1);
        GameLogic.generateItems(5);
    }
    public void test16() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(2, 1);
        Room room2 = new Room(2, 2);
        Room room3 = new Room(2, 3);
        RoomManager roomManager = new RoomManager();
        room1.addNeighbour(room2);
        room2.addNeighbour(room3); //room1 -> room2(gassy) -> room3
        roomManager.getRooms().add(room1);
        roomManager.getRooms().add(room2);
        roomManager.getRooms().add(room3);
        Student student1 = new Student(room1, 1);
        Teacher teacher1 = new Teacher(room1, 1);
        room1.addItem(new Batskin());
        room2.addEffect(new Gassy());
        student1.pickUpItem(0);
        teacher1.triggerExpelling(student1);
        student1.move(0);
        teacher1.move(0);
        student1.move(0);
        teacher1.move(0);
    }
    public void test17() {
        ConsoleApp.funcLog("GameLogic.startGame()");
        GameLogic.startGame();
        ConsoleApp.returnLog("return");

        Room room1 = new Room(1, 0);
        Student student = new Student(room1, 0);
        FFP2 ffp2 = new FFP2() ;
        room1.addCharacter(student);
        student.addToInventory(ffp2);

        student.dropItem(ffp2);
    }
}
