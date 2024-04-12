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
		
	public abstract boolean isValidMove(Position newPosition,Piece[][]board);
}
