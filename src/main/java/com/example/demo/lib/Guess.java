
package com.example.demo.lib;
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
