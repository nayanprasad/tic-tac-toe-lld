package com.TicTacToe.model;

import com.TicTacToe.enums.PieceType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Player {
    private UUID id;
    private String name;
    private PieceType pieceType;
}
