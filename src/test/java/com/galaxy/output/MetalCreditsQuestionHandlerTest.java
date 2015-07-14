package com.galaxy.output;

import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.datatypes.Metal;
import com.galaxy.input.GalacticToRomanConverter;
import com.galaxy.input.MetalCreditsStore;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static com.galaxy.datatypes.Metal.newMetal;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

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
    public void findAnswer_should_return_valid_formatted_string() {
        when(mockGalacticToRomanConverter.convert("glob prok")).thenReturn("XIV");
        when(mockRomanToDecimalConverter.convert("XIV")).thenReturn(20L);
        when(mockMetalCreditsStore.getCredits(newMetal("Iron"))).thenReturn(new BigDecimal(100.45));

        String answer = metalCreditsQuestionHandler.findAnswer("how many Credits is glob prok Iron ?");

        assertThat(answer, is("glob prok Iron is 2009 Credits"));
    }
}
