public class HumanPlayer extends Player {

    public HumanPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
    }

    @Override
    public String playerColor() {
        if (this.whiteSide){
            return "white";
        }
        else {
            return "black";
        }
    }
}
