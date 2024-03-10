package com.javachess.game;

public class Knight extends Piece{
	public Knight(PieceColor color, Position position) {
		super(color, position);
	}
	
	@Override
	public boolean isValidMove(Position newPosition, Piece[][] board) {
		
		if(newPosition.equals(this.getPosition())) {
			return false;
		}
		int rowDiff=newPosition.getRow()-this.getPosition().getRow();
		int columnDiff=newPosition.getColumn()-this.getPosition().getColumn();
		
		if((Math.abs(rowDiff)==2&&Math.abs(columnDiff)==1)||(Math.abs(rowDiff)==1&&Math.abs(columnDiff)==2)) {
			if(board[newPosition.getRow()][newPosition.getColumn()]!=null) {
				if(board[newPosition.getRow()][newPosition.getColumn()].getColor()==this.getColor()) {
					return false;
				}
				else {
					return true;
				}
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
}
