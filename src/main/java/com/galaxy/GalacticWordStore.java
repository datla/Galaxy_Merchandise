package com.galaxy;

import java.util.HashMap;
import java.util.Map;

public class GalacticWordStore {

    Map<GalacticWord, RomanNumber> store = new HashMap();

    public void addWord(GalacticWord word, RomanNumber romanNumber){
        store.put(word, romanNumber);
    }

    public RomanNumber findRomanNumber(GalacticWord word){
        return store.get(word);
    }
}
