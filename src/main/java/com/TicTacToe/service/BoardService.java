package com.TicTacToe.service;

import com.TicTacToe.exceptions.InvalidMoveException;
import com.TicTacToe.model.Board;
import com.TicTacToe.model.Move;

public class BoardService {
    private static BoardService instance = null;

    public static BoardService getInstance() {
        if(instance == null) {
            instance = new BoardService();
        }
        return instance;
    }

    public boolean validateMove(Board board, Move move) throws InvalidMoveException {
        int row = move.getRow();
        int col = move.getCol();

        if(!board.isValidCell(row, col)) {
            throw new InvalidMoveException("Cell position is outside the board boundaries");
        }

        if(!board.isEmptyCell(row, col)) {
            throw new InvalidMoveException("Cell is already occupied");
        }

        return true;
    }

    public boolean applyMove(Board board, Move move) {
        return board.applyMove(move);
    }

    public void printBoard(Board board) {
        board.printBoard();
    }

    public boolean isBoardFull(Board board) {
        return board.isFull();
    }
}
