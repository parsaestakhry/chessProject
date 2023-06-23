public abstract class Piece {
    // class attributes

    private boolean killed;
    private boolean white;
    private boolean moved;


    // class constructors

    public Piece(boolean white) {
        this.white = white;
    }

    // getters and setters


    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean hasMoved() {
        return false;
    }

    public void setHasMoved(boolean moved){
        this.moved = moved;
    }

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Block start, Block end);
    public abstract void move(Board board, Block start, Block end);
    public abstract void capture(Board board,  Block start, Block end);


}

