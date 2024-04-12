package com.javachess.game;

import javax.management.RuntimeErrorException;

public class ChessGame{
	private ChessBoard board;
	private boolean whiteTurn=true;
	
	public ChessGame() {
		this.board=new ChessBoard();
	}
	
	public boolean makeMove(Position Start, Position End) {
		Piece movingPiece = board.getPiece(Start.getRow(),Start.getColumn());
		if(movingPiece == null || movingPiece.getColor() != (whiteTurn?PieceColor.WHITE:PieceColor.BLACK)) {
			return false;
		}
		
		if(movingPiece.isValidMove(End, board.getBoard())) {
			board.movePiece(Start, End);
			whiteTurn=!whiteTurn;
			return true;
		}
		return false;
	}
	
	public boolean isInCheck(PieceColor kingColor) {
		Position kingPosition=findKingPosition(kingColor);
		for(int row=0;row<board.getBoard().length;row++) {
			for(int column=0;column<board.getBoard()[row].length;column++) {
				Piece piece=board.getPiece(row, column);
				if(piece!=null&&piece.getColor()!=kingColor) {
					if(piece.isValidMove(kingPosition, board.getBoard())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private Position findKingPosition(PieceColor kingcolor) {
		for(int row=0; row<board.getBoard().length; row++) {
			for(int column=0; column<board.getBoard()[row].length;column++) {
				Piece piece=board.getPiece(row, column);
				if(piece instanceof King && piece.getColor()==kingcolor) {
					return piece.getPosition();
				}
			}
		}
		throw new RuntimeException("King was not found, which should never happen");
	}
	
	private boolean isCheckmate(PieceColor kingColor) {
		if(!isInCheck(kingColor)) {
			return false;
		}
			Position kingPosition=findKingPosition(kingColor);
			King king=(King)board.getPiece(kingPosition.getRow(), kingPosition.getColumn());
			for(int rowOffset=-1; rowOffset<=1;rowOffset++) {
				for(int columnOffset=-1;columnOffset<=1;columnOffset++) {
					if(rowOffset==0&&columnOffset==0) {
						continue;
					}
					Position newPosition=new Position(kingPosition.getRow()+rowOffset, kingPosition.getColumn()+columnOffset);
					if(isPositionOnBoard(newPosition)&& king.isValidMove(newPosition,board.getBoard()) && !wouldBeInCheckAfterMove(kingColor, kingPosition, newPosition)) {
						return false;
					}
				}
			}
		return true;
	}
	
	private boolean isPositionOnBoard(Position position) {
		return position.getRow()>=0 && position.getRow()<board.getBoard().length && position.getColumn()>=0 && position.getColumn()<board.getBoard().length;
	}
	
	private boolean wouldBeInCheckAfterMove(PieceColor kingColor, Position kingPosition, Position newPosition) {
		Piece temp = board.getPiece(newPosition.getRow(), newPosition.getColumn());
		board.setPiece(newPosition.getRow(), newPosition.getColumn(), board.getPiece(kingPosition.getRow(), kingPosition.getColumn()));
		board.setPiece(kingPosition.getRow(), kingPosition.getColumn(), null);
		
		boolean isInCheck=isInCheck(kingColor);
		
		board.setPiece(kingPosition.getRow(), kingPosition.getColumn(), board.getPiece(newPosition.getRow(), newPosition.getColumn()));
		board.setPiece(newPosition.getRow(), newPosition.getColumn(), temp);
		
		return isInCheck;
	}
}

