package me.uwu;

public class ReaderTester {
    public static void main(String[] args) {
        String card = "0541009000000014287480000004000911000000";
        Reader reader = new Reader();
        reader.read(card);
    }
}
