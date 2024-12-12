import java.util.Scanner;

public class InputHandler {
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
