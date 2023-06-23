class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        int startX = start.getX();
        int endX = end.getX();
        int startY = end.getY();
        int endY = end.getY();

        // check if it's in board boundaries
        if (!board.isInBoard(endX , endY)){
            return false;
        }
        // check if there's a piece of the same color in the destination of the bishop
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        // check if the movement is diagonal
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        if (deltaY != deltaX){
            return false;
        }
        // checking if a piece is blocking the bishop's movement
        int xDirection = (endX > startX) ? 1 : -1;
        int yDirection = (endY > startY) ? 1 : -1;
        int x = startX + xDirection;
        int y = startY + xDirection;

        while (x != endX && y != endY){
            if (board.getBlock(x , y).getPiece() != null){
                return false;
            }
            x += xDirection;
            y += yDirection;
        }
        // the movement is valid
        return true;
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
    public void capture(Board board,  Block start, Block end) {
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
