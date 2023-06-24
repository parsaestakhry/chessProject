public class ComputerPlayer extends Player {

    public ComputerPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
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
