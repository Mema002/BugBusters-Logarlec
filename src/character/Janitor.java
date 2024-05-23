package src.character;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import src.effect.Effect;
import src.effect.Sticky;
import src.game.ConsoleApp;
import src.gui.CharacterView;
import src.item.Item;
import src.room.Room;

public class Janitor extends Character {

    public Janitor(Room currentRoom, int id) {
        super(currentRoom);
    }

    @Override
    public void move(int targetIndex) {
        ConsoleApp.funcLog("currentRoom.getNeighbours()");
        ArrayList<Room> options = currentRoom.getNeighbours();

        if (options.isEmpty()) return;

        Room targetRoom = options.get(targetIndex);

        List<Character> characterToMove = new ArrayList<>();
        for (Character character : targetRoom.getCharacters()) {
            if (!character.getCurrentRoom().getNeighbours().isEmpty())
                characterToMove.add(character);
        }
        for (Character character : characterToMove) {
            for(int i=0; i<targetRoom.getNeighbours().size(); i++){
                Room potentialRoom = targetRoom.getNeighbours().get(i);
                if(!potentialRoom.equals(targetRoom) && potentialRoom.requestChange()){
                    character.move(i);
                    break;
                }
            }
        }

        if (targetRoom.requestChange()) {
            currentRoom.removeCharacter(this);
            targetRoom.addCharacter(this);
            setRoom(targetRoom);

            boolean cansticky=true;
            boolean canclean = false;
            ArrayList<Effect> cleanables= new ArrayList<>();
            for (Effect e : targetRoom.getEffects()) {
                if(e.canClearGas(targetRoom)){
                    canclean = true;
                    cleanables.add(e);
                }
                if(e.hasSticky(targetRoom)){
                    cansticky=false;
                }
            }
            if(cansticky){
                targetRoom.addEffect(new Sticky());
            }
            if(canclean){
                targetRoom.getEffects().removeAll(cleanables);
            }
        }
    }

    @Override
    public Item chooseItem() {
        return null;
    }

    @Override
    public boolean triggerExpelling(Student s) {
        return false;
    }

    @Override
    public String toString() {
        return "Janitor" + id;
    }

    @Override
    public CharacterView getView() {
        return new CharacterView(this);
    }
}
