package src.game;


public class ConsoleApp {
    private static int tabCounter = 0;

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
}
