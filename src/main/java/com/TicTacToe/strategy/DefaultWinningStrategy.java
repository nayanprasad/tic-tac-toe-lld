package com.TicTacToe.strategy;

import com.TicTacToe.enums.PieceType;
import com.TicTacToe.model.Board;
import com.TicTacToe.model.Move;

public class DefaultWinningStrategy implements WinningStrategy{

    public boolean checkWin(Board board, Move lastMove) {
        int row = lastMove.getRow();;
        int col = lastMove.getCol();
        PieceType pieceType = lastMove.getPlayer().getPieceType();

        return checkRow(board, row, pieceType) || checkCol(board, col, pieceType) || checkDiagonal(board, pieceType);
    }

    private boolean checkRow(Board board, int row, PieceType pieceType) {
        for(int col = 0; col < board.getSIZE(); col++) {
            if(!board.getCellPieceType(row, col).equals(pieceType)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(Board board, int col, PieceType pieceType) {
        for(int row = 0; row < board.getSIZE(); row++) {
            if(!board.getCellPieceType(row, col).equals(pieceType)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(Board board, PieceType pieceType) {
        for(int i = 0; i < board.getSIZE(); i++) {
            if(!board.getCellPieceType(i, i).equals(pieceType)) {
                return false;
            }
        }

        for(int i = 0; i < board.getSIZE(); i++) {
            if(!board.getCellPieceType(i, board.getSIZE() - 1 - i).equals(pieceType)) {
                return false;
            }
        }

        return true;
    }
}
