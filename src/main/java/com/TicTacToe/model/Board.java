package com.TicTacToe.model;

import com.TicTacToe.enums.PieceType;
import lombok.Data;

@Data
public class Board {
    private final int SIZE;
    private Cell[][] cells;

    public Board(int size) {
        this.SIZE = size;
        cells = new Cell[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell(i, j, new Piece(PieceType.EMPTY));
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public PieceType getCellPieceType(int row, int col) {
        return getCell(row, col).getPiece().getPieceType();
    }

    public boolean isEmptyCell(Cell cell) {
        return cell.isEmptyCell();
    }

    public boolean isEmptyCell(int row, int col) {
        Cell cell = cells[row][col];
        return isEmptyCell(cell);
    }

    public boolean isValidCell(int row, int col) {
        return row >= 0 && col >= 0 && row < SIZE && col < SIZE;
    }


    public void printBoard() {
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                Cell cell = cells[i][j];
                System.out.print(cell.getDisplay() + " ");
            }
            System.out.println();
        }
    }

    public boolean applyMove(Move move) {
        int row = move.getRow();
        int col = move.getCol();
        if(!isEmptyCell(row, col)) {
            throw  new IllegalArgumentException("Invalid move, cell is not empty");
        }

        Piece piece = new Piece(move.getPlayer().getPieceType());
        Cell cell = new Cell(row, col, piece);
        cells[row][col] = cell;

        return true;
    }

    public boolean isFull() {
        int emptyCells = 0;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0;  j < SIZE; j++) {
                if(isEmptyCell(i, j)) {
                    emptyCells++;
                }
            }
        }

        return emptyCells == 0;
    }
}
