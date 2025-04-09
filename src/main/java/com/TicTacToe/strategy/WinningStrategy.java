package com.TicTacToe.strategy;

import com.TicTacToe.model.Board;
import com.TicTacToe.model.Move;

public interface WinningStrategy  {
    boolean checkWin(Board board, Move lastMove);
}
