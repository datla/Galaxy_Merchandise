package com.galaxy;

public enum RomanNumber {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private int decimalValue;

    RomanNumber(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public int decimalValue() {
        return decimalValue;
    }

    public static RomanNumber newRomanNumber(String numberStr){
        return valueOf(numberStr);
    }
}
