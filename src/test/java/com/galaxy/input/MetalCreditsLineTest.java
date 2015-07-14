package com.galaxy.input;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MetalCreditsLineTest {

    @Test
    public void getters_should_return_valid_values() {

        MetalCreditsLine metalCreditsLine = new MetalCreditsLine("galacticWords", "Iron", "200");

        assertThat(metalCreditsLine.galacticWords(), is("galacticWords"));
        assertThat(metalCreditsLine.metalName(), is("Iron"));
        assertThat(metalCreditsLine.credits(), is("200"));
    }
}
