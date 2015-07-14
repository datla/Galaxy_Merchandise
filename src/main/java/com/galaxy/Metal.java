package com.galaxy;

public class Metal extends AbstractStringType {

    private Metal(String value) {
        super(value);
    }

    public static Metal newMetal(String value){
        return new Metal(value);
    }
}
