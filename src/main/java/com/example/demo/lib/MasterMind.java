package com.example.demo.lib;
class MasterMind {

    SecretColors secretCode;
    public int attempts = 10;
    public static boolean DEBUG = false;

    MasterMind() {
        int size = InputHandler.getSecretSize();
        secretCode = new SecretColors(size);
        if(DEBUG){
            System.out.println("You are now in Debuging mode, and your secret code is: " + secretCode.toString());
        }
        guessCode();
    }

    public void guessCode() {
        if(checkAttempts()) return;
        Guess guess = InputHandler.getGuess(secretCode.getSize());
        GuessResult result = validateGuess(guess);
        if(result.blackBalls == secretCode.getSize()){
            System.out.println("Congratulations, you won!!!");
            restartGame();
            return;
        }
        System.out.println("black: " + result.blackBalls);
        System.out.println("white: " + result.whiteBalls);
        guessCode();
    }
    private boolean checkAttempts(){
        if(attempts == 0){
            System.out.println("You lost, press enter to restart.");
            InputHandler.scan.nextLine();
            restartGame();
            return true;
        }
        System.out.println(attempts+ " attempts remaining.");
        attempts--;
        return false;
    }
    private GuessResult validateGuess(Guess guess) {
        GuessResult result = new GuessResult(0, 0);
        result.blackBalls = numberOfPositionMatch(guess);
        result.whiteBalls = numberOfColorMatch(guess);
        return result;
    }
    public void restartGame() {
        System.out.println("Go implement the method restart game.");
        new MasterMind();
    }
    public int numberOfPositionMatch(Guess guess) {
        String guessStr = guess.toString();
        String secretStr = secretCode.toString();

        int count = 0;
        for (int i = 0; i < secretStr.length(); i++) {
            if (guessStr.charAt(i) == secretStr.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public int numberOfColorMatch(Guess guess) {
        int[] guessColorsCount = new int[Color.colorsCount];
        int[] secretColorsCount = new int[Color.colorsCount];
        for (int i = 0; i < guess.getSize(); i++) {
            if(guess.getColor(i).id != secretCode.getColor(i).id) {
                guessColorsCount[guess.getColor(i).id]++;
                secretColorsCount[secretCode.getColor(i).id]++;
            }
        }
        int count = 0;
        for (int i = 0; i < guess.getSize(); i++) {
            count += Math.min(guessColorsCount[i], secretColorsCount[i]);
        }
        return count;
    }
}