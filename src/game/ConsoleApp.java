package src.game;

import src.character.Character;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

import java.awt.image.ConvolveOp;
import java.util.*;

import static src.game.SingletonLogger.logger;

public class ConsoleApp {
    private static int tabCounter;

    private static String consoleBuffer;

    private static ArrayList<Room> rooms;

    static {
        rooms = new ArrayList<>();
        tabCounter = 0;
        consoleBuffer = new String();
    }

    public static void funcLog(String func){
        for(int i = 0;i < tabCounter; i++){
            System.out.print('\t');
        }
        System.out.println(func);
        tabCounter++;
    }

    public static void returnLog(String returnValue){
        for(int i = 0;i < tabCounter-1; i++){
            System.out.print('\t');
        }
        System.out.println(returnValue);
        if (tabCounter > 0)
            tabCounter--;
    }

    public static void addRoom(Room room){rooms.add(room);}

    public static void stateLog() {

        System.out.println("\nstart stateLog\n");

        for(int i = 0; i<rooms.size(); i++){

            Room room = rooms.get(i);
            //System.out.println(room.toString()+""+i);
            consoleBuffer+=room.toString();
            consoleBuffer+=i+1;
            consoleBuffer+='\n';

            //Room items
            ConsoleApp.funcLog("room.getItems()");
            ArrayList<Item> itemList = room.getItems();
            //System.out.println("\tRoom items:");
            consoleBuffer+="\tRoom items:\n";
            //Item count for index
            ArrayList<String> itemCount = new ArrayList<>();
            for(int k = 0; k < itemList.size(); k++){
                Item item = itemList.get(k);
                //System.out.println("\t\t"+ item.toString + "" + itemCount.stream().filter(x -> x == item.toString()).count()+1);
                consoleBuffer+="\t\t";
                consoleBuffer+=item.toString();
                consoleBuffer+=itemCount.stream().filter(x -> x == item.toString()).count()+1;
                consoleBuffer+='\n';
                itemCount.add(item.toString());
            }

            //Characters
            ConsoleApp.funcLog("room.getCharacters()");
            ArrayList<Character> characterList = room.getCharacters();
            //System.out.println("\tCharacters:");
            consoleBuffer+="\tCharacters\n";
            ArrayList<String> characterCount = new ArrayList<>();
            for (int l = 0; l < characterList.size(); l++){
                Character character = characterList.get(l);
                //System.out.println("\t\t"+ character.toString() + "" + characterCount.stream().filter(x->x == character.toString()).count()+1);
                consoleBuffer+="\t\t";
                consoleBuffer+=character.toString();
                consoleBuffer+=characterCount.stream().filter(x->x == character.toString()).count()+1;
                consoleBuffer+='\n';
                characterCount.add(character.toString());

                //Character items
                ConsoleApp.funcLog("character.getInventory()");
                itemList = character.getInventory();
                //System.out.println("\t\tCharacter items:");
                consoleBuffer+="\t\tCharacter items:\n";
                //Item count for index
                itemCount = new ArrayList<>();
                for(int k = 0; k < itemList.size(); k++){
                    Item item = itemList.get(k);
                    //System.out.println("\t\t\t"+item.toString() + "" + itemCount.stream().filter(x -> x == item.toString()).count()+1);
                    consoleBuffer+="\t\t\t";
                    consoleBuffer+=item.toString();
                    consoleBuffer+=itemCount.stream().filter(x -> x == item.toString()).count()+1;
                    consoleBuffer+='\n';
                    itemCount.add(item.toString());
                }
            }

            //Effects
            ConsoleApp.funcLog("room.getEffects()");
            ArrayList<Effect> effectList = room.getEffects();
            //System.out.println("\tRoom effects: ");
            consoleBuffer+="\tRoom effects:\n";
            for(Effect effect : effectList){
                //System.out.println("\t\t"+effect.toString());
                consoleBuffer+="\t\t";
                consoleBuffer+=effect.toString();
                consoleBuffer+='\n';
            }

        }
        System.out.print("\n\n");
        System.out.print(consoleBuffer);
        consoleBuffer = new String();

        System.out.println("\nend stateLog\n");
    }

    public static void resetState() {
        rooms.clear();
    }

    public static boolean writeOutInventory(Character character) {
        logger.info("Current player's id: " + character.getId());
        return true;
    }
}
