import javafx.scene.paint.Color;

/**
 * Builds a tetris piece
 * @author Galen Byrd
 */
public abstract class TetrisPiece {
	private TetrisSquare n1;
	private TetrisSquare n2;
	private TetrisSquare n3;
	private TetrisSquare n4;
	private TetrisBoard board;
	private TetrisSquare [] pieces = new TetrisSquare [4];
	
	/**
	 * N1 getter
	 */
	public TetrisSquare getN1() {
		return n1;
	}

	/**
	 * N1 setter
	 */
	public void setN1(TetrisSquare n1) {
		this.n1 = n1;
	}

	/**
	 * N2 getter
	 */
	public TetrisSquare getN2() {
		return n2;
	}

	/**
	 * N2 setter
	 */
	public void setN2(TetrisSquare n2) {
		this.n2 = n2;
	}

	/**
	 * N3 getter
	 */
	public TetrisSquare getN3() {
		return n3;
	}

	/**
	 * N3 setter
	 */
	public void setN3(TetrisSquare n3) {
		this.n3 = n3;
	}

	/**
	 * N4 getter
	 */
	public TetrisSquare getN4() {
		return n4;
	}

	/**
	 * N4 setter
	 */
	public void setN4(TetrisSquare n4) {
		this.n4 = n4;
	}

	/**
     * creates a piece and sets the color
     */
	public TetrisPiece(TetrisBoard board){
		this.board = board;
		n1= new TetrisSquare(board);
		n2= new TetrisSquare(board);
		n3= new TetrisSquare(board);
		n4= new TetrisSquare(board);
		
		setRels();
		
		n1.moveToTetrisLocation(TetrisBoard.X_DIM_SQUARES/2, 3);
		n2.moveToTetrisLocation(n1.getX()+n2.getRelativeX2(), n1.getY()+n2.getRelativeY2());
		n3.moveToTetrisLocation(n1.getX()+n3.getRelativeX3(), n1.getY()+n3.getRelativeY3());
		n4.moveToTetrisLocation(n1.getX()+n4.getRelativeX4(), n1.getY()+n4.getRelativeY4());
	
		pieces[0] = n1;
		pieces[1] = n2;
		pieces[2] = n3;
		pieces[3] = n4;
		
		switch(TetrisGame.random){
        case 1:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.BLUE);
        	}
        	break;
        case 2:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.RED);
        	}
        	break;
        case 3:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.PURPLE);
        	}
        	break;
        case 4:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.ORANGE);
        	}
        	break;
        case 5:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.DARKGREEN);
        	}
        	break;
        case 6:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.DARKGREY);
        	}
        	break;
        case 7:
        	for (int i=0;i<4;i++){
        		pieces[i].setColor(Color.HOTPINK);
        	}
        	break;
        }
	}
	
	/**
     * Sets relatives
     */
	public abstract void setRels();

	/**
     * drops the piece to the lowest position possible
     */
	public void drop(){
		while (moveDown()==true){
			
		}
	}
	
	/**
     * moves piece down by one
     */
	public boolean moveDown(){
		if (n1.getY()+1<TetrisBoard.Y_DIM_SQUARES && 
				n2.getY()+1<TetrisBoard.Y_DIM_SQUARES && 
				n3.getY()+1<TetrisBoard.Y_DIM_SQUARES &&
				n4.getY()+1<TetrisBoard.Y_DIM_SQUARES &&
				board.check2DArray(n1.getX(), n1.getY()+1) &&
				board.check2DArray(n2.getX(), n2.getY()+1) &&
				board.check2DArray(n3.getX(), n3.getY()+1) &&
				board.check2DArray(n4.getX(), n4.getY()+1)){
			for (int i=0;i<4;i++){
        		pieces[i].moveToTetrisLocation(pieces[i].getX(), pieces[i].getY()+1);
        	}
			return true;
		}else{
			return false;
		}
	}
	
	
	/**
     * Moves piece left by one
     */
	public void moveLeft(){
		if (n1.getX()-1>-1 && n2.getX()-1>-1 && 
				n3.getX()-1>-1 && n4.getX()-1>-1 &&
				board.check2DArray(n1.getX()-1, n1.getY()) &&
				board.check2DArray(n2.getX()-1, n2.getY()) &&
				board.check2DArray(n3.getX()-1, n3.getY()) &&
				board.check2DArray(n4.getX()-1, n4.getY())){
			for (int i=0;i<4;i++){
        		pieces[i].moveToTetrisLocation(pieces[i].getX()-1, pieces[i].getY());
        	}
		}
	}
	
	/**
     * Moves piece right by one
     */
	public void moveRight(){
		if (n1.getX()+1<TetrisBoard.X_DIM_SQUARES &&
				n2.getX()+1<TetrisBoard.X_DIM_SQUARES &&
				n3.getX()+1<TetrisBoard.X_DIM_SQUARES &&
				n4.getX()+1<TetrisBoard.X_DIM_SQUARES &&
				board.check2DArray(n1.getX()+1,n1.getY()) &&
				board.check2DArray(n2.getX()+1, n2.getY()) &&
				board.check2DArray(n3.getX()+1, n3.getY()) &&
				board.check2DArray(n4.getX()+1, n4.getY())){
			for (int i=0;i<4;i++){
        		pieces[i].moveToTetrisLocation(pieces[i].getX()+1, pieces[i].getY());
        	}
		}
	}
	
	/**
     * Rotates piece left
     */
	public void rotateLeft(){
		int newRelx2 = n2.getRelativeY2();
		int newRelx3 = n3.getRelativeY3();
		int newRelx4 = n4.getRelativeY4();
		int newRely2 = -n2.getRelativeX2();
		int newRely3 = -n3.getRelativeX3();
		int newRely4 = -n4.getRelativeX4();
		
		if(-1<n1.getX()+newRelx2 &&
				-1<n1.getX()+newRelx3 &&
				-1<n1.getX()+newRelx4 &&
				TetrisBoard.X_DIM_SQUARES>n1.getX()+newRelx2 &&
				TetrisBoard.X_DIM_SQUARES>n1.getX()+newRelx3 &&
				TetrisBoard.X_DIM_SQUARES>n1.getX()+newRelx4 &&
				board.check2DArray(n1.getX(),n1.getY()) &&
				board.check2DArray(n1.getX()+newRelx2,n1.getY()+newRely2) &&
				board.check2DArray(n1.getX()+newRelx3,n1.getY()+newRely3) &&
				board.check2DArray(n1.getX()+newRelx4,n1.getY()+newRely4)){
			n2.setRelativeX2(newRelx2);
			n3.setRelativeX3(newRelx3);
			n4.setRelativeX4(newRelx4);
			
			n2.setRelativeY2(newRely2);
			n3.setRelativeY3(newRely3);
			n4.setRelativeY4(newRely4);
			
			n2.moveToTetrisLocation(n1.getX()+n2.getRelativeX2(), n1.getY()+n2.getRelativeY2());
			n3.moveToTetrisLocation(n1.getX()+n3.getRelativeX3(), n1.getY()+n3.getRelativeY3());
			n4.moveToTetrisLocation(n1.getX()+n4.getRelativeX4(), n1.getY()+n4.getRelativeY4());
		}
	}
	
	/**
     * Rotates piece right
     */
	public void rotateRight(){
		int newRelx2 = -n2.getRelativeY2();
		int newRelx3 = -n3.getRelativeY3();
		int newRelx4 = -n4.getRelativeY4();
		int newRely2 = n2.getRelativeX2();
		int newRely3 = n3.getRelativeX3();
		int newRely4 = n4.getRelativeX4();
		
		if(-1<n1.getX()+newRelx2 &&
				-1<n1.getX()+newRelx3 &&
				-1<n1.getX()+newRelx4 &&
				TetrisBoard.X_DIM_SQUARES>n1.getX()+newRelx2 &&
				TetrisBoard.X_DIM_SQUARES>n1.getX()+newRelx3 &&
				TetrisBoard.X_DIM_SQUARES>n1.getX()+newRelx4 &&
				board.check2DArray(n1.getX(),n1.getY()) &&
				board.check2DArray(n1.getX()+newRelx2,n1.getY()+newRely2) &&
				board.check2DArray(n1.getX()+newRelx3,n1.getY()+newRely3) &&
				board.check2DArray(n1.getX()+newRelx4,n1.getY()+newRely4)){
			n2.setRelativeX2(newRelx2);
			n3.setRelativeX3(newRelx3);
			n4.setRelativeX4(newRelx4);
			
			n2.setRelativeY2(newRely2);
			n3.setRelativeY3(newRely3);
			n4.setRelativeY4(newRely4);
			
			n2.moveToTetrisLocation(n1.getX()+n2.getRelativeX2(), n1.getY()+n2.getRelativeY2());
			n3.moveToTetrisLocation(n1.getX()+n3.getRelativeX3(), n1.getY()+n3.getRelativeY3());
			n4.moveToTetrisLocation(n1.getX()+n4.getRelativeX4(), n1.getY()+n4.getRelativeY4());	
		}
	}
	
}
