package com.galaxy;

import com.galaxy.GalacticToRomanConverter;
import com.galaxy.GalacticWordStore;
import org.junit.Before;
import org.junit.Test;

import static com.galaxy.GalacticWord.newGalacticWord;
import static com.galaxy.RomanNumber.newRomanNumber;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GalacticToRomanConverterTest {

    private GalacticToRomanConverter converter;

    @Before
    public void setUp(){
        GalacticWordStore galacticWordStore = getInitialisedStore();
        converter = new GalacticToRomanConverter(galacticWordStore);
    }

    private GalacticWordStore getInitialisedStore() {
        GalacticWordStore store = new GalacticWordStore();
        store.addWord(newGalacticWord("glob"), newRomanNumber("I"));
        store.addWord(newGalacticWord("prok"), newRomanNumber("V"));
        store.addWord(newGalacticWord("pish"), newRomanNumber("X"));
        return store;
    }

    @Test
    public void convert_should_return_valid_roman_string_given_combined_galactic_word_with_input_1() throws Exception {
        String romanString = converter.convert("glob prok");
        assertThat(romanString, is("IV"));
    }

    @Test
    public void convert_should_return_valid_roman_string_given_combined_galactic_word_with_input_2() throws Exception {
        String romanString = converter.convert("pish glob prok");
        assertThat(romanString, is("XIV"));
    }
}
