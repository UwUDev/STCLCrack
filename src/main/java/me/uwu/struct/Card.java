package me.uwu.struct;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.uwu.CardType;
import me.uwu.CardReader;
import me.uwu.CardWriter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
public @Data class Card {
    private CardType type;
    private int max;
    private int remaining;
    private long lastUsage;
    private String line;
    private int variant;
    private int busNumber;

    public Card(String card) {
        CardReader reader = new CardReader();
        Card card1 = reader.read(card);
        this.type = card1.type;
        this.max = card1.max;
        this.remaining = card1.remaining;
        this.lastUsage = card1.lastUsage;
        this.line = card1.line;
        this.variant = card1.variant;
        this.busNumber = card1.busNumber;
    }

    public String encode() {
        return new CardWriter().write(this);
    }

    public void print() {
        DateFormat simple = new SimpleDateFormat("dd MMM yyyy  HH:mm");
        String dateStr = simple.format(new Date(lastUsage)).replace("  ", " at ");

        System.out.println("Usage: " + remaining + "/" + max);
        System.out.println("Type: " + type);
        System.out.println("===================");
        System.out.println("Last usage:");
        System.out.println("  Date: " + dateStr);
        System.out.println("  Line: " + line);
        System.out.println("  Line variant: " + variant);
        System.out.println("  Bus number: " + busNumber);
    }
}
