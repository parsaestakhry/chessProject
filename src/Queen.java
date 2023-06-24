class Queen extends Piece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX  = end.getX();
        int endY = end.getY();
        // checking if the movement is in the boundaries of the board
        if (!board.isInBoard(endX , endY)){
            return false;
        }
        // checking if there's any piece in the destination
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        // checking the horizontal move if there's any piece on the way
        if (startX == endX){
            int maxY = Math.max(startY , endY);
            int minY = Math.min(startY , endY);
            for (int y = minY; y < maxY; y ++){
                if (board.getBlock(startX, y) != null){
                    return false;
                }
            }
            // checking the vertical move
        } else {
            int maxX = Math.max(startX , endX);
            int minX = Math.min(startX , endX);
            for (int x = minX; x < maxX; x ++){
                if (board.getBlock(x , startY) != null){
                    return false;
                }
            }
        }

        // checking the diagonal move
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

    @Override
    public String getName() {
        return "Q";
    }
}
