package com.javachess.game;

public class Queen extends Piece{
	public Queen(PieceColor color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position newPosition, Piece[][] board) {
		int rowDiff=newPosition.getRow()-this.getPosition().getRow();
		int columnDiff=newPosition.getColumn()-this.getPosition().getColumn();
		boolean diagonal=false;
		boolean straight=false;
		
		if(newPosition.equals(this.getPosition())) {
			return false;
		}
		
		if(Math.abs(rowDiff)==Math.abs(columnDiff)) {
			diagonal=true;
		}
		else {
			if(rowDiff==0||columnDiff==0) {
				straight=true;
			}
			else {
				return false;
			}
		}
		
		if (diagonal==true) {
			int rowStep;
			int columnStep;
			if(newPosition.getRow()>this.getPosition().getRow()) {
				rowStep=1;
			}
			else {
				rowStep=-1;
			}
			
			if(newPosition.getColumn()>this.getPosition().getColumn()) {
				columnStep=1;
			}
			else {
				columnStep=-1;
			}
			
			for(int i=1;i<=rowDiff;i++) {
				if(board[(this.getPosition().getRow()+i)*rowStep][(this.getPosition().getColumn()+i)*columnStep]!=null) {
					return false;
				}
			}
		}
		if (straight==true) {

			//check no vertical steps are blocked
			if(newPosition.getColumn()==this.getPosition().getColumn()) {
				int startPosition=Math.min(newPosition.getColumn(), this.getPosition().getColumn())+1;
				int endPosition=Math.max(newPosition.getColumn(), this.getPosition().getColumn());
				
				for(int currentRow=startPosition; currentRow<=endPosition; currentRow++) {
					if(board[currentRow][this.getPosition().getRow()]!=null) {
						return false;
					}
				}
			}
			
			if(newPosition.getRow()==this.getPosition().getRow()) {
				//check no horizontal steps are blocked
				int startPosition=Math.min(newPosition.getRow(), this.getPosition().getRow())+1;
				int endPosition=Math.max(newPosition.getRow(), this.getPosition().getRow());
				
				for(int currentColumn=startPosition; currentColumn<=endPosition; currentColumn++) {
					if(board[currentColumn][this.getPosition().getColumn()]!=null) {
						return false;
					}
				}
			}
		}
		
		if(board[newPosition.getRow()][newPosition.getColumn()]!=null) {
			if(board[newPosition.getRow()][newPosition.getColumn()].getColor()==this.getColor()) {
				return false;
			}
		}
		return true;
	}
	

}
