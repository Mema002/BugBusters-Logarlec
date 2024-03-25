package src.game;

import src.character.Character;
import src.effect.Effect;
import src.item.Item;
import src.room.Room;

import java.util.*;

import static src.game.SingletonLogger.logger;

public class ConsoleApp {
    private static int tabCounter = 0;

    private static ArrayList<Room> rooms;

    static {
        rooms = new ArrayList<>();
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
        tabCounter--;
    }

    public static void addRoom(Room room){rooms.add(room);}

    public static void stateLog() {
        for(int i = 0; i<rooms.size(); i++){
            Room room = rooms.get(i);
            System.out.println(room.toString()+i);

            //Room items
            ArrayList<Item> itemList = room.getItems();
            System.out.println("\tRoom items:");
            //Item count for index
            ArrayList<String> itemCount = new ArrayList<>();
            for(int k = 0; k < itemList.size(); k++){
                Item item = itemList.get(k);
                System.out.println("\t\t"+itemList.get(k) + itemCount.stream().filter(x -> x == item.toString()).count()+1);
                itemCount.add(item.toString());
            }

            //Characters
            ArrayList<Character> characterList = room.getCharacters();
            System.out.println("\tCharacters:");
            ArrayList<String> characterCount = new ArrayList<>();
            for (int l = 0; l < characterList.size(); l++){
                Character character = characterList.get(l);
                System.out.println("\t\t"+ character.toString() + characterCount.stream().filter(x->x == character.toString()).count()+1);
                characterCount.add(character.toString());

                //Character items
                itemList = character.getInventory();
                System.out.println("\t\tRoom items:");
                //Item count for index
                itemCount = new ArrayList<>();
                for(int k = 0; k < itemList.size(); k++){
                    Item item = itemList.get(k);
                    System.out.println("\t\t\t"+itemList.get(k) + itemCount.stream().filter(x -> x == item.toString()).count()+1);
                    itemCount.add(item.toString());
                }
            }

            //Effects
            ArrayList<Effect> effectList = room.getEffects();
            System.out.println("\tRoom effects: ");
            for(Effect effect : effectList){
                System.out.println("\t\t"+effect.toString());
            }
        }
    }

    public static void resetState() {
        rooms.clear();
    }

    public static boolean writeOutInventory(Character character) {
        logger.info("Current player's id: " + character.getId());
        return true;
    }
}
