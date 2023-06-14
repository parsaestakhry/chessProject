public class Block {
    // class attributes

    // piece represents a chess piece on the board
    private Piece piece;

    // x and y represent the coordinates of the chess piece on the board
    private int x;
    private int y;

    // constructors


    public Block(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    // getters and setters

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
