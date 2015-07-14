package com.galaxy;

public class GalacticWord extends AbstractStringType {


    private GalacticWord(String value) {
        super(value);
    }

    public static GalacticWord newGalacticWord(String value){
        return new GalacticWord(value);
    }
}
