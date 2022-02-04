package edu.wctc;

public class ExitableRoom extends Room implements Exitable {
    private final String description;
    private final String exit;
    public ExitableRoom(String name, String description, String exit){
        super(name);
        this.description = description;
        this.exit =  exit;
    }

    @Override
    public String exit(Player player) {
        return "Your score is" + player.getScore();
        }

    @Override
    public String getDescription() {
        return "You are in exitable room";
    }
}
