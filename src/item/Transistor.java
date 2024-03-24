package src.item;

import src.room.Room;
import src.character.Character;
import src.game.ConsoleApp;

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
    public void initItem(Character c) {
        owner=c;
        for (Item i : c.getInventory()) {
            ConsoleApp.funcLog("Transistor to Item IsUnpaired");
            if (i.IsUnpaired()) {
                ConsoleApp.funcLog("Transistor to Item pair");
                this.pair(i);
                i.pair(this);
                ConsoleApp.returnLog("return");
                return;
            }
        }
        ConsoleApp.returnLog("return");
    }

    @Override
    public boolean useItem(Character c) {
        if(!isActive) activate();
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public boolean IsUnpaired() {
        ConsoleApp.returnLog("return " + String.valueOf(pair == null));
        return pair == null; //lehet nem pontos a compare
    }

    private void activate() { //ha paired akkor lehet csak aktiválni
        if (!IsUnpaired()) isActive = true;
        ConsoleApp.returnLog("return");
    }

    private void deActivate() {
        ConsoleApp.returnLog("return");
        isActive=false;
    }

    @Override
    public void pair(Item t) {
        ConsoleApp.returnLog("return");
        pair = t;
    }

    private Room getPairLocation() { //itembe kene rakni abstractként
        ConsoleApp.returnLog("return location");
        return pair.getLocation();
    }

    @Override
    public boolean isActive() {
        ConsoleApp.returnLog("return" + String.valueOf(isActive));
        return isActive;
    }

    @Override
    public void drop() {
        if (pair != null){
            if (isActive()) {
                ConsoleApp.funcLog("Transistor to Transistor getPairLocation");
                Room targetRoom = getPairLocation();
                ConsoleApp.funcLog("Transistor to Character getCurrentRoom");
                Room currentRoom = owner.getCurrentRoom();
                ConsoleApp.funcLog("Transistor to Room requestChange");
                if (targetRoom.requestChange()) {
                    ConsoleApp.funcLog("Transistor to Room removeCharacter");
                    currentRoom.removeCharacter(owner);
                    ConsoleApp.funcLog("Transistor to Room addCharacter");
                    targetRoom.addCharacter(owner);
                    ConsoleApp.funcLog("Transistor to Character setRoom");
                    owner.setRoom(targetRoom);
                    ConsoleApp.funcLog("Transistor to Transistor deActivate");
                    deActivate();
                }
            }
            ConsoleApp.funcLog("Transistor to Transistor pair");
            pair.pair(null);
            ConsoleApp.funcLog("Transistor to Transistor pair");
            this.pair(null);
        }
        ConsoleApp.returnLog("return");
    }

    @Override
    public Room getLocation() {
        ConsoleApp.returnLog("return location");
        return location;
    }

    @Override
    public String toString() {
        return "Transistor";
    }
}
