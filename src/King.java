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
        // checking if there's a piece of same color
        if (end.getPiece().isWhite() == this.isWhite()){
            return false;
        }
        // checking if the move is more than one square horizontally
        if (Math.abs(startY - endY) > 1){
            return false;
        }
        // checking if the move is more than one square vertically
        if (Math.abs(startX - endX) > 1){
            return false;
        }
        // checking if the move is more than one square diagonally
        if (Math.abs(startY - endY) > 1 && Math.abs(startX - endX) > 1){
            return false;
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
    public void capture(Board board, Board another, Block start, Block end) {

    }

    public boolean isChecked(){
        return false;
    }

    public boolean isMate(){
        return false;
    }


}
