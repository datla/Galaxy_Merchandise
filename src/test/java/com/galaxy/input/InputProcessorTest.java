package com.galaxy.input;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class InputProcessorTest {

    @Mock
    private GalacticWordProcessor mockGalacticWordProcessor;
    @Mock
    private MetalCreditsProcessor mockMetalCreditsProcessor;

    private InputProcessor inputProcessor;
    private String input = "input";

    @Before
    public void setUp() {
        inputProcessor = new InputProcessor(mockGalacticWordProcessor, mockMetalCreditsProcessor);
    }

    @Test
    public void canProcess_should_return_true_given_at_least_one_of_the_processor_can_process() {
        when(mockGalacticWordProcessor.canProcess(input)).thenReturn(true);

        assertTrue(inputProcessor.canProcess(input));

        verifyZeroInteractions(mockMetalCreditsProcessor);
    }

    @Test
    public void canProcess_should_return_false_given_none_of_the_processes_can_process() {

        assertFalse(inputProcessor.canProcess(input));

        verify(mockGalacticWordProcessor).canProcess(input);
        verify(mockMetalCreditsProcessor).canProcess(input);

    }

    @Test
    public void process_should_invoke_process_on_first_processor_that_can_process_input() {
        when(mockMetalCreditsProcessor.canProcess(input)).thenReturn(true);

        inputProcessor.process(input);

        verify(mockGalacticWordProcessor).canProcess(input);
        verify(mockMetalCreditsProcessor).canProcess(input);
    }
}
