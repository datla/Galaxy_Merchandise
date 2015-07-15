package com.galaxy.business;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RomanToDecimalConverterTest {

    @Test
    public void convert() {
        RomanToDecimalConverter converter = new RomanToDecimalConverter(new RomanNumberValidator());
        assertThat(converter.convert("XI"), is(11));
        assertThat(converter.convert("MCMIII"), is(1903));
        assertThat(converter.convert("I"), is(1));
        assertThat(converter.convert("V"), is(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void convert_should_throw_exception_given_invalid_input() {
        RomanToDecimalConverter converter = new RomanToDecimalConverter(new RomanNumberValidator());
        converter.convert("IIII");
    }

}
