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
        return Math.abs(startY - endY) <= 1 && Math.abs(startX - endX) <= 1;


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

    public boolean isChecked(Board board, Block kingBlock){
        int kingX = kingBlock.getX();
        int kingY = kingBlock.getY();

        // checking for horizontal and vertical attacks

        int[][] directions = {{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};
        for (int[] direction : directions){
            int dx = direction[0];
            int dy = direction[1];
            int x = kingX + dx;
            int y = kingY + dy;

            while (board.isInBoard(x , y)){
                Block block = board.getBlock(x , y);
                Piece piece = block.getPiece();

                if (piece != null){
                    if (piece.isWhite() != this.isWhite() && (piece instanceof Rook || piece instanceof Queen)) {
                        return true; // king is under attack
                    } else {
                        break; // a piece is blocking a path
                    }

                }
            }

        }
        // checking for diagonal attacks
        int [][] diagonalDirections = {{1 , 1} , {-1 , -1 } , {1, -1} , {-1 , 1}};
        for (int[] direction : diagonalDirections ){
            int dx = direction[0];
            int dy = direction[1];
            int x = kingX + dx;
            int y = kingY + dy;

            while (board.isInBoard(x , y)){
                Block block = board.getBlock(x , y);
                Piece piece = block.getPiece();

                if (piece != null){
                    if (piece.isWhite() != this.isWhite() && (piece instanceof Bishop || piece instanceof Queen)){
                        return true;
                    }
                    else break;
                }

            }

        }
        int[][] knightDirections = {{2 , 1}, {1 , 2}, {-2 , 1},
                {-1 , 2}, {2 , -1}, {1 , -2} ,
                {-2 , -1} , {-1 , -2}};
        for (int [] direction : knightDirections){
            int dx = direction[0];
            int dy = direction[1];
            int x = kingX + dx;
            int y = kingY + dy;

            while (board.isInBoard(x , y)){
                Block block = board.getBlock(x , y);
                Piece piece = block.getPiece();
                if (piece instanceof Knight && piece.isWhite() != this.isWhite()){
                    return true;
                }
                x += dx;
                y += dy;
            }
        }
        return false;
    }
    public boolean isMate(Board board, Block kingBlock){
        // if the king is not in check then it's not in check mate
        int kingX = kingBlock.getX();
        int kingY = kingBlock.getY();
        if (!isChecked(board , kingBlock)){
            return false;
        }
        // check if the king can move to neighboring pieces to escape
        int [][] neighborBlocks = {{1 ,0 } , {1 , 1} , {1 , -1} , {-1 , 1} , {-1 , -1} , {-1 , 0} , {0 , 1} , {0 , -1}  };

        for (int[] move : neighborBlocks){
            int dx = move[0];
            int dy = move[1];
            int x = kingX + dx;
            int y = kingY + dy;

            if (board.isInBoard(x , y)){
                Block block = board.getBlock(x , y);
                if (!isChecked(board ,block) && canMove(board , kingBlock , block)){
                    // king can move to a escape block
                    return false;
                }
            }
        }
        gameStatus status = gameStatus.FINISHED;
        return true;
    }


}
