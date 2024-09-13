package com.cactt4ck.lifestyleapp.model;

import lombok.Getter;

@Getter
public enum Unit {

    GRAMMES("g"),
    LITRES("L"),
    PIECES("pcs"),
    KILOGRAMMES("kg"),
    MILLILITRES("ml");

    private final String symbol;

    Unit(String symbol) {
        this.symbol = symbol;
    }

}
