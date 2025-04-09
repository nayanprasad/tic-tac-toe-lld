package com.TicTacToe.model;

import com.TicTacToe.enums.PieceType;
import lombok.Data;

@Data
public class Cell {
    private int row;
    private int col;
    private Piece piece;

    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public String getDisplay() {
        return piece.toString();
    }

    public boolean isEmptyCell() {
        return piece.getPieceType().equals(PieceType.EMPTY);
    }
}
