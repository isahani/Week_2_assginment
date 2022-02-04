package edu.wctc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    Room currrentroom;
    Player player;
    boolean isFinished = false;
    List myList = new ArrayList();

    public Maze() {
        Player player = new Player(0, myList);
        this.player = player;

        Room reception = new InteractableRoom("You are in the Reception", "This place is haunted find an exit soon", "You dive into haunted building full of zombies", -25);
        Room cafe = new LootableRoom("Welcome to cafe", "There is vending machine here", "You found a protein bar to eat", 100);
        Room lobby = new LootableRoom("You entered in lobby", "There is wallet lying on floor", "You found money",100);
        Room firstfloor = new InteractableRoom("You have reached first floor", "Its very dark here", "You dive into a zombie nest, Run", -25);
        Room parking = new ExitableRoom("You entered in parking", "There is a car you can hop into", "S");


        currrentroom = reception;
        reception.setNorth(lobby);
        lobby.setEast(parking);
        lobby.setUp(firstfloor);
        firstfloor.setDown(lobby);
        lobby.setNorth(cafe);
        cafe.setSouth(lobby);
        lobby.setSouth(reception);
        parking.setWest(lobby);

        }
    public String exitCurrentRoom() {
        if (currrentroom instanceof ExitableRoom){
            return ((ExitableRoom) currrentroom).exit(player);
        }
        else {
            return currrentroom + " is not exitable";
        }
    }

    public String interactWithCurrentRoom() {
        //code for If the currentRoom is Interactable, it returns the result of calling interact on the Room. If not, it returns a message that no interactions are possible.
        if (currrentroom instanceof InteractableRoom) {
            return ((InteractableRoom) currrentroom).interact(player);
        }
        else {
            return "This room is not interactable";
        }
    }
    public String lootCurrentRoom() {
        //code
        if (currrentroom instanceof LootableRoom) {
           return  ((LootableRoom) currrentroom).loot(player);
        }
        else {
            return currrentroom + " is not lootable";
        }
    }

    public boolean move(char direction) {
        List<Character> directions = new ArrayList<>(Arrays.asList('e', 'w', 'n', 's', 'u', 'd'));
        if (directions.contains(direction)) {
            if (currrentroom.isValidDirection(direction)) {
                currrentroom = currrentroom.getAdjoiningRoom(direction);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    public int getPlayerScore() {
        return player.getScore();
    }
    public String getPlayerInventory() {
        return player.getInventory();
    }

    public boolean isFinished() {
        if (currrentroom instanceof ExitableRoom ){
            return true;
        }
        else {
            return false;
        }
    }

    public String getCurrentRoomDescription(){
        return currrentroom.getDescription();
    }

    public String getCurrentRoomExit(){
        return currrentroom.getExits();
    }
}
