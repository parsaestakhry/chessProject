public class Pawn extends Piece{

        public Pawn(boolean white) {
            super(white);
        }

        @Override
        public boolean canMove(Board board, Block start, Block end) {
            int startX = start.getX();
            int startY = start.getY();
            int endX = end.getX();
            int endY = end.getY();

            // check the color of the piece
            int direction = this.isWhite() ? 1 : -1;

            // check if the movement is in the bounds of the board
            if (!board.isInBoard(endX, endY)) {
                return false;
            }
            // check if there is another at the end point
            if (end.getPiece() != null) {
                return false;
            }
            // check if pawn is moving by one row
            if (startY == endY && startX + direction == endX) {
                return true;
            }
            // checking pawn's initial two row movement
            if (startY == endY && startX + (2 * direction) == endX && !hasMoved()) {
                return true;
            }

            // check if the pawn can make a capture move
            if (Math.abs(startY - endY) == 1 && startX + direction == endX) {
                // Check if there is an opponent's piece at the end position
                Piece pieceAtEnd = board.getPieceAt(end);
                return pieceAtEnd != null && pieceAtEnd.isWhite() != isWhite();
            }

            // Invalid move if none of the conditions are met
            return false;

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


}
