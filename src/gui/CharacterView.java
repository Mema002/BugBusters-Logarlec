package src.gui;

import src.character.Character;
import src.character.Janitor;
import src.character.Student;
import src.character.Teacher;

import javax.swing.ImageIcon;

public class CharacterView {
    public Character character;
    public ImageIcon icon;

    public CharacterView(Student s) {
        character = s;
        icon = new ImageIcon("images/Student.png");
    }

    public CharacterView(Teacher t) {
        character = t;
        icon = new ImageIcon("images/Teacher.png");
    }

    public CharacterView(Janitor j) {
        character = j;
        icon = new ImageIcon("images/Janitor.png");
    }

    public String toString() {
        return character.toString() + character.getId();
    }
}
