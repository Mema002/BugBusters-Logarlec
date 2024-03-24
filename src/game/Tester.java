package src.game;

import src.character.Student;
import src.item.Sliderule;
import src.room.Room;

import src.character.Character;
import src.character.Student;
import src.character.Teacher;
import src.effect.Effect;
import src.item.Camembert;
import src.room.Room;

public class Tester {
    public void test1() {
        GameLogic.startGame();
        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Sliderule sliderule = new Sliderule(room);
        room.addCharacter(student);
        room.addItem(sliderule);
        student.pickUpItem(0);

    }

    //Camembert test
    public void test2() {
        Room room1 = new Room(2, 1);
        Teacher teacher1 = new Teacher(room1, 11);
        Student student1 = new Student(room1, 1);
        Camembert camembert1 = new Camembert(room1);
        ConsoleApp.consoleLog(this, camembert1, "Tester to Camembert setOwner");
        camembert1.setOwner(student1);

        ConsoleApp.consoleLog(this, student1, "Tester to Student addToInventory");
        student1.addToInventory(camembert1);

        ConsoleApp.consoleLog(this, camembert1, "Tester to Student useItem");
        student1.useItem(0);


        ConsoleApp.reset();
    }

    public void test3() {

    }
}
