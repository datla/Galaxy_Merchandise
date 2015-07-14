package com.galaxy.input;

import com.galaxy.input.MetalCreditsLine;
import com.galaxy.input.MetalCreditsLineParser;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalCreditsLineParserTest {

    private MetalCreditsLineParser parser;

    @Before
    public void setUp(){
        parser = new MetalCreditsLineParser();
    }

    @Test
    public void parse_with_input_1() {
        MetalCreditsLine metalCredits = parser.parse("glob glob Silver is 34 Credits");
        assertThat(metalCredits.galacticWords(), is("glob glob"));
        assertThat(metalCredits.metalName(), is("Silver"));
        assertThat(metalCredits.credits(), is("34"));
    }

    @Test
    public void parse_with_input_2() {
        MetalCreditsLine metalCredits = parser.parse("pish pish Iron is 3910 Credits");
        assertThat(metalCredits.galacticWords(), is("pish pish"));
        assertThat(metalCredits.metalName(), is("Iron"));
        assertThat(metalCredits.credits(), is("3910"));
    }
}
