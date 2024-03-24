package src.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import src.game.GameLogic;
import src.item.Item;
import src.room.Room;

public class Teacher extends Character {

    private int id;
    public Teacher(Room currentRoom, int id) {
        super(currentRoom);
        this.id = id;
    }
    @Override
    public int getId() {
        return id;
    }
    
    private void expellStudent(Student s) {
        s.setExpelled();
    }

    @Override
    public void move() {
        ArrayList<Room> options = currentRoom.getNeighbours();
        int targetIndex;
        if (options.isEmpty()) return;
        if (options.size() == 1) targetIndex = 0;
        else {
            Random random = new Random();
            targetIndex = random.nextInt(options.size() /*+ 1*/);
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
    public boolean tryExpell() {
        return false;
    }

    @Override
    public void endOfRound() {
        List<Character> inRoomCharacters = currentRoom.getCharacters();
        for (Character character : inRoomCharacters) {
            if(character.tryExpell()){
                character.setExpelled();
                GameLogic.removeCharacter(character);
                currentRoom.removeCharacter(character);
            }
        }
    }
}
