package com.javachess.game;

public class Rook extends Piece{
	public Rook(PieceColor color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position newPosition, Piece[][] board) {
		
		if(newPosition.equals(this.getPosition())) {
			return false;
		}
		
		//move vertically
		if(newPosition.getColumn()==this.getPosition().getColumn()) {
			//check no vertical steps are blocked
			int startPosition=Math.min(newPosition.getColumn(), this.getPosition().getColumn())+1;
			int endPosition=Math.max(newPosition.getColumn(), this.getPosition().getColumn());
			
			for(int currentRow=startPosition; currentRow<=endPosition; currentRow++) {
				if(board[currentRow][this.getPosition().getRow()]!=null) {
					return false;
				}
			}
		}
		
		//move horizontally
		else if(newPosition.getRow()==this.getPosition().getRow()) {
			//check no horizontal steps are blocked
			int startPosition=Math.min(newPosition.getRow(), this.getPosition().getRow())+1;
			int endPosition=Math.max(newPosition.getRow(), this.getPosition().getRow());
			
			for(int currentColumn=startPosition; currentColumn<=endPosition; currentColumn++) {
				if(board[currentColumn][this.getPosition().getColumn()]!=null) {
					return false;
				}
			}
		}
		else {
			return false;
		}
		
		//Capture
		if(board[newPosition.getRow()][newPosition.getColumn()]!=null) {
			if(board[newPosition.getRow()][newPosition.getColumn()].getColor()==this.getColor()) {
				return false;
			}	
		}
		return true;
	}
	
	
}
