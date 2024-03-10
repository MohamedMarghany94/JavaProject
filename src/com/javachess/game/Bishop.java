package com.javachess.game;

public class Bishop extends Piece {
	public Bishop(PieceColor color, Position position) {
		super(color, position);
	}

	@Override
	public boolean isValidMove(Position newPosition, Piece[][] board) {
		int rowStep;
		int columnStep;
		int rowDiff=Math.abs(newPosition.getRow()-this.getPosition().getRow());
		int columnDiff=Math.abs(newPosition.getColumn()-this.getPosition().getColumn());
		
		if(newPosition.equals(this.getPosition())) {
			return false;
		}
		
		if(rowDiff!=columnDiff) {
			return false;
		}
		
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
}
