import java.util.*;

class InputHandler {
    public static Scanner scan = new Scanner(System.in);

    public static int getSecretSize() {
        System.out.print("Enter the size of the Secret code:");
        int size = scan.nextInt();
        return size;
    }

    public static String getGuess() {
        return "";
    }

    public static boolean validateGuess() {
        return false;
    }
}

class OutputHandler {

}
class MasterMind{
    SecretColors secretCode;
    MasterMind(){
        System.out.println("Enter the size of the Code");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        secretCode = new SecretColors(size);
    }
    void guessNumber(){

    }
    void restartGame(){

    }
    int numberOfPositionMatch(){
        return 0;
    }
    int numberOfColorMatch(){
        return 0;
    }
}
class Color {
    public static Color red, green, yellow, blue, brown, purple;

    public int id;
    public String name;

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
class SecretColors {
    private Color[] colors; 
    private static final Color[] COLORS ={
    Color.red,Color.green,Color.yellow,Color.blue,Color.brown,Color.purple
    }; 
    public SecretColors(int size){
    colors = new Color[size];
      generateRandom();}
    
    private void generateRandom(){
     Random random = new Random();
 
   for(int i = 0 ; i < colors.length ; i++){
   colors[i]=COLORS[random.nextInt(COLORS.length)];}
   }
   Color[] getSecrateCode()
   {
        return colors;
   }
}


public class Main {
    public static void main(String[] args) {

    }
}
