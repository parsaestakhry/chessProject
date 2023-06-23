public class HumanPlayer extends Player {

    public HumanPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
    }
    public String playerColor (boolean whiteSide){
        if (this.whiteSide){
            return "white";
        }
        else {
            return "black";
        }
    }
}
