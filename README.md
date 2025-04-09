# Tic-Tac-Toe Game Implementation

## Overview
This is a command-line implementation of the classic Tic-Tac-Toe game using Java. The application follows object-oriented design principles, SOLID principles, and appropriate design patterns to ensure maintainability and extensibility.


## Project Structure
```
src/
├── main/
│   └── java/
│       └── com/
│           └── tictactoe/
│               ├── Main.java (Main entry point)
│               ├── model/                    (Domain models)
│               ├── enums/                    (Enumerations)
│               ├── service/                  (Business logic)
│               ├── strategy/                 (Strategy pattern implementations)
│               ├── exception/                (Custom exceptions)
│               └── ui/                       (User interface)
```

## Design Patterns Used
1. **Builder Pattern**: Used in `Game.GameBuilder` for flexible game construction
2. **Strategy Pattern**: Used with `WinningStrategy` to allow different winning conditions
3. **Singleton Pattern**: Used in `GameService` to ensure a single instance manages the game
4. **MVC Pattern**: Separation of models, views, and controllers

## SOLID Principles
1. **Single Responsibility Principle**: Each class has a single, well-defined responsibility
2. **Open/Closed Principle**: Code is open for extension (e.g., through strategies) but closed for modification
3. **Liskov Substitution Principle**: Child classes can be substituted for their parent classes without affecting behavior
4. **Interface Segregation Principle**: Interfaces are client-specific rather than general-purpose
5. **Dependency Inversion Principle**: High-level modules depend on abstractions, not concrete implementations

## How to Run
```bash
# Compile the project
mvn clean package

# Run the application
java -jar target/tictactoe-1.0.jar
```


## Extensibility Features
- The board size can be changed by modifying a single parameter
- Support for different piece types beyond X and O
- Extensible for more than 2 players
- Custom winning strategies can be implemented

