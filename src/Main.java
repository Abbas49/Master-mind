import java.util.Scanner;

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
class Color{
    public int id;
    public int name;
    Color(int id, int name){
        this.id = id;
        this.name = name;
    }
}
// array of colors
class SecretColors{
    private Color[] colors;
    SecretColors(int size){
        colors = new Color[size];
        generateRandom();
    }
    void generateRandom(){

    }
    Color[] getSecrateCode(){

        return colors;
    }
}


public class Main {
    public static void main(String[] args) {

    }
}
