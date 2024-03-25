package src.game;

import src.character.Student;
import src.item.Sliderule;
import src.item.Transistor;
import src.item.Batskin;
import src.item.Beerglass;
import src.room.Room;
import src.room.RoomManager;

import src.character.Teacher;
import src.effect.Cursed;
import src.effect.Gassy;
import src.item.Camembert;
import src.item.FFP2;
import src.item.Rag;

public class Tester {
    //Logarléc teszt
    public void test1() {
        GameLogic.startGame();

        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Sliderule sliderule = new Sliderule();

        ConsoleApp.funcLog("room.addCharacter(student)");
        room.addCharacter(student);
        ConsoleApp.funcLog("room.addItem(sliderule)");
        room.addItem(sliderule);

        ConsoleApp.funcLog("student.pickUpItem(0)");
        student.pickUpItem(0);

        ConsoleApp.addRoom(room);
        ConsoleApp.stateLog();
        ConsoleApp.resetState();
    }

    //Camembert test
    public void test2() {
        Room room1 = new Room(2, 1);
        Teacher teacher1 = new Teacher(room1, 11);
        Student student1 = new Student(room1, 1);
        Camembert camembert1 = new Camembert();

        ConsoleApp.funcLog("room.addCharacter(teacher1)");
        room1.addCharacter(teacher1);
        ConsoleApp.funcLog("room.addCharacter(student1)");
        room1.addCharacter(student1);
        ConsoleApp.funcLog("camembert1.setOwner(student1)");
        camembert1.setOwner(student1);
        ConsoleApp.funcLog("student1.addToInventory(camembert1)");
        student1.addToInventory(camembert1);

        ConsoleApp.funcLog("student1.useItem(0)");
        student1.useItem(0);

        ConsoleApp.funcLog("GameLogic.endOfTurn()");
        GameLogic.endOfTurn();

        ConsoleApp.addRoom(room1);
        ConsoleApp.stateLog();
        ConsoleApp.resetState();
    }

    //batskin teszt
    public void test3() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(2, 1);
        Student student = new Student(room2, 2);
        Teacher teacher = new Teacher(room1, 3);
        Batskin batskin = new Batskin();

        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room1.addCharacter(teacher)");
        room1.addCharacter(teacher);
        ConsoleApp.funcLog("room2.addCharacter(student)");
        room2.addCharacter(student);
        ConsoleApp.funcLog("room2.addItem(batskin)");
        room2.addItem(batskin);

        ConsoleApp.addRoom(room1);
        ConsoleApp.addRoom(room2);
        ConsoleApp.stateLog();

        ConsoleApp.funcLog("student.pickUpItem(0)");
        student.pickUpItem(0);

        ConsoleApp.funcLog("teacher.move(0)");
        teacher.move(0);

        ConsoleApp.stateLog();
        ConsoleApp.resetState();
    }

    //beerglass test
    public void test4() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(1, 1);
        Teacher teacher = new Teacher(room2, 0);
        Student student = new Student(room1, 0);
        Beerglass beerglass = new Beerglass();

        ConsoleApp.funcLog("room2.addItem(batskin)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("room1.addCharacter(student)");
        room1.addCharacter(student);
        ConsoleApp.funcLog("student.addToInventory(beerglass)");
        student.addToInventory(beerglass);
        ConsoleApp.funcLog("room2.addCharacter(teacher)");
        room2.addCharacter(teacher);

        ConsoleApp.funcLog("teacher.move(0)");
        teacher.move(0);
    }


    //rag test
    public void test5() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(1, 0);
        Student student = new Student(room2, 0);
        Teacher teacher = new Teacher(room1, 0);
        Rag rag = new Rag();

        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("room2.addCharacter(student)");
        room2.addCharacter(student);
        ConsoleApp.funcLog("room1.addCharacter(teacher)");
        room1.addCharacter(teacher);
        ConsoleApp.funcLog("student.addToInventory(rag)");
        student.addToInventory(rag);

        ConsoleApp.funcLog("student.move(0)");
        student.move(0);

        ConsoleApp.funcLog("GameLogic.endOfTurn()");
        GameLogic.endOfTurn();
    }

    //FFP2 test
    public void test6() {
        Room room1 = new Room(2, 0);
        Room room2 = new Room(2, 0);
        Gassy gassy = new Gassy();
        ConsoleApp.funcLog("room2.addEffect(gassy)");
        room2.addEffect(gassy);
        Student student = new Student(room1, 0);
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room1.addCharacter(student)");
        room1.addCharacter(student);

        ConsoleApp.funcLog("student.move(0)");
        student.move(0);

        ConsoleApp.funcLog("GameLogic.endOfTurn()");
        GameLogic.endOfTurn();
    }

    public void test7() {
        Room room1 = new Room(5, 0);
        Room room2 = new Room(5, 1);
        Student student1 = new Student(room1, 0);
        Transistor transistor1 = new Transistor();
        Transistor transistor2 = new Transistor();
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("room1.addItem(transistor2)");
        room1.addItem(transistor2);
        ConsoleApp.funcLog("transistor1.setOwner(student1)");
        transistor1.setOwner(student1);
        ConsoleApp.funcLog("student1.addToInventory(transistor1)");
        student1.addToInventory(transistor1);

        ConsoleApp.funcLog("student1.pickUpItem(0)");
        student1.pickUpItem(0);

        ConsoleApp.funcLog("student1.dropItem(transistor1)");
        student1.dropItem(transistor1);

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0);

        ConsoleApp.funcLog("student1.useItem(0)");
        student1.useItem(0);

        ConsoleApp.funcLog("student1.dropItem(transistor1)");
        student1.dropItem(transistor1);
    }

    public void test8() {
        Room r1 = new Room(1, 0);
        Room r2 = new Room(1, 1);
        Room r3 = new Room(1, 2);
        ConsoleApp.funcLog("r2.addNeighbour(r1)");
        r2.addNeighbour(r1);
        ConsoleApp.funcLog("r2.addNeighbour(r3)");
        r2.addNeighbour(r3);
        ConsoleApp.funcLog("r1.addNeighbour(r2)");
        r1.addNeighbour(r2);
        ConsoleApp.funcLog("r3.addNeighbour(r2)");
        r3.addNeighbour(r2);
        Student s = new Student(r1, 0);
        ConsoleApp.funcLog("r1.addCharacter(s)");
        r1.addCharacter(s);

        Teacher t = new Teacher(r3, 1);
        ConsoleApp.funcLog("r3.addCharacter(t)");
        r3.addCharacter(t);

        ConsoleApp.funcLog("s.move(0)");
        s.move(0);

        ConsoleApp.funcLog("t.move(0)");
        t.move(0);
    }

    public void test9() {
        Room room1 = new Room(1, 0);
        Room room2 = new Room(1, 1);
        ConsoleApp.funcLog("room2.addEffect(new Cursed())");
        room2.addEffect(new Cursed());
        RoomManager roomManager = new RoomManager();
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room1)");
        roomManager.getRooms().add(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room2)");
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 0);
        ConsoleApp.funcLog("room1.addCharacter(student1)");
        room1.addCharacter(student1);

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0);

        ConsoleApp.funcLog("roomManager.triggerAllEffects()");
        roomManager.triggerAllEffects();

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0);
    }

    public void test10() {
        Room room1 = new Room(1, 1);
        Room room2 = new Room(1, 2);
        room2.addEffect(new Gassy());
        RoomManager roomManager = new RoomManager();
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room1)");
        roomManager.getRooms().add(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room2)");
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        ConsoleApp.funcLog("room1.addCharacter(student1)");
        room1.addCharacter(student1);

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0);

        ConsoleApp.funcLog("roomManager.triggerAllEffects()");
        roomManager.triggerAllEffects();

        ConsoleApp.funcLog("student1.skipTurn()");
        student1.skipTurn();
    }

    public void test11() {
        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Batskin batskin = new Batskin();
        ConsoleApp.funcLog("room.addCharacter(student)");
        room.addCharacter(student);
        ConsoleApp.funcLog("room.addItem(batskin)");
        room.addItem(batskin);

        ConsoleApp.funcLog("student.pickUpItem(0)");
        student.pickUpItem(0);
    }

    public void test12() {
        Room room1 = new Room(2, 1);
        Room room2 = new Room(2, 2);
        RoomManager roomManager = new RoomManager();
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room1)");
        roomManager.getRooms().add(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room2)");
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        Teacher teacher1 = new Teacher(room2, 1);

        ConsoleApp.funcLog("teacher1.move(0)");
        teacher1.move(0);
    }

    public void test13() {
        Room room1 = new Room(2, 1);
        Room room2 = new Room(2, 2);
        RoomManager roomManager = new RoomManager();
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room1)");
        roomManager.getRooms().add(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room2)");
        roomManager.getRooms().add(room2);
        Student student1 = new Student(room1, 1);
        Teacher teacher1 = new Teacher(room2, 1);
        
        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0);
    }

    public void test14() {
        Room room1 = new Room(3, 1);
        ConsoleApp.funcLog("room1.addEffect(new Gassy())");
        room1.addEffect(new Gassy());
        ConsoleApp.funcLog("room1.addEffect(new Cursed())");
        room1.addEffect(new Cursed());
        RoomManager roomManager = new RoomManager();
        ConsoleApp.funcLog("roomManager.getRooms().add(room1)");
        roomManager.getRooms().add(room1);

        ConsoleApp.funcLog("roomManager.splitRoom(room1)");
        roomManager.splitRoom(room1);

        ConsoleApp.funcLog("roomManager.mergeRooms(roomManager.getRooms().get(0), roomManager.getRooms().get(1))");
        roomManager.mergeRooms(roomManager.getRooms().get(0), roomManager.getRooms().get(1));
    }
    public void test15() {
        ConsoleApp.funcLog("GameLogic.roomManager.generateRooms(5)");
        GameLogic.roomManager.generateRooms(5);

        ConsoleApp.funcLog("GameLogic.generateCharacters(1, 1)");
        GameLogic.generateCharacters(1, 1);
        
        ConsoleApp.funcLog("GameLogic.generateItems(5)");
        GameLogic.generateItems(5);
    }
    public void test16() {
        Room room1 = new Room(2, 1);
        Room room2 = new Room(2, 2);
        Room room3 = new Room(2, 3);
        RoomManager roomManager = new RoomManager();
        ConsoleApp.funcLog("room1.addNeighbour(room2)");
        room1.addNeighbour(room2);
        ConsoleApp.funcLog("room2.addNeighbour(room1)");
        room2.addNeighbour(room1);
        ConsoleApp.funcLog("room2.addNeighbour(room3)");
        room2.addNeighbour(room3);
        ConsoleApp.funcLog("room3.addNeighbour(room2)");
        room3.addNeighbour(room2);
        ConsoleApp.funcLog("roomManager.getRooms().add(room1)");
        roomManager.getRooms().add(room1);
        ConsoleApp.funcLog("roomManager.getRooms().add(room2)");
        roomManager.getRooms().add(room2);
        ConsoleApp.funcLog("roomManager.getRooms().add(room3)");
        roomManager.getRooms().add(room3);
        Student student1 = new Student(room2, 1);
        Teacher teacher1 = new Teacher(room1, 1);
        ConsoleApp.funcLog("room1.addItem(new Batskin())");
        room1.addItem(new Batskin());
        ConsoleApp.funcLog("room3.addEffect(new Gassy())");
        room3.addEffect(new Gassy());

        ConsoleApp.funcLog("ConsoleApp.returnLog(\"return\")");
        student1.pickUpItem(0);

        ConsoleApp.funcLog("teacher1.move(0)");
        teacher1.move(0);

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(1);

        ConsoleApp.funcLog("teacher1.move(0)");
        teacher1.move(1);

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0); //stun miatt nem mozog

        ConsoleApp.funcLog("teacher1.move(0)");
        teacher1.move(0); //stun miatt nem mozog

        ConsoleApp.funcLog("student1.move(0)");
        student1.move(0);

        ConsoleApp.funcLog("teacher1.move(0)");
        teacher1.move(0);
    }

    public void test17() {
        Room room1 = new Room(1, 0);
        Student student = new Student(room1, 0);
        FFP2 ffp2 = new FFP2() ;
        ConsoleApp.funcLog("room1.addCharacter(student)");
        room1.addCharacter(student);
        ConsoleApp.funcLog("student.addToInventory(ffp2)");
        student.addToInventory(ffp2);

        ConsoleApp.funcLog("student.dropItem(ffp2)");
        student.dropItem(ffp2);
    }
}
