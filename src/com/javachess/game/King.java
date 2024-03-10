package com.javachess.game;

public class King extends Piece{
	public King(PieceColor color, Position position) {
		super(color, position);
	}
	
	@Override
	public boolean isValidMove(Position newPosition, Piece[][] board) {
		int rowDiff=newPosition.getRow()-this.getPosition().getRow();
		int columnDiff=newPosition.getColumn()-this.getPosition().getColumn();
		boolean diagonal=false;
		boolean straight=false;
		
		if(Math.abs(rowDiff)>1||Math.abs(columnDiff)>1)
		{
			return false;
		}
		
		if(newPosition.equals(this.getPosition())) {
			return false;
		}
		
		if(board[newPosition.getRow()][newPosition.getColumn()]!=null) {
			if(board[newPosition.getRow()][newPosition.getColumn()].getColor()==this.getColor()) {
				return false;
			}
		}s
		return true;
}
