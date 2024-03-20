package src.Game;

import java.util.ArrayList;
import java.util.Random;

public class Teacher extends Character {

    public Teacher(Room currentRoom) {
        super(currentRoom);
    }
    
    private void expellStudent(Student s) {
        s.setExpelled();
    }

    @Override
    public void move() {
        ArrayList<Room> options = currentRoom.getNeighbours();
        int targetIndex;
        if (options.size() == 0) return;
        if (options.size() == 1) targetIndex = 0;
        else {
            Random random = new Random();
            targetIndex = random.nextInt(options.size() + 1);
        }

        Room targetRoom = options.get(targetIndex);
        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            changeRoom(targetRoom);
            /* for (Character c : targetRoom.getCharacters()) {
                if (c.tryExpell())
            } */
        }
    }

    @Override
    public void pickUpItem() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pickUpItem'");
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
    public boolean triggerExpelling(Student s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'triggerExpelling'");
    }

    @Override
    public boolean checkStun() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkStun'");
    }

    @Override
    public boolean tryExpell() {
        return false;
    }
}
