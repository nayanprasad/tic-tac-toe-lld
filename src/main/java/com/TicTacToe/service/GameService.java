package com.TicTacToe.service;

import com.TicTacToe.enums.GameStatus;
import com.TicTacToe.enums.PieceType;
import com.TicTacToe.exceptions.InvalidMoveException;
import com.TicTacToe.model.Board;
import com.TicTacToe.model.Game;
import com.TicTacToe.model.Move;
import com.TicTacToe.model.Player;
import com.TicTacToe.strategy.DefaultWinningStrategy;
import com.TicTacToe.strategy.WinningStrategy;

import java.util.UUID;


public class GameService {
    private static GameService instance = null;
    private final BoardService boardService;

    public GameService() {
        this.boardService = BoardService.getInstance();
    }

    public static GameService getInstance() {
        if(instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public Game createGame(String p1, String p2) {
        Player player1 = new Player(UUID.randomUUID(), p1, PieceType.X);
        Player player2 = new Player(UUID.randomUUID(), p2, PieceType.O);

        Board board = new Board(3);

        WinningStrategy winningStrategy = new DefaultWinningStrategy();

        return new Game.GameBuilder()
                .player(player1)
                .player(player2)
                .board(board)
                .winningStrategy(winningStrategy)
                .build();
    }

    public boolean play(Game game, int row, int col) throws InvalidMoveException {
        try{
            Move move = new Move(game.getNextPlayer(), row, col);

            boardService.validateMove(game.getBoard(), move);

            boardService.applyMove(game.getBoard(), move);

            game.addMove(move);

            if(game.getWinningStrategy().checkWin(game.getBoard(), move)) {
                game.setGameStatus(GameStatus.PLAYER_WON);
                game.setWinner(game.getNextPlayer());
                return true;
            }

            if(boardService.isBoardFull(game.getBoard())) {
                game.setGameStatus(GameStatus.DRAW);
                return true;
            }

            game.switchPlayer();
            return true;

        }catch (InvalidMoveException e) {
            System.out.println("Invalid Move");
            return false;
        }
    }

    public String getNextPlayer(Game game) {
        return game.getNextPlayer().getName();
    }

    public boolean isGameOver(Game game) {
        return game.isGameOver();
    }

    public String getGameResult(Game game) {
        if (game.getGameStatus() == GameStatus.PLAYER_WON) {
            return game.getWinner().getName() + " won the game";
        } else if (game.getGameStatus() == GameStatus.DRAW) {
            return "Game Over";
        } else {
            return "Game is still in progress";
        }
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

}
