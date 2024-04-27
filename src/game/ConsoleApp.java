package src.game;

import src.character.Character;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

import java.util.*;

import static src.game.SingletonLogger.logger;

public class ConsoleApp {
    private static boolean logging = true;
    private static int tabCounter;

    private static StringBuilder consoleBuffer;

    private static ArrayList<Room> rooms;

    public static void turnOffLogging() { logging = false; }
    public static void turnOnLogging() { logging = true; }

    static {
        rooms = new ArrayList<>();
        tabCounter = 0;
        consoleBuffer = new StringBuilder();
    }

    public static void funcLog(String func){
        if(logging){
            for(int i = 0;i < tabCounter; i++){
                System.out.print('\t');
            }
            System.out.println(func);
            tabCounter++;
        }
    }

    public static void returnLog(String returnValue){
        if(logging){
            for(int i = 0;i < tabCounter-1; i++){
                System.out.print('\t');
            }
            System.out.println(returnValue);
            if (tabCounter > 0)
                tabCounter--;
        }
    }

    public static void addRoom(Room room){ rooms.add(room); }

    public static void addRooms(List<Room> rooms){
        rooms.addAll(rooms);
    }

    public static String getLog() {
        turnOffLogging();

        for(int i = 0; i<rooms.size(); i++){
            Room room = rooms.get(i);
            consoleBuffer.append(room.toString());
            consoleBuffer.append(room.getId());
            consoleBuffer.append('\n');

            //Room items
            ConsoleApp.funcLog("room.getItems()");
            ArrayList<Item> itemList = room.getItems();
            if(!itemList.isEmpty())
                consoleBuffer.append("\tRoom items:\n");
            //Item count for index
            for(int k = 0; k < itemList.size(); k++){
                Item item = itemList.get(k);
                consoleBuffer.append("\t\t");
                consoleBuffer.append(item.toString());
                consoleBuffer.append(item.getId());
                consoleBuffer.append('\n');
            }

            //Characters
            ConsoleApp.funcLog("room.getCharacters()");
            ArrayList<Character> characterList = room.getCharacters();
            if(!characterList.isEmpty())
                consoleBuffer.append("\tCharacters:\n");
            for (int l = 0; l < characterList.size(); l++){
                Character character = characterList.get(l);
                consoleBuffer.append("\t\t");
                consoleBuffer.append(character.toString());
                consoleBuffer.append(character.getId());
                consoleBuffer.append('\n');

                //Character items
                ConsoleApp.funcLog("character.getInventory()");
                itemList = character.getInventory();
                if(!itemList.isEmpty())
                    consoleBuffer.append("\t\tCharacter items:\n");
                //Item count for index
                for(int k = 0; k < itemList.size(); k++){
                    Item item = itemList.get(k);
                    consoleBuffer.append("\t\t\t");
                    consoleBuffer.append(item.toString());
                    consoleBuffer.append(item.getId());
                    consoleBuffer.append("\n");
                }
            }

            //Effects
            ConsoleApp.funcLog("room.getEffects()");
            ArrayList<Effect> effectList = room.getEffects();
            if(!effectList.isEmpty())
                consoleBuffer.append("\tRoom effects:\n");
            for(Effect effect : effectList){
                consoleBuffer.append("\t\t");
                consoleBuffer.append(effect.toString());
                consoleBuffer.append(effect.toString());
                consoleBuffer.append('\n');
            }

        }

        turnOnLogging();

        return consoleBuffer.toString();
    }

    public static void stateLog() {
        StringBuilder stringBuilder = new StringBuilder(getLog());
        stringBuilder.insert(0, "\n\nSTART STATELOG\n");
        stringBuilder.append("\nEND STATELOG\n");
        logger.info(stringBuilder.toString());
    }

    public static void resetState() {
        logging = true;
        rooms.clear();
        consoleBuffer = new StringBuilder();
    }

    public static boolean writeOutInventory(Character character) {
        logger.info("Current player's id: " + character.getId());
        return true;
    }
}
