package me.uwu;

import me.uwu.struct.Card;
import me.uwu.utils.STCLUtis;

public class CardWriter {
    public String write(Card card) {
        return "054" +
                appendZeros(String.valueOf(card.getMax()), 2) +
                appendZeros(String.valueOf(card.getRemaining()), 2) +
                appendZeros(String.valueOf(STCLUtis.epochToSTCLTimeStamp(card.getLastUsage())), 14) +
                appendZeros(String.valueOf(card.getLine()), 7) +
                appendZeros(String.valueOf(card.getVariant()), 3) +
                appendZeros(String.valueOf(card.getBusNumber()), 3) +
                "000000";
    }

    private String appendZeros(String card, int length) {
        StringBuilder cardBuilder = new StringBuilder(card);
        while (cardBuilder.length() < length)
            cardBuilder.insert(0, "0");
        return cardBuilder.toString();
    }
}
