package com.galaxy;

import com.galaxy.input.InputProcessor;
import com.galaxy.output.QuestionHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GalaxyFileProcessorTest {

    @Mock
    private FileUtility mockFileUtility;
    @Mock
    private InputProcessor mockInputProcessor;
    @Mock
    private QuestionHandler mockQuestionHandler;

    private GalaxyFileProcessor processor;

    @Before
    public void setUp(){
        processor = new GalaxyFileProcessor(mockFileUtility, mockInputProcessor, mockQuestionHandler);
    }


    @Test
    public void process_should_return_output_lines() throws Exception {
        String fileName = "testData";
        List<String> inputLines = new ArrayList(){{
            add("input line 1");
            add("question 1");
        }};

        when(mockFileUtility.loadLines(fileName)).thenReturn(inputLines);
        when(mockInputProcessor.canProcess("input line 1")).thenReturn(true);
        when(mockQuestionHandler.canHandle("question 1")).thenReturn(true);
        when(mockQuestionHandler.findAnswer("question 1")).thenReturn("output line 1");

        List<String> outputLines = processor.process(fileName);

        assertThat(outputLines.size(), is(1));
        assertThat(outputLines.get(0), is("output line 1"));
        verify(mockInputProcessor).process("input line 1");
    }
}
