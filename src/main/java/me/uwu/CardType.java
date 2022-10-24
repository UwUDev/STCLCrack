package me.uwu;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CardType {
    TRAJET_1("0540101000000000000000000000000000"),
    TRAJET_10("0541010000000000000000000000000000"),
    UNKNOWN("0");

    private final String blankStripe;
}
