package me.uwu;

import me.uwu.struct.Card;

public class Tester {
    public static void main(String[] args) {
        Card card = new Card("0541009000000014287480000004000911000000");
        card.print();
        //card.setLastUsage(System.currentTimeMillis() + 2592000000L); // expire dans 30 jours
        card.setRemaining(99); // 99 trajets restants
        System.out.println(card.encode());
    }
}
