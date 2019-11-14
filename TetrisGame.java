/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.paint.Color;

/**
 * This should be implemented to include your game control.
 * @author pipWolfe
 */
public class TetrisGame {
    private final Tetris tetrisApp;
    TetrisPiece piece;
    static int random;
    private final TetrisBoard board;
    boolean cont=true;
    
    /**
     * Initialize the game. Remove the example code and replace with code
     * that creates a random piece.
     * @param tetrisApp A reference to the application (use to set messages).
     * @param board A reference to the board on which Squares are drawn
     */
    public TetrisGame(Tetris tetrisApp, TetrisBoard board) {
        this.tetrisApp = tetrisApp;
        this.board = board;
        // You can use this to show the score, etc.
        tetrisApp.setMessage("Game has started!");
        createPiece();
        
        
    }

    /**
     * creates a random piece
     */
    void createPiece(){
    	random = (int)(Math.random()*7+1);
    	switch(random){
        case 1:
        	piece = new PieceT(board);
        	break;
        case 2:
        	piece = new PieceLine(board);
        	break;
        case 3:
        	piece = new PieceL(board);
        	break;
        case 4:
        	piece = new PieceZ(board);
        	break;
        case 5:
        	piece = new PieceS(board);
        	break;
        case 6:
        	piece = new PieceSquare(board);
        	break;
        case 7:
        	piece = new PieceBackwardsL(board);
        	break;
    	}
    }
    
    
    
    /**
     * Animate the game, by moving the current tetris piece down.
     */
    void update() {
    	//System.out.println("updating");
    	if (piece.moveDown()==false  && cont==true){
    		board.set2DArray(piece);
    		board.removeRow();
    		createPiece();
    	}
    	for (int i=0;i<TetrisBoard.X_DIM_SQUARES;i++){
    		if (board.check2DArray(i, 3)==false){
    			cont=false;
    		}
    	}
    	
    }
    
    /**
     * Move the current tetris piece left.
     */
    void left() {
    	piece.moveLeft();
        tetrisApp.setMessage("left key was pressed!");
        System.out.println("left key was pressed!");
    }

    /**
     * Move the current tetris piece right.
     */
    void right() {
    	piece.moveRight();
        tetrisApp.setMessage("right key was pressed!");
        System.out.println("right key was pressed!");
    }

    /**
     * Drop the current tetris piece.
     */
    void drop() {
    	piece.drop();
        tetrisApp.setMessage("drop key was pressed!");
        System.out.println("drop key was pressed!");
    }

    /**
     * Rotate the current piece counter-clockwise.
     */
    void rotateLeft() {
    	piece.rotateLeft();
        tetrisApp.setMessage("rotate left key was pressed!");
        System.out.println("rotate left key was pressed!");
    }
    
    /**
     * Rotate the current piece clockwise.
     */
    void rotateRight() {
    	piece.rotateRight();
        tetrisApp.setMessage("rotate right key was pressed!");
        System.out.println("rotate right key was pressed!");
    }
    
}
