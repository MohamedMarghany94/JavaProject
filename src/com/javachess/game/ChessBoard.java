package com.javachess.game;
public class ChessBoard{
	
	private Piece[][]board;
	
	public ChessBoard() {
		this.board = new Piece[8][8];   //create a 8x8 board
		setupPieces();
	}
	
	private void setupPieces() {
		//place rooks
		board[0][0]=new rook(PieceColor.BLACK, new Position(0,0));
		board[0][7]=new rook(PieceColor.BLACK, new Position(0,7));
		board[7][0]=new rook(PieceColor.WHITE, new Position(7,0));
		board[7][7]=new rook(PieceColor.WHITE, new Position(7,7));
		
		//place knights
		board[0][1]=new knight(PieceColor.BLACK, new Position(0,1));
		board[0][6]=new knight(PieceColor.BLACK, new Position(0,6));
		board[7][1]=new knight(PieceColor.WHITE, new Position(7,1));
		board[7][6]=new knight(PieceColor.WHITE, new Position(7,1));
		
		//place bishops
		board[0][2]=new bishop(PieceColor.BLACK, new Position(0,2));
		board[0][5]=new bishop(PieceColor.BLACK, new Position(0,5));
		board[7][2]=new bishop(PieceColor.WHITE, new Position(7,2));
		board[7][5]=new bishop(PieceColor.WHITE, new Position(7,5));
		
		//place queens
		board[0][3]=new queen(PieceColor.BLACK, new Position(0,3));
		board[7][3]=new queen(PieceColor.WHITE, new Position(7,3));
		
		//place kings
		board[0][4]=new king(PieceColor.BLACK, new Position(0,4));
		board[7][4]=new king(PieceColor.WHITE, new Position(7,4));
		
		//place pawns
		for(int i=0;i<=7;i++) {
			board[1][i]=new pawn(PieceColor.BLACK, new Position(0,i));
			board[7][i]=new pawn(PieceColor.WHITE, new Position(7,i));
		}
	}
}