# MasterMind Game

MasterMind is a code-breaking game implemented in Java using JavaFX for the graphical user interface and Maven as the build tool. The computer generates a secret sequence of colors and the player must guess the correct sequence within a limited number of attempts.

## Project Description

- The game logic is implemented in the [`com.example.demo.lib.MasterMind`](src/main/java/com/example/demo/lib/MasterMind.java) class. It uses helper classes such as [`com.example.demo.lib.Guess`](src/main/java/com/example/demo/lib/Guess.java), [`com.example.demo.lib.GuessResult`](src/main/java/com/example/demo/lib/GuessResult.java), and [`com.example.demo.lib.SecretColors`](src/main/java/com/example/demo/lib/SecretColors.java).
- The user interface is built with JavaFX and defined in the FXML file [`hello-view.fxml`](src/main/resources/com/example/demo/hello-view.fxml). Its behavior is handled by [`com.example.demo.GUIController`](src/main/java/com/example/demo/GUIController.java).
- The application entry point is in [`GUIApplication.java`](src/main/java/com/example/demo/GUIApplication.java).

## Prerequisites

- **JDK 23** (or higher) – The project is set to compile with Java 23.
- **Maven** – Use the Maven wrapper provided in the project.

## Setup and Run

1. **Clone the Repository**

   Clone the repository to your local machine:
   ```sh
   git clone https://github.com/Abbas49/Master-mind.git
   ```

2. **Navigate to the Project Directory**

   ```sh
   cd MasterMind
   ```

3. **Build the Project**

   Use the Maven wrapper to build the project:
   ```sh
   ./mvnw clean install    # On Unix-based systems
   mvnw.cmd clean install   # On Windows
   ```

4. **Run the Application**

   To launch the game using the JavaFX Maven plugin, run:
   ```sh
   ./mvnw javafx:run       # On Unix-based systems
   mvnw.cmd javafx:run      # On Windows
   ```

## Project Structure

```
MasterMind/
├── .idea/                # IDE configuration files
├── .mvn/                 # Maven wrapper configuration
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       ├── GUIApplication.java
│   │   │       ├── GUIController.java
│   │   │       └── lib/
│   │   │            ├── Color.java
│   │   │            ├── Guess.java
│   │   │            ├── GuessResult.java
│   │   │            ├── MasterMind.java
│   │   │            └── SecretColors.java
│   │   └── resources/
│   │       └── com/example/demo/
│   │            └── hello-view.fxml
│   └── test/              # Test sources (if any)
├── pom.xml               # Maven project file
└── README.md             # This file
```

## Additional Information

- The game starts with **10 attempts**. Each guess is evaluated for correct colors in the correct positions (black balls) and correct colors in the wrong positions (white balls).
- The UI is interactive; select the desired colors, submit your guess, and follow on-screen messages to win or restart the game.

Enjoy playing MasterMind!
