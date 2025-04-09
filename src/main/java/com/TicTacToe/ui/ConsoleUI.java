package com.TicTacToe.ui;

import com.TicTacToe.exceptions.InvalidMoveException;
import com.TicTacToe.model.Game;
import com.TicTacToe.service.GameService;

import java.util.Scanner;

public class ConsoleUI {
    private Scanner scanner;
    private final GameService gameService;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        gameService = GameService.getInstance();
    }


    public void start() {
        System.out.print("Enter player name (X): ");
        String player1Name = scanner.nextLine().trim();

        System.out.print("Enter player name (O): ");
        String player2Name = scanner.nextLine().trim();

        Game game = gameService.createGame(player1Name, player2Name);

        gameService.printBoard(game);

        while (!gameService.isGameOver(game)) {

            System.out.print(gameService.getNextPlayer(game) + " :");

            String inputLine = scanner.nextLine();

            if (inputLine.equals("exit")) break;

            String[] pos = inputLine.split(" ", 2);
            int row = Integer.parseInt(pos[0]);
            int col = Integer.parseInt(pos[1]);

            try {
                boolean validMove = gameService.play(game, row, col);

                if (validMove) {
                    gameService.printBoard(game);

                    if (gameService.isGameOver(game)) {
                        System.out.println(gameService.getGameResult(game));
                    }
                }
            } catch (InvalidMoveException e) {
                System.out.println("Invalid Move");
            }
        }


        scanner.close();
    }
}
