class King extends Piece {

    public King(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // checking if it's in the boundaries of the board
        if (!board.isInBoard(endX , endY)){
            return false;
        }
        if ()

    }

    @Override
    public void move(Board board, Block start, Block end) {

    }

    public boolean isTrapped(){
        return false;
    }


}
