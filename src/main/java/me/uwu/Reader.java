package me.uwu;

import me.uwu.utils.STCLUtis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reader {
    public void read(String card) {
        int max = Integer.parseInt(card.substring(3, 5));
        int remaining = Integer.parseInt(card.substring(5, 7));

        CardType type = CardType.UNKNOWN;
        if (max == 1)
            type = CardType.TRAJET_1;
        else if (max == 10)
            type = CardType.TRAJET_10;

        String line = cutZeros(card.substring(21, 28));
        int variant = Integer.parseInt(cutZeros(card.substring(28, 31)));
        int busNumber = Integer.parseInt(cutZeros(card.substring(31, 34)));

        long epoch = STCLUtis.stclTimeStampToEpoch(Integer.parseInt(card.substring(14, 21)));
        DateFormat simple = new SimpleDateFormat("dd MMM yyyy  HH:mm");
        String dateStr = simple.format(new Date(epoch)).replace("  ", " at ");

        System.out.println("Usage: " + remaining + "/" + max);
        System.out.println("Type: " + type);
        System.out.println("===================");
        System.out.println("Last usage:");
        System.out.println("  Date: " + dateStr);
        System.out.println("  Line: " + line);
        System.out.println("  Line variant: " + variant);
        System.out.println("  Bus number: " + busNumber);
    }

    private static String cutZeros(String data) {
        while (data.startsWith("0"))
            data = data.substring(1);
        return data.equals("") ? "0" : data;
    }
}
