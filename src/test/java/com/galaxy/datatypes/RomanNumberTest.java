package com.galaxy.datatypes;

import org.junit.Test;

import static com.galaxy.datatypes.RomanNumber.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RomanNumberTest {

    @Test
    public void decimalValue_should_return_valid_value() throws Exception {
        assertThat(I.decimalValue(), is(1));
        assertThat(V.decimalValue(), is(5));
        assertThat(X.decimalValue(), is(10));
        assertThat(L.decimalValue(), is(50));
        assertThat(C.decimalValue(), is(100));
        assertThat(D.decimalValue(), is(500));
        assertThat(M.decimalValue(), is(1000));
    }

    @Test
    public void valueOf_should_return_valid_enum() throws Exception {
        assertThat(RomanNumber.valueOf("I"), is(I));
        assertThat(RomanNumber.valueOf("V"), is(V));
        assertThat(RomanNumber.valueOf("X"), is(X));
        assertThat(RomanNumber.valueOf("L"), is(L));
        assertThat(RomanNumber.valueOf("C"), is(C));
        assertThat(RomanNumber.valueOf("D"), is(D));
        assertThat(RomanNumber.valueOf("M"), is(M));
    }
}
