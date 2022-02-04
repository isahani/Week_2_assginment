package edu.wctc;

public class InteractableRoom extends Room implements Interactable{
    private final String description, intmessage;
    private final int points;

    public InteractableRoom (String name, String description, String intmessage, int points){
        super(name);
        this.description = description;
        this.intmessage = intmessage;
        this.points = points;
    }

    @Override
    public String interact(Player player) {
        player.AddToScore(points);
        return intmessage;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
