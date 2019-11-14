/**
 * Builds a tetris piece of shape T
 * @author Galen Byrd
 */
public class PieceT extends TetrisPiece{
	PieceT(TetrisBoard board){
		super(board);
		
	}
	
	public void setRels(){
		getN2().setRelativeX2(-1);
		getN2().setRelativeY2(0);
		getN3().setRelativeX3(1);
		getN3().setRelativeY3(0);
		getN4().setRelativeX4(0);
		getN4().setRelativeY4(1);
	}

}
