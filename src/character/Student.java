package src.character;

import java.util.ArrayList;
import java.util.List;

import src.item.Item;
import src.room.Room;

public class Student extends Character {
    private int id;
    public Student(Room currentRoom, int id) {
        super(currentRoom);
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    private void addToInventory(Item i) {
        inventory.add(i);
    }

    private void removeItem(Item i) {
        inventory.remove(i);
    }

    @Override
    public void pickUpItem() {
        ArrayList<Item> options = currentRoom.getItems();
        if (options.isEmpty()) return;
        //choose?
        Item chosen = options.get(0);
        addToInventory(chosen);
        currentRoom.removeItem(chosen);
    }

    @Override
    public void move() {
        ArrayList<Room> options = currentRoom.getNeighbours();
        //choose?
        Room targetRoom = options.get(0);
        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            changeRoom(targetRoom);
        }
    }

    @Override
    public void chooseAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseAction'");
    }

    @Override
    public void useItem(Item i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useItem'");
    }

    @Override
    public void chooseItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'chooseItem'");
    }

    @Override
    public boolean triggerExpelling(Student s) { //param?
        if (tryExpell()) {

        }
        return false;
    }

    @Override
    public boolean tryStun() {
        for (Item item : inventory) {
            if(item.defendStun())
                return true;
        }
        return false;
    }

    public boolean checkDefense() {
        for (Item item : inventory){
            if(item.checkDefense())
                return true;
        }
        return false;
    }

    @Override
    public boolean tryExpell() {
        return !checkDefense();
    }

    @Override
    public void endOfRound() {
        for (Item item : inventory) {
            item.decrRemainingTime();
        }
    }
}
