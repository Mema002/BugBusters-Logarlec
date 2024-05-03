package src.game;

import src.item.Item;
import src.room.Room;
import src.room.RoomManager;
import src.character.Character;

import java.util.List;
import java.util.Scanner;

public class GameConsoleInterface {

    static void getAction(Character currentCharacter) {
        System.out.println("1. Move");
        System.out.println("2. Pick up item");
        System.out.println("3. Drop item");
        System.out.println("4. Use item");
        System.out.println("5. Skip turn");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                System.out.println("Room's neighbours: ");
                List<Room> neighbours = currentCharacter.getCurrentRoom().getNeighbours();
                for (int i = 0; i < neighbours.size(); i++)
                    System.out.println("[" + i + "] Room" + neighbours.get(i).getId());
                System.out.println();
                System.out.print("Move to room: ");
                try {
                    Integer idx = Integer.parseInt(scanner.nextLine());
                    if (idx < 0 || idx >= neighbours.size()) {
                        System.out.println("Invalid room index");
                        break;
                    }
                    currentCharacter.move(idx);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid room index");
                }
                System.out.println();
                System.out.println(currentCharacter + " " + currentCharacter.getId() + " moved to Room" + currentCharacter.getCurrentRoom().getId());
                System.out.println();

                break;
            case "2":

                System.out.println("Room's items: ");
                List<Item> roomItems = currentCharacter.getCurrentRoom().getItems();
                for (int i = 0; i < roomItems.size(); i++)
                    System.out.println("[" + i + "] " + roomItems.get(i) + " " + roomItems.get(i).getId());
                System.out.println();
                System.out.print("Pick up item from room: ");
                try {
                    Integer idx = Integer.parseInt(scanner.nextLine());
                    if (idx < 0 || idx >= roomItems.size()) {
                        System.out.println("Invalid room item index");
                        break;
                    }
                    currentCharacter.pickUpItem(idx);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid room item index");
                }
                System.out.println();
                System.out.println(currentCharacter.getInventory().get(currentCharacter.getInventory().size()-1) + " " + currentCharacter.getInventory().get(currentCharacter.getInventory().size()-1).getId() + " picked up from Room" + currentCharacter.getCurrentRoom().getId());
                System.out.println();

                break;
            case "3":

                System.out.println("Inventory items: ");
                List<Item> inventory = currentCharacter.getInventory();
                for (int i = 0; i < inventory.size(); i++)
                    System.out.println("[" + i + "] " + inventory.get(i) + " " + inventory.get(i).getId());
                System.out.println();
                System.out.print("Drop item from inventory: ");
                try {
                    Integer idx = Integer.parseInt(scanner.nextLine());
                    if (idx < 0 || idx >= inventory.size()) {
                        System.out.println("Invalid inventory item index");
                        break;
                    }
                    currentCharacter.dropItem(idx);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid inventory item index");
                }
                System.out.println();
                System.out.println(currentCharacter.getCurrentRoom().getItems().get(currentCharacter.getCurrentRoom().getItems().size()-1) + " " + currentCharacter.getCurrentRoom().getItems().get(currentCharacter.getCurrentRoom().getItems().size()-1).getId() + " dropped to Room" + currentCharacter.getCurrentRoom().getId());
                System.out.println();

                break;
            case "4":

                System.out.println("Inventory items: ");
                List<Item> studentInventory = currentCharacter.getInventory();
                for (int i = 0; i < studentInventory.size(); i++)
                    System.out.println("[" + i + "] " + studentInventory.get(i) + " " + studentInventory.get(i).getId());
                System.out.println();
                System.out.print("Use item from inventory: ");
                Integer idx = null;
                try {
                    idx = Integer.parseInt(scanner.nextLine());
                    if (idx < 0 || idx >= studentInventory.size()) {
                        System.out.println("Invalid inventory item index");
                        break;
                    }
                    currentCharacter.useItem(idx);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid inventory item index");
                }
                System.out.println();
                System.out.println(currentCharacter + "" + currentCharacter.getId() + " used " + currentCharacter.getInventory().get(idx) + " " + currentCharacter.getInventory().get(idx).getId() + " in Room " + currentCharacter.getCurrentRoom().getId());
                System.out.println();

                break;
            case "5":

                currentCharacter.skipTurn();
                System.out.println(currentCharacter + "" + currentCharacter.getId() + " skipped turn");

                break;
            default:
                break;
        }
    }
}
