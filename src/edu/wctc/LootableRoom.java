package edu.wctc;

public class LootableRoom extends Room implements Lootable {
    private final String description, lootabledesc;
    private  final int points;
    public LootableRoom (String name, String description, String lootabledesc, int points){
        super(name);
        this.description = description;
        this.lootabledesc = lootabledesc;
        this.points = points;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String loot(Player player) {
        player.AddToInventory(description);
        player.AddToScore(points);
        return lootabledesc;
    }
}
