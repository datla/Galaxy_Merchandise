package com.galaxy.output;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class InvalidQuestionHandlerTest {

    private InvalidQuestionHandler handler;

    @Before
    public void setUp(){
        handler = new InvalidQuestionHandler();
    }

    @Test
    public void canHandle_should_return_true() {
        assertTrue(handler.canHandle(""));
    }

    @Test
    public void findAnswer_should_return_valid_string() {
        assertThat(handler.findAnswer(""), is("I have no idea what you are talking about"));
    }
}
