package com.javachess.game;

public class Pawn extends Piece {
	public Pawn(PieceColor color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position newPosition, Piece[][] board) {
		int forwardDirection;
		int columnDiff;
		int rowDiff;		
		
		if(newPosition.equals(this.getPosition())) {
			return false;
		}
		//determining the forward direction based on the color
		if(this.getColor()==PieceColor.WHITE)
		{
			forwardDirection=-1;
		}
		else {
			forwardDirection=1;
		}
		
		columnDiff=newPosition.getColumn()-this.getPosition().getColumn();
		rowDiff=(newPosition.getRow()-this.getPosition().getRow())*forwardDirection;
		
		//move forward
		if(board[newPosition.getRow()][newPosition.getColumn()]==null && columnDiff==0 && rowDiff==1) {
			return true;
		}
		
		//initial steps move
		if((this.getColor()==PieceColor.WHITE && this.getPosition().getRow()==6) || (this.getColor()==PieceColor.BLACK && this.getPosition().getRow()==1)) {
			if(columnDiff==0 && rowDiff==2 && board[newPosition.getRow()][newPosition.getColumn()]==null) {
				//checking the middle step is not blocked
				int middleStep=this.getPosition().getRow()+forwardDirection;
				if(board[middleStep][this.getPosition().getColumn()]==null) {
					return true;
				}
			}
		}
		
		//diagonal capture
		if(Math.abs(columnDiff)==1 && rowDiff==1 && board[newPosition.getRow()][newPosition.getColumn()]!=null) {
			if(this.getColor()!=board[newPosition.getRow()][newPosition.getColumn()].getColor()) {
				return true;
			}
		}
		
		return false;
	}
}
