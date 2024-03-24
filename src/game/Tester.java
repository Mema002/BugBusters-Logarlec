package src.game;

import src.character.Student;
import src.item.Sliderule;
import src.room.Room;

public class Tester {
    public void test1() {
        GameLogic.startGame();
        Room room = new Room(5,0);
        Student student = new Student(room, 0);
        Sliderule sliderule = new Sliderule(room);
        room.addCharacter(student);
        room.addItem(sliderule);
        student.pickUpItem();

    }
    
    public void test2() {
        
    }
}
