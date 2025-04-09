package com.TicTacToe.enums;

public enum PieceType {
    X("X"),
    O("O"),
    EMPTY("-");

    private String symbol;

    PieceType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
