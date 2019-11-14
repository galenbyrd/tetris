/**
 * Builds a tetris piece of shape line
 * @author Galen Byrd
 */
public class PieceLine extends TetrisPiece{
	PieceLine(TetrisBoard board){
		super(board);
		
	}
	
	public void setRels(){
		getN2().setRelativeX2(0);
		getN2().setRelativeY2(-1);
		getN3().setRelativeX3(0);
		getN3().setRelativeY3(1);
		getN4().setRelativeX4(0);
		getN4().setRelativeY4(2);
	}

}
