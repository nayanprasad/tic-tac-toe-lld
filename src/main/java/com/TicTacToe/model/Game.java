package com.TicTacToe.model;

import com.TicTacToe.enums.GameStatus;
import com.TicTacToe.strategy.WinningStrategy;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {
    private List<Player> players;
    private Player nextPlayer;
    private Board board;
    private Player winner;
    private GameStatus gameStatus;
    private final WinningStrategy winningStrategy;
    private final List<Move> moves;

    public Game(GameBuilder gameBuilder) {
        this.players = gameBuilder.players;
        this.nextPlayer = this.players.get(0);
        this.winner = null;
        this.board = gameBuilder.board;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategy = gameBuilder.winningStrategy;
        this.moves = new ArrayList<>();
    }

    public void switchPlayer() {
        int currPlayerIndex = players.indexOf(nextPlayer);
        int nextPlayerIndex = (currPlayerIndex + 1) % players.size();
        nextPlayer = players.get(nextPlayerIndex);
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }

    public boolean isGameOver() {
        return this.gameStatus.equals(GameStatus.PLAYER_WON);
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public static class GameBuilder {
        private List<Player> players;
        private Board board;
        private WinningStrategy winningStrategy;

        public GameBuilder() {
            players = new ArrayList<>();
        }

        public GameBuilder board(Board board) {
            this.board = board;
            return this;
        }

        public GameBuilder player(Player player) {
            this.players.add(player);
            return this;
        }

        public GameBuilder winningStrategy(WinningStrategy winningStrategy) {
            this.winningStrategy = winningStrategy;
            return this;
        }

        public Game build() {
            if (players.size() != 2) {
                throw new IllegalStateException("Game requires exactly 2 players");
            }

            if (players.get(0).getPieceType() == players.get(1).getPieceType()) {
                throw new IllegalStateException("Players must have different piece types");
            }

            if (board == null) {
                throw new IllegalStateException("Board cannot be null");
            }

            if (winningStrategy == null) {
                throw new IllegalStateException("Winning strategy cannot be null");
            }

            return new Game(this);
        }

    }
}
