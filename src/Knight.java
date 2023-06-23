class Knight extends Piece {

    public Knight(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        int startX = start.getX();
        int endX = end.getX();
        int startY = start.getY();
        int endY = end.getY();

        // checking the boundaries of the board
        if (!board.isInBoard(endX , endY)){
            return false;
        }
        // checking if there's a piece of the same color in the destination
        if (end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        // checking the L shaped movement
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);

    }

    @Override
    public void move(Board board, Block start, Block end) {
        if (canMove(board, start, end)){
            // indicating that the pawn has moved
            setHasMoved(true);
            // setting the piece in the destination
            end.setPiece(this);
            // emptying the place that the piece has been
            start.setPiece(null);
        }
    }

    @Override
    public void capture(Board board, Block start, Block end) {
        if (canMove(board, start, end)){
            // indicating that the pawn has moved
            setHasMoved(true);
            Piece capturedPiece = end.getPiece();
            capturedPiece.setKilled(true);
            // setting the piece in the destination
            end.setPiece(this);
            // emptying the place that the piece has been
            start.setPiece(null);
        }
    }
}
