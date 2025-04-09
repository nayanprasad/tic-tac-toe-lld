package com.TicTacToe.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Move {
    private final Player player;
    private final int row;
    private final int col;
}
