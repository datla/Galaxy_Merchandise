package com.galaxy;

import com.galaxy.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static com.galaxy.Metal.newMetal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MetalCreditsProcessorTest {

    @Mock
    private MetalCreditsLineParser mockMetalCreditsLineParser;
    @Mock
    private MetalCreditsCalculator mockMetalCreditsCalculator;
    @Mock
    private MetalCreditsStore mockMetalCreditsStore;

    private MetalCreditsProcessor processor;

    @Before
    public void setUp(){
        processor = new MetalCreditsProcessor(mockMetalCreditsStore, mockMetalCreditsLineParser, mockMetalCreditsCalculator);
    }

    @Test
    public void canProcess_true_given_valid_input() {
        assertTrue(processor.canProcess("glob glob Silver is 34 Credits"));
        assertTrue(processor.canProcess("glob prok Gold is 57800 Credits"));
    }

    @Test
    public void canProcess_false_given_invalid_input() {
        assertFalse(processor.canProcess("glob is I"));
        assertFalse(processor.canProcess("how much is pish tegj glob glob ?"));
    }

    @Test
    public void process_should_add_populate_metal_credits_store() {
        String input = "glob glob Silver is 34 Credits";
        MetalCreditsLine metalCreditsLine = new MetalCreditsLine("glob glob", "Silver", "34");
        BigDecimal credits = new BigDecimal("20");

        when(mockMetalCreditsLineParser.parse(input)).thenReturn(metalCreditsLine);
        when(mockMetalCreditsCalculator.calculateCredits(metalCreditsLine)).thenReturn(credits);

        processor.process("glob glob Silver is 34 Credits");

        verify(mockMetalCreditsStore).addMetal(newMetal("Silver"), credits);
    }
}
