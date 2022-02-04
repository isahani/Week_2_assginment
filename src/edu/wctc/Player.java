package edu.wctc;
import java.util.List;
import java.util.ArrayList;

public class Player {
    private int score = 0;
    private List<String> inventory = new ArrayList<>();


    public Player(int score, List<String> inventory) {
        this.score = score;
        this.inventory = inventory;
    }

    public void AddToInventory(String newInventory) {
        inventory.add(newInventory);
    }

    public void AddToScore(int newScore) {
        score += newScore;
    }

    public String getInventory() {
        if (inventory != null) {
            return inventory.toString();
        }
        else {
            return "Empty Inventory";
        }
    }

    public int getScore() {
        return score;
    }
}
