import java.util.*;

// while validating input if the input is invalid, tell the user that, and ask him to enter the inputs again
class InputHandler {
    public static Scanner scan = new Scanner(System.in);

    // scan and return the secretCode size
    public static int getSecretSize() {
        System.out.println("Enter the Difficulty level Easy=e,Medium=m,Hard=h,Custom=c");
        char D=scan.next().charAt(0);
        System.out.println("easy=3 , medium=4 , hard=5");
        if(D=='e') {
            return 3;
        }else if(D=='m') {
            return 4;
        }else if(D=='h') {
            return 5;
        }
        else if(D=='c') {
            System.out.println("Enter number of colors greater than 5");
            int size=scan.nextInt();
            if(size==3){
                System.out.println("are you idiot or Stupid return from the First of the program and select easy");
                   return getSecretSize();
            }else if(size==4){
                System.out.println("are you idiot or Stupid return from First of the program and select medium");
                return getSecretSize();
            }else if(size==5){
                System.out.println("are you idiot or Stupid return from First of the program and select hard");
                return getSecretSize();
            }else if (size<3){
                System.out.println("this is unvaid number");
                return getSecretSize();
            } else{
                return size;
            }
        }


      return getSecretSize();
    }

    private static StringBuilder getValidGuessInput(int size) {
        System.out.println("Enter Guess: ");
        String str = scan.nextLine();
        str = str.toLowerCase();
        StringBuilder newStr = new StringBuilder(); // النص الجديد

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)!=' '){
                 newStr.append(str.charAt(i));
            }
        }
        if (newStr.length() != size) {
            System.out.println("You should input " + size + " characters, try again.");
            return getValidGuessInput(size);
        }
        for (int i = 0; i < size; i++) {
            char c = newStr.charAt(i);
            if (c != 'r' && c != 'g' && c != 'y' && c != 'b' && c != 'o' && c != 'p') {
                System.out.println("The character " + c + " is not valid, try again.");
                return getValidGuessInput(size);
            }
        }
        return newStr;
    }
    public static Guess getGuess(int size) {
        Guess guess = new Guess(size);
        StringBuilder str = getValidGuessInput(size);
        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            guess.setColor(i,c);
        }
        return guess;
    }
}

class OutputHandler {

}

class GuessResult {
    public int blackBalls = 0;
    public int whiteBalls = 0;

    GuessResult(int blackBalls, int whiteBalls) {
        this.blackBalls = blackBalls;
        this.whiteBalls = whiteBalls;
    }
}

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

class Color {
    public static Color red, green, yellow, blue, orange, purple;
    public static int colorsCount = 6;
    public static char[] gameColors = {'r', 'g', 'y', 'b', 'o', 'p'};
    public int id;
    public String name;
    public char symbol;

    Color(int id, String name) {
        this.id = id;
        this.name = name;
        this.symbol = gameColors[id];
    }
    public String toString() {
        return name;
    }

    // color
    static {
        red = new Color(0, "Red");
        green = new Color(1, "Green");
        yellow = new Color(2, "Yellow");
        blue = new Color(3, "Blue");
        orange = new Color(4, "orange");
        purple = new Color(5, "Purple");
    }
}

class Guess {
    protected Color[] colors;
    protected static final Color[] COLORS = {
            Color.red, Color.green, Color.yellow, Color.blue, Color.orange, Color.purple
    };

    public Guess(int size) {
        colors = new Color[size];
    }

    protected Color charToColor(char c) {
        switch (c) {
            case 'r':
                return Color.red;
            case 'g':
                return Color.green;
            case 'b':
                return Color.blue;
            case 'o':
                return Color.orange;
            case 'p':
                return Color.purple;
            case 'y':
                return Color.yellow;

            default:
                throw new IllegalArgumentException("invalid char" + c);
        }
    }

    protected boolean validateInput(String input, int size) {
        if (input.length() != size) return false;
        for (char c : input.toCharArray()) {
            if ("rgbopy".indexOf(c) == -1) return false;
        }
        return true;
    }

    // return the string of the colors chars (no space in between)
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Color color : colors) {
            sb.append(color.symbol);
        }
        return sb.toString();
    }

    // return the char of the color at the position n
    public char getChar(int n) {
        if (n >= 0 && n < colors.length) {
            return colors[n].symbol;
        }
        throw new IndexOutOfBoundsException("Invalid index color");
    }

    // return the size of the secret code
    public int getSize() {
        return colors.length;
    }

    // return the object color of index n
    public Color getColor(int n) {
        if (n >= 0 && n < colors.length) {
            return colors[n];
        }
        throw new IndexOutOfBoundsException("Invalid index color");
    }

    public void setColor(int index, char colorChar) {
        Color color = charToColor(colorChar);
        colors[index] = color;
    }

    Color[] getColors() {
        return colors;
    }
}

class SecretColors extends Guess {
    public SecretColors(int size) {
        super(size);
        generateRandom();
    }

    private void generateRandom() {
        Random random = new Random();

        for (int i = 0; i < colors.length; i++) {
            colors[i] = COLORS[random.nextInt(COLORS.length)];
        }
    }
}


public class Main {
    public static void main(String[] args) {
        MasterMind m = new MasterMind();
    }
}
