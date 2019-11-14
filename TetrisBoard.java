/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * A Pane in which tetris squares can be displayed.
 * 
 * @author pipWolfe
 */
public class TetrisBoard extends Pane{
    // The size of the side of a tetris square
    public static final int SQUARE_SIZE = 20;
    // The number of squares that fit on the screen in the x and y dimensions
    public static final int X_DIM_SQUARES = 15;
    public static final int Y_DIM_SQUARES = 30; // change this constant if the
    // board is too big for your screen
    private TetrisSquare[][] squares = new TetrisSquare[X_DIM_SQUARES]
    		[Y_DIM_SQUARES];

    /**
     * Sizes the board to hold the specified number of squares in the x and y
     * dimensions.
     */
    public TetrisBoard() {
        this.setPrefHeight(Y_DIM_SQUARES*SQUARE_SIZE);
        this.setPrefWidth(X_DIM_SQUARES*SQUARE_SIZE);
        BackgroundFill myBF = new BackgroundFill(Color.CORNSILK, 
        		new CornerRadii(1),
            new Insets(0.0,0.0,0.0,0.0));// or null for the padding
        setBackground(new Background(myBF));

    }
   
    /**
     * Sets pieces to values in the 2D array
     */
    public void set2DArray(TetrisPiece piece){
    	squares[piece.getN1().getX()][piece.getN1().getY()]=piece.getN1();
    	squares[piece.getN2().getX()][piece.getN2().getY()]=piece.getN2();
    	squares[piece.getN3().getX()][piece.getN3().getY()]=piece.getN3();
    	squares[piece.getN4().getX()][piece.getN4().getY()]=piece.getN4();
    }
    
    /**
     * checks if some index in the 2D array is filled or empty
     */
    public boolean check2DArray (int x, int y){
    	if (y<Y_DIM_SQUARES && squares[x][y]==null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * Removes full rows and sets the rest of the blocks down a row
     */
    public void removeRow(){
    	for (int i=0;i<Y_DIM_SQUARES;i++){
    		if(squares[0][i]!=null && squares[1][i]!=null &&
    				squares[2][i]!=null && squares[3][i]!=null &&
    				squares[4][i]!=null && squares[5][i]!=null &&
    				squares[6][i]!=null && squares[7][i]!=null &&
    				squares[8][i]!=null && squares[9][i]!=null &&
    				squares[10][i]!=null && squares[11][i]!=null &&
    				squares[12][i]!=null && squares[13][i]!=null && 
    				squares[14][i]!=null){
    			for (int p=0;p<X_DIM_SQUARES;p++){
    				squares[p][i].removeFromDrawing();
    				squares[p][i]=null;
    			}
        		for (int k=0;k<X_DIM_SQUARES;k++){
        			for (int j=i;j>-1;j--){
        				if (squares[k][j]!=null){
        					squares[k][j].moveToTetrisLocation(k, j+1);
        					squares[k][j+1]=squares[k][j];
        					squares[k][j]=null;
        				}
        			}
        		}
    		}
    	}
    }
    
}