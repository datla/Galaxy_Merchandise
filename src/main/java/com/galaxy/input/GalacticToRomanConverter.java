package com.galaxy.input;

import com.galaxy.datatypes.GalacticWord;
import com.galaxy.datatypes.RomanNumber;
import com.galaxy.input.GalacticWordStore;

public class GalacticToRomanConverter {

    private final GalacticWordStore galacticWordStore;

    public GalacticToRomanConverter(GalacticWordStore galacticWordStore) {
        this.galacticWordStore = galacticWordStore;
    }

    public String convert(String combinedGalacticWord) {
        StringBuffer romanString = new StringBuffer();
        String[] galacticWords = combinedGalacticWord.split(" ");

        for(String galacticWord : galacticWords) {
            RomanNumber romanNumber = galacticWordStore.findRomanNumber(GalacticWord.newGalacticWord(galacticWord));
            romanString.append(romanNumber.toString());
        }

        return romanString.toString();
    }
}
