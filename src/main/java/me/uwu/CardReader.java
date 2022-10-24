package me.uwu;

import me.uwu.struct.Card;
import me.uwu.utils.STCLUtis;

public class CardReader {
    public Card read(String card) {
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

        return new Card(type, max, remaining, epoch, line, variant, busNumber);
    }

    private static String cutZeros(String data) {
        while (data.startsWith("0"))
            data = data.substring(1);
        return data.equals("") ? "0" : data;
    }
}
