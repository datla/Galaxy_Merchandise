package com.galaxy;

import com.galaxy.input.InputProcessor;
import com.galaxy.output.QuestionHandler;

import java.util.ArrayList;
import java.util.List;

public class GalaxyFileProcessor {

    private final FileUtility fileUtility;
    private final InputProcessor inputProcessor;
    private final QuestionHandler questionHandler;

    public GalaxyFileProcessor(FileUtility fileUtility, InputProcessor inputProcessor, QuestionHandler questionHandler) {
        this.fileUtility = fileUtility;
        this.inputProcessor = inputProcessor;
        this.questionHandler = questionHandler;
    }

    public List<String> process(String fileName) throws Exception {
        List<String> outputLines = new ArrayList<>();
        List<String> inputLines = fileUtility.loadLines(fileName);
        for(String line : inputLines){
            if(inputProcessor.canProcess(line)){
                inputProcessor.process(line);
            } else if(questionHandler.canHandle(line)){
                String answer = questionHandler.findAnswer(line);
                outputLines.add(answer);
                System.out.println(answer);
            }
        }
        //System.out.println(outputLines);
        return outputLines;
    }
    
}
