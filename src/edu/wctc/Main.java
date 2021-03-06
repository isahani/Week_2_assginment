package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(maze.currrentroom.getName());
            System.out.println(maze.getCurrentRoomDescription());
            System.out.println(maze.currrentroom.getExits());
            String direction = scanner.nextLine();
            if (direction.charAt(0) == 'l'){
                System.out.println(maze.lootCurrentRoom());
            }
            else if (direction.charAt(0) == 'x'){
                System.out.println(maze.exitCurrentRoom());
            }
            else if (direction.charAt(0) == 'i'){
                System.out.println(maze.interactWithCurrentRoom());
            }
            else {
                maze.move(direction.charAt(0));
            }
        } while (!maze.isFinished());

        System.out.println("GAME OVER \n Your Score is: " + maze.player.getScore());
        /*
        maze.interactWithCurrentRoom();
        System.out.println(maze.getPlayerInventory());
        System.out.println(maze.getPlayerScore());
        String direction = scanner.nextLine();
        maze.move(direction.charAt(0));
        //maze.move('n');
        System.out.println(maze.currrentroom.getName());
        System.out.println(maze.getCurrentRoomDescription());
        //maze.move('e');
        direction = scanner.nextLine();
        maze.move(direction.charAt(0));
        maze.move('n');
        System.out.println(maze.currrentroom.getName());
        System.out.println(maze.getCurrentRoomDescription());
        maze.lootCurrentRoom();
        System.out.println(maze.getPlayerInventory());
        System.out.println(maze.getPlayerScore());

         */
    }
}
