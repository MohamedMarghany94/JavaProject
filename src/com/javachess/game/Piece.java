package com.javachess.game;

public abstract class Piece {
	protected Position piecePosition;
	protected PieceColor color;
	
	public Piece(PieceColor color, Position piecePosition) {
		this.color=color;
		this.piecePosition=piecePosition;
	}
	
	public PieceColor getColor() {
		return this.color;
	}
	
	public void setColor(PieceColor color) {
		this.color=color;
	}
	
	public Position getPosition() {
		return this.piecePosition;
	}
	
	public void setPosition(Position piecePosition) {
		this.piecePosition = piecePosition;
	}
	
	public void movePiece(Position start, Position end) {
		//check if the piece is in the start position and the move is vaild
		if(board[start.getRow()][start.getColumn()]!=null && board[start.getRow()][start.getColumn()].isVaildMove()) {
			
			//move the piece to the end position
			board[end.getRow()][end.getColumn()]=board[start.getRow()][start.getColumn()];
			
			//update the position
			board[end.getRow()][end.getColumn()].setPosition(end);
			
			//clear the start position
			board[start.getRow()][start.getColumn()]=null;
		}
	}
	
	public abstract boolean isValidMove(Position newPosition,Piece[][]board);
}
