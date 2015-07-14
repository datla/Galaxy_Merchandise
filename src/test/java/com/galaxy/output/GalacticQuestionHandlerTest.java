package com.galaxy.output;

import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.input.GalacticToRomanConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GalacticQuestionHandlerTest {

    private GalacticQuestionHandler galacticQuestionHandler;
    @Mock
    private GalacticToRomanConverter mockGalacticToRomanConverter;
    @Mock
    private RomanToDecimalConverter mockRomanToDecimalConverter;

    @Before
    public void setUp(){
        galacticQuestionHandler = new GalacticQuestionHandler(mockGalacticToRomanConverter, mockRomanToDecimalConverter);
    }

    @Test
    public void canHandle_should_return_true_given_valid_input() {
        assertTrue(galacticQuestionHandler.canHandle("how much is pish tegj glob glob ?"));
    }

    @Test
    public void canHandle_should_return_false_given_invalid_input() {
        assertFalse(galacticQuestionHandler.canHandle("how many Credits is glob prok Silver ?"));
        assertFalse(galacticQuestionHandler.canHandle(
                "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
    }

    @Test
    public void findAnswer_should_return_valid_formatted_string() {
        when(mockGalacticToRomanConverter.convert("pish tegj glob glob")).thenReturn("XIV");
        when(mockRomanToDecimalConverter.convert("XIV")).thenReturn(200L);

        String answer = galacticQuestionHandler.findAnswer("how much is pish tegj glob glob ?");

        assertThat(answer, is("pish tegj glob glob is 200"));
    }
}
