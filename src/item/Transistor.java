package src.item;

import src.room.Room;
import src.character.Character;

public class Transistor extends Item {
    private boolean isActive;
    private Item pair;
    private Room location;

    public Transistor() {
        super();
        this.isActive = false;
        this.pair = null;
    }

    @Override
    public void initItem(Character c){
        owner=c;
        for(Item i : c.getInventory()){
            if(i.IsUnpaired()){
                this.pair(i);
                i.pair(this);
                return;
            }
        }
    }

    @Override
    public boolean useItem(Character c) {
        if(!isActive) activate();
        return true;
    }

    @Override
    public boolean IsUnpaired() {
        return pair == null; //lehet nem pontos a compare
    }

    private void activate() { //ha paired akkor lehet csak aktiválni
        if (!IsUnpaired()) isActive = true;
    }

    private void deActivate(){
        isActive=false;
    }

    @Override
    public void pair(Item t) {
        pair = t;
    }

    private Room getPairLocation() { //itembe kene rakni abstractként
        return pair.getLocation();
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void drop() {
        if(pair!=null){
            if(isActive()){
                Room targetRoom = getPairLocation();
                Room currentRoom = owner.getCurrentRoom();
                if(targetRoom.requestChange()){
                    currentRoom.removeCharacter(owner);
                    targetRoom.addCharacter(owner);
                    owner.setRoom(targetRoom);
                    deActivate();
                }
            }
            pair.pair(null);
            this.pair(null);
        }
    }

    @Override
    public Room getLocation(){
        return location;
    }
    
}
