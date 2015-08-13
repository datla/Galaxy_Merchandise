package com.galaxy.output;

import static com.galaxy.datatypes.Metal.newMetal;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.input.GalacticToRomanConverter;
import com.galaxy.input.MetalCreditsStore;

@RunWith(MockitoJUnitRunner.class)
public class MetalCreditsQuestionHandlerTest {

    @Mock
    private GalacticToRomanConverter mockGalacticToRomanConverter;
    @Mock
    private RomanToDecimalConverter mockRomanToDecimalConverter;
    @Mock
    private MetalCreditsStore mockMetalCreditsStore;

    private MetalCreditsQuestionHandler metalCreditsQuestionHandler;

    @Before
    public void setUp(){
        metalCreditsQuestionHandler = new MetalCreditsQuestionHandler(mockMetalCreditsStore, mockGalacticToRomanConverter, mockRomanToDecimalConverter);
    }

    @Test
    public void canHandle_should_return_true_given_valid_input() throws Exception {
        assertTrue(metalCreditsQuestionHandler.canHandle("how many Credits is glob prok Silver ?"));
    }

    @Test
    public void canHandle_should_return_false_given_invalid_input() throws Exception {
        assertFalse(metalCreditsQuestionHandler.canHandle("how much is pish tegj glob glob ?"));
        assertFalse(metalCreditsQuestionHandler.canHandle("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }

    @Test
    public void findAnswer_should_return_valid_formatted_string_given_input_1() {
        when(mockGalacticToRomanConverter.convert("glob prok")).thenReturn("XIV");
        when(mockRomanToDecimalConverter.convert("XIV")).thenReturn(20);
        when(mockMetalCreditsStore.getCredits(newMetal("Iron"))).thenReturn(new BigDecimal(100.45));

        String answer = metalCreditsQuestionHandler.findAnswer("how many Credits is glob prok Iron ?");

        assertThat(answer, is("glob prok Iron is 2009 Credits"));
    }

    @Test
    public void findAnswer_should_return_valid_formatted_string_given_input_2() {
        when(mockGalacticToRomanConverter.convert("glob prok")).thenReturn("IV");
        when(mockRomanToDecimalConverter.convert("IV")).thenReturn(4);
        when(mockMetalCreditsStore.getCredits(newMetal("Iron"))).thenReturn(new BigDecimal(14450));

        String answer = metalCreditsQuestionHandler.findAnswer("how many Credits is glob prok Iron ?");

        assertThat(answer, is("glob prok Iron is 57800 Credits"));
    }
}
