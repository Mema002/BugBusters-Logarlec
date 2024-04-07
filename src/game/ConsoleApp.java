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

        LinkedHashMap<String, Integer> itemCount = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> characterCount = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> effectCount = new LinkedHashMap<>();

        System.out.println("\n\nSTART STATELOG\n");

        for(int i = 0; i<rooms.size(); i++){
            Room room = rooms.get(i);
            consoleBuffer+=room.toString();
            consoleBuffer+=i+1;
            consoleBuffer+='\n';

            //Room items
            ConsoleApp.funcLog("room.getItems()");
            ArrayList<Item> itemList = room.getItems();
            if(!itemList.isEmpty())
                consoleBuffer+="\tRoom items:\n";
            //Item count for index
            for(int k = 0; k < itemList.size(); k++){
                Item item = itemList.get(k);
                if(itemCount.containsKey(item.toString())){
                    Integer itemCountValue = itemCount.get(item.toString());
                    itemCountValue++;
                } else {
                    itemCount.put(item.toString(), 1);
                }
                consoleBuffer+="\t\t";
                consoleBuffer+=item.toString();
                consoleBuffer+=itemCount.get(item.toString());
                consoleBuffer+='\n';
            }

            //Characters
            ConsoleApp.funcLog("room.getCharacters()");
            ArrayList<Character> characterList = room.getCharacters();
            if(!characterList.isEmpty())
                consoleBuffer+="\tCharacters:\n";
            for (int l = 0; l < characterList.size(); l++){
                Character character = characterList.get(l);
                if(characterCount.containsKey(character.toString())){
                    Integer characterCountValue = characterCount.get(character.toString());
                    characterCountValue++;
                } else {
                    characterCount.put(character.toString(), 1);
                }
                consoleBuffer+="\t\t";
                consoleBuffer+=character.toString();
                consoleBuffer+=characterCount.get(character.toString());
                consoleBuffer+='\n';

                //Character items
                ConsoleApp.funcLog("character.getInventory()");
                itemList = character.getInventory();
                if(!itemList.isEmpty())
                    consoleBuffer+="\t\tCharacter items:\n";
                //Item count for index
                for(int k = 0; k < itemList.size(); k++){
                    Item item = itemList.get(k);
                    if(itemCount.containsKey(item.toString())){
                        Integer itemCountValue = itemCount.get(item.toString());
                        itemCountValue++;
                    } else {
                        itemCount.put(item.toString(), 1);
                    }
                    consoleBuffer+="\t\t\t";
                    consoleBuffer+=item.toString();
                    consoleBuffer+=itemCount.get(item.toString());
                    consoleBuffer+="\n";
                }
            }

            //Effects
            ConsoleApp.funcLog("room.getEffects()");
            ArrayList<Effect> effectList = room.getEffects();
            if(!effectList.isEmpty())
                consoleBuffer+="\tRoom effects:\n";
            for(Effect effect : effectList){
                if(effectCount.containsKey(effect.toString())){
                    Integer effectCountValue = effectCount.get(effect.toString());
                    effectCountValue++;
                } else {
                    effectCount.put(effect.toString(), 1);
                }
                consoleBuffer+="\t\t";
                consoleBuffer+=effect.toString();
                consoleBuffer+=effectCount.get(effect.toString());
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
