package com.galaxy.input;

import com.galaxy.input.GalacticWordProcessor;
import com.galaxy.input.GalacticWordStore;
import org.junit.Before;
import org.junit.Test;

import static com.galaxy.datatypes.GalacticWord.newGalacticWord;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GalacticWordProcessorTest {

    private GalacticWordProcessor processor;
    GalacticWordStore galacticWordStore;

    @Before
    public void setUp(){
        galacticWordStore = new GalacticWordStore();
        processor = new GalacticWordProcessor(galacticWordStore);
    }

    @Test
    public void canProcess_true_given_valid_input() throws Exception {
        assertTrue(processor.canProcess("glob is I"));
        assertTrue(processor.canProcess("prok is V"));
        assertTrue(processor.canProcess("pish is X"));
    }

    @Test
    public void canProcess_false_given_invalid_input() throws Exception {
        assertFalse(processor.canProcess("glob glob Silver is 34 Credits"));
        assertFalse(processor.canProcess("how much is pish tegj glob glob ?"));
    }

    @Test
    public void process_should_add_word_to_store_input_1() throws Exception {
        processor.process("glob is I");
        assertThat(galacticWordStore.findRomanNumber(newGalacticWord("glob")).toString(), is("I"));
    }

    @Test
    public void process_should_add_word_to_store_input_2() throws Exception {
        processor.process("pish is X");
        assertThat(galacticWordStore.findRomanNumber(newGalacticWord("pish")).toString(), is("X"));
    }
}
