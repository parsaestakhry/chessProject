class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        return false;
    }

    @Override
    public void move(Board board, Block start, Block end) {

    }
}
