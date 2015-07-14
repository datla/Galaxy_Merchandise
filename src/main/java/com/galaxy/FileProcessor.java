package com.galaxy;

import java.util.List;

public class FileProcessor {

    private final FileUtility fileUtility;
    private final InputProcessor inputProcessor;
    private final QuestionHandler questionHandler;

    public FileProcessor(FileUtility fileUtility, InputProcessor inputProcessor, QuestionHandler questionHandler) {
        this.fileUtility = fileUtility;
        this.inputProcessor = inputProcessor;
        this.questionHandler = questionHandler;
    }

    public void process(String fileName) throws Exception {
        List<String> lines = fileUtility.loadLines(fileName);
        for(String line : lines){
            if(inputProcessor.canProcess(line)){
                inputProcessor.process(line);
            }else if(questionHandler.canHandle(line)){
                questionHandler.findAnswer(line);
            }
        }
    }
}
