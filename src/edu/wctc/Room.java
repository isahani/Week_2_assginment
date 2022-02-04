package edu.wctc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Room{
    private String name;
    private Room north, south, east, west, up, down;
    //private String AjoiningRoom;
    //private String exit;
    //private String RoomName;
    //private boolean ValidDirection;

    public Room(String name){
        this.name = name;
    }

    public Room getAdjoiningRoom(char input) {
       // code to find adjacent room
        switch (input){
            case 'n':
                return north;
            case 's':
                return south;
            case 'e':
                return east;
            case 'w':
                return west;
            default:
                return null;
        }
    }

    public String getExits() {
        StringBuilder possibleExit = new StringBuilder();
       // code to return a list of possible exits
        List<Character> directions = new ArrayList<>(Arrays.asList('e', 'w', 'n', 's', 'u', 'd'));
        for (Character direction: directions){
            if (getAdjoiningRoom(direction) != null) {
                possibleExit.append(direction).append(" ");
            }
        }
       return "The exits are: " + possibleExit.toString();
    }

    public String getName() {
       return this.name;
    }

    public boolean isValidDirection(char direction) {
        // code for If this Room is connected to another Room in the given direction, return true. Otherwise, return false.
        if (getAdjoiningRoom(direction) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public abstract String getDescription();
}
