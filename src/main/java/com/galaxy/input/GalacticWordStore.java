package com.galaxy.input;

import com.galaxy.datatypes.GalacticWord;
import com.galaxy.datatypes.RomanNumber;

import java.util.HashMap;
import java.util.Map;

public class GalacticWordStore {

    Map<GalacticWord, RomanNumber> store = new HashMap<GalacticWord, RomanNumber>();

    public void addWord(GalacticWord word, RomanNumber romanNumber){
        store.put(word, romanNumber);
    }

    public RomanNumber findRomanNumber(GalacticWord word){
        return store.get(word);
    }
}
