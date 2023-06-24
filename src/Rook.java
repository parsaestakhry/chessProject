class Rook extends Piece {

    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Block start, Block end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX  = end.getX();
        int endY = end.getY();
        // checking if the movement is in the boundaries of the board
        if (!board.isInBoard(endX, endY)){
            return false;
        }
        // checking if there's any piece of the same color in the end spot
        if (end.getPiece()!= null && end.getPiece().isWhite() == this.isWhite()){
            return false;
        }

        // checking the horizontal and the vertical movement
        // if the both are different it means that the rook has moved diagonally
        if (startX != endX && startY != endY) {
            return false;
        }

        // checking if there are any pieces in the way of rook
        // moving horizontally
        if (startX == endX){
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);
            for (int y = minY ; y < maxY; y ++ )
            {
                if (board.getBlock(startX, y).getPiece() !=null){
                    return false;
                }
            }
            // moving vertically
        } else {
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);
            for (int x = minX ; x < maxX; x ++ )
            {
                if (board.getBlock(x, startY).getPiece() !=null){
                    return false;
                }
            }

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
    public String getName(){
        return "R";
    }


}
