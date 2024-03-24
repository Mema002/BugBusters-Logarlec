package src.game;

import src.character.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static src.game.SingletonLogger.logger;

public class ConsoleApp {
    private static HashMap<Object, Integer> calls;

    ConsoleApp() {
        calls = new HashMap<>();
    }

    public static void consoleLog(Object caller, Object called, String text){
        //A gyoker hozzaadasa
        if(calls.isEmpty())
            calls.put(caller, 0);

        //Ha visszalep a faban torli a gyerekeit
        ArrayList<Object> forDelete = new ArrayList<>();
        for(Map.Entry<Object, Integer> call : calls.entrySet()){
            if(call.getValue() > calls.get(caller))
                forDelete.add(call);
        }
        //Itt torli
        for(Object o : forDelete)
            calls.remove(o);

        //A fuggveny tabulatorozasnal a hivo+1 lesz
        int tabNum = calls.get(caller) + 1;

        //Ha nincs benne hozzaadja az adot tabulator szammal egyutt
        if(!calls.containsKey(called))
            calls.put(called, tabNum);

        //Kiiras
        for(int i = 0; i < tabNum; i++)
            System.out.print('\n');
        System.out.println(text);
    }

    public static void reset() { calls.clear(); }

    /*public static boolean writeOutInventory(Character character) {
        logger.info("Current player's id: " + character.getId());
        return true;
    }*/
}
