public class Board {
    Block[][] squares;

    // constructors

    public Board() {
    }

    // getters and setters
    public Boolean isInBoard(int x, int y) {
        return  (x > 7 || x < 0 || y > 7 || y < 0);
    }

    public Block getBlock(int x, int y){
        return squares[x][y];
    }

    public Piece getPieceAt(Block block){
        return block.getPiece();
    }

    public void resetBoard() {
        // initializing the white pieces : bottom row
        squares[0][0] = new Block(0 , 0 , new Rook(true));
        squares[0][1] = new Block(0 , 1 , new Knight(true));
        squares[0][2] = new Block(0 , 2 , new Bishop(true));
        squares[0][3] = new Block(0 , 3 , new Queen(true));
        squares[0][4] = new Block(0 , 4, new King(true));
        squares[0][7] = new Block(0 , 0 , new Rook(true));
        squares[0][6] = new Block(0 , 1 , new Knight(true));
        squares[0][5] = new Block(0 , 2 , new Bishop(true));
        // initializing the white pawns
//        squares[1][0] = new Block(1 , 0, new Pawn(true));
//        squares[1][1] = new Block(1 , 0, new Pawn(true));
//        squares[1][2] = new Block(1 , 0, new Pawn(true));
//        squares[1][3] = new Block(1 , 0, new Pawn(true));
//        squares[1][4] = new Block(1 , 0, new Pawn(true));
//        squares[1][5] = new Block(1 , 0, new Pawn(true));
//        squares[1][6] = new Block(1 , 0, new Pawn(true));
//        squares[1][7] = new Block(1 , 0, new Pawn(true));
        for (int w = 0 ;w < squares[1].length; w ++){
            squares[1][w] = new Block(1 , w , new Pawn(true));
        }

        // initializing the black pieces : top row
        squares[7][0] = new Block(7 , 0 , new Rook(false));
        squares[7][1] = new Block(7 , 1 , new Knight(false));
        squares[7][2] = new Block(7 , 2 , new Bishop(false));
        squares[7][3] = new Block(7 , 3 , new Queen(false));
        squares[7][4] = new Block(7 , 4 , new King(false));
        squares[7][7] = new Block(7 , 0 , new Rook(false));
        squares[7][6] = new Block(7 , 1 , new Knight(false));
        squares[7][5] = new Block(7 , 2 , new Bishop(false));

        // initializing the black pawns
        for (int b = 0; b < squares[7].length; b ++) {
            squares[6][b] = new Block(6 , b , new Pawn(false));
        }

        // initializing the empty blocks
        for (int i = 2; i < 6; i ++) {
            for (int j = 0; j < 8; j ++){
                squares[i][j] = new Block(i , j , null);
            }
        }



    }




}
