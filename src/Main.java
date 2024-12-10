import java.util.*;

// while validating input if the input is invalid, tell the user that, and ask him to enter the inputs again
class InputHandler {
    public static Scanner scan = new Scanner(System.in);
    // scan and return the secretCode size
    public static int getSecretSize() {
        System.out.print("Enter the size of the Secret code: at least 3");
        int size = scan.nextInt();
        if(size < 3){
            System.out.println("Secret code must be at least 3");
            return getSecretSize();
        }else return size;
    }
    public static Guess getGuess(int size) {
        System.out.print("Enter the guss: ");

        Guess guess= new Guess(getSecretSize()) ;
         char g = scan.nextLine().charAt(0);
        System.out.println("Enter  r, g, y, b, o, p : ");
        for(int i = 0; i < size; i++){
             g = scan.nextLine().charAt(0);
            if( g != 'r' && g!='g' && g!= 'y' && g!='b' && g!= 'o' &&g!='p'){
                System.out.println("this is unvalud colors Enter color again");
                g = scan.nextLine().charAt(0);
            }
        }


        return new Guess(size);
    }
    /*
    scan input and make sure it is correct input
    - right size
    - right form
    - right chars
     */


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
    public static Color red, green, yellow, blue, orange, purple;
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
        orange = new Color(4, "orange");
        purple = new Color(5, "Purple");
    }
}
class Guess{
    protected Color[] colors;
    protected static final Color[] COLORS ={
            Color.red,Color.green,Color.yellow,Color.blue,Color.orange,Color.purple
    };
    public Guess(int size){
        colors = new Color[size];
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("your guess");
            String input = scanner.nextLine().toLowerCase(null);
        
        if (validateInput(input , size)) {
            for(int i = 0 ; i < size ; i++){
                colors[i] = charToColor(input.charAt(i));
            }
        break;
        }else{
            System.out.println("invslid input");
        }
        
        }
    }
    protected Color charToColor(char c){
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
            throw new IllegalArgumentException("invalid char"+c);
        }
    }
    protected boolean validateInput(String input, int size){
        if (input.length() != size)return false;
          for (char c : input.toCharArray()){
            if("rgbopy".indexOf(c) == -1) return false;
          }
            return true;
        
    }
    // return the string of the colors chars (no space in between)
    public String toString(){
       StringBuilder sb = new StringBuilder();
       for(Color color : colors){
        sb.append(color.symbol);
       }
    return sb.toString();
    }
    // return the char of the color at the position n
    public char getChar(int n){
       if (n>=0 && n< colors.length) {
         return colors[n].symbol;
       }
       throw new IndexOutOfBoundsException("Invalid index color");
    }
    // return the size of the secret code
    public int getSize(){
        return colors.length;
    }
    // return the object color of index n
    public Color getColor(int n){
        if (n >= 0 && n < colors.length) {
            return colors[n];
        }
        throw new IndexOutOfBoundsException("Invalid index color");
    }
    public void setColor(char color){

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
