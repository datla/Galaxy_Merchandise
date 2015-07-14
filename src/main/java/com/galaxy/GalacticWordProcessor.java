package com.galaxy;

import static com.galaxy.GalacticWord.newGalacticWord;

public class GalacticWordProcessor implements  Processor{

    private final GalacticWordStore galacticWordStore;

    public GalacticWordProcessor(GalacticWordStore galacticWordStore) {
        this.galacticWordStore = galacticWordStore;
    }

    //TODO derive regex from RomanNumber enum values
    @Override
    public boolean canProcess(String input) {
        return input.matches("^[aA-zZ].*\\s+is\\s+[IVXLCDM]$");
    }

    @Override
    public void process(String input) {
        String[] words = input.split("\\s+is\\s+");
        galacticWordStore.addWord(newGalacticWord(words[0]), RomanNumber.newRomanNumber(words[1]));
    }
}
