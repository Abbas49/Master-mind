import java.util.*;

// while validating input if the input is invalid, tell the user that, and ask him to enter the inputs again
class InputHandler {
    public static Scanner scan = new Scanner(System.in);
    // scan and return the secretCode size
    public static int getSecretSize() {
        System.out.print("Enter the size of the Secret code: at least 3");
        int size = scan.nextInt();
        return size;
    }
    /*
    scan input and make sure it is correct input
    - right size
    - right form
    - right chars
     */
    public static Guess getGuess(int size) {
        return new Guess(size);
    }

}

class OutputHandler {

}

class GuessResult{
    public int blackBalls = 0;
    public int whiteBalls = 0;
    GuessResult(int blackBalls, int whiteBalls){
        this.blackBalls = blackBalls;
        this.whiteBalls = whiteBalls;
    }
}
class MasterMind{
    SecretColors secretCode;
    MasterMind(){
        System.out.println("Enter the size of the Code");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        secretCode = new SecretColors(size);
    }
    public void guessNumber(){
        Guess guess = InputHandler.getGuess(secretCode.getSize());
        GuessResult result = validateGuess(guess);
    }
    private GuessResult validateGuess(Guess guess){
        GuessResult result = new GuessResult(0, 0);
        result.blackBalls = numberOfPositionMatch(guess);
        result.whiteBalls = numberOfColorMatch(guess);
        return result;
    }
    public void restartGame(){

    }
    public int numberOfPositionMatch(Guess guess){
        String guessStr = guess.toString();
        String secretStr = guess.toString();
        int count = 0;
        for(int i = 0; i < secretStr.length(); i++) {
            if(guessStr.charAt(i) == secretStr.charAt(i)){
                count++;
            }
        }
        return count;
    }
    public int numberOfColorMatch(Guess guess){
        int[] guessColorsCount = new int[Color.colorsCount];
        int[] secretColorsCount = new int[Color.colorsCount];
        for(int i = 0; i < guess.getSize(); i++){
            guessColorsCount[guess.getColor(i).id]++;
            secretColorsCount[secretCode.getColor(i).id]++;
        }
        int count = 0;
        for(int i = 0; i < guess.getSize(); i++){
            count += Math.min(guessColorsCount[i], secretColorsCount[i]);
        }
        return count;
    }
}
class Color {
    public static Color red, green, yellow, blue, brown, purple;
    public static int colorsCount = 0;
    public int id;
    public String name;
    public char symbol;

    Color(int id, String name) {
        this.id = id;
        this.name = name;
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
        brown = new Color(4, "Brown");
        purple = new Color(5, "Purple");
    }
}
class Guess{
    protected Color[] colors;
    protected static final Color[] COLORS ={
            Color.red,Color.green,Color.yellow,Color.blue,Color.brown,Color.purple
    };
    public Guess(int size){
        colors = new Color[size];
    }
    // return the string of the colors chars (no space in between)
    public String toString(){
        return "";
    }
    // return the char of the color at the position n
    public char getChar(int n){
        return 't';
    }
    // return the size of the secret code
    public int getSize(){
        return 0;
    }
    // return the object color of index n
    public Color getColor(int n){
        return colors[n];
    }
    Color[] getColors()
    {
        return colors;
    }
}
class SecretColors extends Guess{
    public SecretColors(int size) {
        super(size);
        generateRandom();
    }
    private void generateRandom(){
     Random random = new Random();
 
   for(int i = 0 ; i < colors.length ; i++){
   colors[i]=COLORS[random.nextInt(COLORS.length)];}
   }
}


public class Main {
    public static void main(String[] args) {

    }
}
