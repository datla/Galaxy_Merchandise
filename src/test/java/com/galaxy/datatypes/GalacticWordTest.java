package com.galaxy.datatypes;

import org.junit.Test;

import static com.galaxy.datatypes.GalacticWord.newGalacticWord;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GalacticWordTest {

    @Test
    public void galacticWord_hashCode() {
        GalacticWord galacticWord1 = newGalacticWord("abc");
        GalacticWord galacticWord2 = newGalacticWord("abc");

        assertThat(galacticWord1.hashCode(), is("abc".hashCode()));
        assertThat(galacticWord1.hashCode(), is(galacticWord2.hashCode()));
    }

    @Test
    public void galacticWord_equals_true() {
        GalacticWord galacticWord1 = newGalacticWord("abc");
        GalacticWord galacticWord2 = newGalacticWord("abc");

        assertTrue(galacticWord1.equals(galacticWord2));
    }

    @Test
    public void galacticWord_equals_false() {
        GalacticWord galacticWord1 = newGalacticWord("abc");
        GalacticWord galacticWord2 = newGalacticWord("def");

        assertFalse(galacticWord1.equals(galacticWord2));
    }
}
