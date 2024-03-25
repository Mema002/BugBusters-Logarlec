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
        ConsoleApp.funcLog("character.geInventory()");
        for (Item i : c.getInventory()) {
            ConsoleApp.funcLog("Item.IsUnpaired()");
            if (i.IsUnpaired()) {
                ConsoleApp.funcLog("Item.pair()");
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
        if(!isActive) {
            ConsoleApp.funcLog("activate()");
            activate();
        }
        ConsoleApp.returnLog("return true");
        return true;
    }

    @Override
    public boolean IsUnpaired() {
        ConsoleApp.returnLog("return " + String.valueOf(pair == null));
        return pair == null; //lehet nem pontos a compare
    }

    private void activate() { //ha paired akkor lehet csak aktiválni
        if (!IsUnpaired()) {
            ConsoleApp.funcLog("IsUnpaired()");
            isActive = true;
        }
        ConsoleApp.returnLog("return");
    }

    private void deActivate() {
        ConsoleApp.returnLog("return");
        isActive = false;
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
                ConsoleApp.funcLog("getPairLocation()");
                Room targetRoom = getPairLocation();
                ConsoleApp.funcLog("owner.getCurrentRoom()");
                Room currentRoom = owner.getCurrentRoom();
                ConsoleApp.funcLog("targetRoom.requestChange()");
                if (targetRoom.requestChange()) {
                    ConsoleApp.funcLog("currentRoom.removeCharacter(owner)");
                    currentRoom.removeCharacter(owner);
                    ConsoleApp.funcLog("targetRoom.addCharacter(owner)");
                    targetRoom.addCharacter(owner);
                    ConsoleApp.funcLog("owner.setRoom(targetRoom)");
                    owner.setRoom(targetRoom);
                    ConsoleApp.funcLog("deActivate()");
                    deActivate();
                }
            }
            ConsoleApp.funcLog("pair.pair(null)");
            pair.pair(null);
            ConsoleApp.funcLog("this.pair(null)");
            this.pair(null);
        }
        ConsoleApp.returnLog("return");
    }

    @Override
    public Room getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Transistor";
    }
}
