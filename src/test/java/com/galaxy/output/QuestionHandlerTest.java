package com.galaxy.output;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionHandlerTest {

    @Mock
    private GalacticQuestionHandler mockGalacticQuestionHandler;
    @Mock
    private MetalCreditsQuestionHandler mockMetalCreditsQuestionHandler;
    @Mock
    private InvalidQuestionHandler mockInvalidQuestionHandler;

    private QuestionHandler questionHandler;

    @Before
    public void setUp(){
        questionHandler = new QuestionHandler(mockGalacticQuestionHandler, mockMetalCreditsQuestionHandler, mockInvalidQuestionHandler);
    }

    @Test
    public void canHandle_should_return_true_given_valid_input() {
        assertTrue(questionHandler.canHandle("how many Credits is glob prok Iron ?"));
    }

    @Test
    public void canHandle_should_return_false_given_invalid_input() {
        assertFalse(questionHandler.canHandle("glob glob Silver is 34 Credits"));
    }

    @Test
    public void findAnswer_should_return_answer_from_first_available_handler_that_can_answer() {
        String question = "question";

        when(mockGalacticQuestionHandler.canHandle(question)).thenReturn(false);
        when(mockMetalCreditsQuestionHandler.canHandle(question)).thenReturn(true);
        when(mockMetalCreditsQuestionHandler.findAnswer(question)).thenReturn("answer");

        String answer = questionHandler.findAnswer(question);

        assertThat(answer, is("answer"));
        verifyZeroInteractions(mockInvalidQuestionHandler);
        verify(mockGalacticQuestionHandler).canHandle(question);
    }
}
