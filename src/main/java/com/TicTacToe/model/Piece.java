package com.TicTacToe.model;

import com.TicTacToe.enums.PieceType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Piece {
    private PieceType pieceType;

    @Override
    public String toString() {
        return pieceType.getSymbol();
    }
}
