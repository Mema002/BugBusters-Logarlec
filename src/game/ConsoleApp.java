package src.game;

import src.character.Character;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

import java.util.*;

import static src.game.SingletonLogger.logger;

public class ConsoleApp {
    private static boolean writeFuncCall = true;
    private static int tabCounter;

    private static String consoleBuffer;

    private static ArrayList<Room> rooms;

    static {
        rooms = new ArrayList<>();
        tabCounter = 0;
        consoleBuffer = new String();
    }

    public static void funcLog(String func){
        if(writeFuncCall){
            for(int i = 0;i < tabCounter; i++){
                System.out.print('\t');
            }
            System.out.println(func);
            tabCounter++;
        }
    }

    public static void returnLog(String returnValue){
        if(writeFuncCall){
            for(int i = 0;i < tabCounter-1; i++){
                System.out.print('\t');
            }
            System.out.println(returnValue);
            if (tabCounter > 0)
                tabCounter--;
        }
    }

    public static void addRoom(Room room){rooms.add(room);}

    public static void stateLog() {
        toggleFuncCall();
        System.out.println("\n\nSTART STATELOG\n");

        for(int i = 0; i<rooms.size(); i++){
            Room room = rooms.get(i);
            consoleBuffer+=room.toString();
            consoleBuffer+=i+1;
            consoleBuffer+='\n';

            //Room items
            ConsoleApp.funcLog("room.getItems()");
            ArrayList<Item> itemList = room.getItems();
            consoleBuffer+="\tRoom items:\n";
            //Item count for index
            ArrayList<String> itemCount = new ArrayList<>();
            for(int k = 0; k < itemList.size(); k++){
                Item item = itemList.get(k);
                consoleBuffer+="\t\t";
                consoleBuffer+=item.toString();
                consoleBuffer+=itemCount.stream().filter(x -> x == item.toString()).count()+1;
                consoleBuffer+='\n';
                itemCount.add(item.toString());
            }

            //Characters
            ConsoleApp.funcLog("room.getCharacters()");
            ArrayList<Character> characterList = room.getCharacters();
            consoleBuffer+="\tCharacters\n";
            ArrayList<String> characterCount = new ArrayList<>();
            for (int l = 0; l < characterList.size(); l++){
                Character character = characterList.get(l);
                consoleBuffer+="\t\t";
                consoleBuffer+=character.toString();
                consoleBuffer+=characterCount.stream().filter(x->x == character.toString()).count()+1;
                consoleBuffer+='\n';
                characterCount.add(character.toString());

                //Character items
                ConsoleApp.funcLog("character.getInventory()");
                itemList = character.getInventory();
                consoleBuffer+="\t\tCharacter items:\n";
                //Item count for index
                itemCount = new ArrayList<>();
                for(int k = 0; k < itemList.size(); k++){
                    Item item = itemList.get(k);
                    consoleBuffer+="\t\t\t";
                    consoleBuffer+=item.toString();
                    consoleBuffer+=itemCount.stream().filter(x -> x == item.toString()).count()+1;
                    consoleBuffer+="\n";
                    itemCount.add(item.toString());
                }
            }

            //Effects
            ConsoleApp.funcLog("room.getEffects()");
            ArrayList<Effect> effectList = room.getEffects();
            consoleBuffer+="\tRoom effects:\n";
            for(Effect effect : effectList){
                consoleBuffer+="\t\t";
                consoleBuffer+=effect.toString();
                consoleBuffer+='\n';
            }

        }
        System.out.print(consoleBuffer);
        consoleBuffer = new String();

        System.out.println("\nEND STATELOG\n");
        toggleFuncCall();
    }

    public static void resetState() {
        writeFuncCall = true;
        rooms.clear();
    }

    public static boolean writeOutInventory(Character character) {
        logger.info("Current player's id: " + character.getId());
        return true;
    }

    public static void toggleFuncCall(){
        writeFuncCall = !writeFuncCall;
    }
}
