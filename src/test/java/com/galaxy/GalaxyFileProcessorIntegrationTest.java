package com.galaxy;

import com.galaxy.context.GalaxyTestContext;
import com.galaxy.input.InputProcessor;
import com.galaxy.output.QuestionHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class GalaxyFileProcessorIntegrationTest {

    private GalaxyFileProcessor processor;

    @Before
    public void setUp(){
        GalaxyTestContext galaxyTestContext = new GalaxyTestContext();
        FileUtility fileUtility = galaxyTestContext.getFileUtility();
        InputProcessor inputProcessor = galaxyTestContext.getInputProcessor();
        QuestionHandler questionHandler = galaxyTestContext.getQuestionHandler();

        processor = new GalaxyFileProcessor(fileUtility, inputProcessor, questionHandler);
    }
    
    @Test
    public void process() throws Exception {
        List<String> outputLines = processor.process("testData.txt");
        assertThat(outputLines.size(), is(5));
        assertThat(outputLines.get(0), is("pish tegj glob glob is 42"));
        assertThat(outputLines.get(1), is("glob prok Silver is 68 Credits"));
        assertThat(outputLines.get(2), is("glob prok Gold is 57800 Credits"));
        assertThat(outputLines.get(3), is("glob prok Iron is 782 Credits"));
        assertThat(outputLines.get(4), is("I have no idea what you are talking about"));
    }
}
