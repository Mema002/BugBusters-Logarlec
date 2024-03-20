package src.Game;

import java.util.ArrayList;

public class Student extends Character {

    public Student(Room currentRoom) {
        super(currentRoom);
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
    public boolean checkStun() {
        //return false ha van maszk with durability > 0
        return true;
    }

    public boolean checkDefense() {
        return false;
    }

    @Override
    public boolean tryExpell() {
        return !checkDefense();
    }
}
