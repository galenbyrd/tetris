/**
 * Builds a tetris piece of shape S
 * @author Galen Byrd
 */
public class PieceS extends TetrisPiece{
	PieceS(TetrisBoard board){
		super(board);
		
	}
	
	public void setRels(){
		getN2().setRelativeX2(-1);
		getN2().setRelativeY2(0);
		getN3().setRelativeX3(0);
		getN3().setRelativeY3(-1);
		getN4().setRelativeX4(1);
		getN4().setRelativeY4(-1);
	}

}
