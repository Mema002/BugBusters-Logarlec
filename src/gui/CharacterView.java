package src.gui;

import src.character.Character;
import src.character.Janitor;
import src.character.Student;
import src.character.Teacher;
import src.dto.ChangeType;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

import javax.swing.ImageIcon;
import java.util.List;

public class CharacterView implements ModelObserver{
    private Character character;
    private ImageIcon icon;
    private List<ItemView> inventory;

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

    public Character getCharacter() {
        return character;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void addItemView(ItemView item) {
        inventory.add(item);
    }

    public void removeItemView(ItemView item) {
        inventory.remove(item);
    }

    public String toString() {
        return character.toString() + character.getId() + character.getInventory().toString();
    }

    @Override
    public void update(Room room, ChangeType type) {
        return;
    }

    @Override
    public void update(Character character, ChangeType type) {
        return;
    }

    @Override
    public void update(Item item, ChangeType type) {
        ItemView iv = GUIController.items.stream().filter(i -> i.item == item).findFirst().orElse(null);
        if (iv == null)
            return;
        if (type == ChangeType.ADD) {
            addItemView(iv);
        } else if (type == ChangeType.REMOVE) {
            removeItemView(iv);
        }
    }

    @Override
    public void update(Effect effect, ChangeType type) {
        return;
    }
}
