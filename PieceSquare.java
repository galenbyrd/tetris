/**
 * Builds a tetris piece of shape square
 * @author Galen Byrd
 */
public class PieceSquare extends TetrisPiece{
	PieceSquare(TetrisBoard board){
		super(board);
		
	}
	
	public void setRels(){
		getN2().setRelativeX2(0);
		getN2().setRelativeY2(-1);
		getN3().setRelativeX3(-1);
		getN3().setRelativeY3(0);
		getN4().setRelativeX4(-1);
		getN4().setRelativeY4(-1);
	}
	
	public void rotateLeft(){
		
	}
	
	public void rotateRight(){
		
	}
}
