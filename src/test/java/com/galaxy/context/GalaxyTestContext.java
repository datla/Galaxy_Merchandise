package com.galaxy.context;

import com.galaxy.FileUtility;
import com.galaxy.business.MetalCreditsCalculator;
import com.galaxy.business.RomanNumberValidator;
import com.galaxy.business.RomanToDecimalConverter;
import com.galaxy.input.*;
import com.galaxy.output.GalacticQuestionHandler;
import com.galaxy.output.InvalidQuestionHandler;
import com.galaxy.output.MetalCreditsQuestionHandler;
import com.galaxy.output.QuestionHandler;

public class GalaxyTestContext {

    private final InputProcessor inputProcessor;
    private final QuestionHandler questionHandler;
    private final FileUtility fileUtility;

    public GalaxyTestContext() {
    	
        GalacticWordStore galacticWordStore = new GalacticWordStore();
        MetalCreditsStore metalCreditsStore = new MetalCreditsStore();
        RomanNumberValidator romanNumberValidator = new RomanNumberValidator();
        GalacticToRomanConverter galacticToRomanConverter = new GalacticToRomanConverter(galacticWordStore);
        RomanToDecimalConverter romanToDecimalConverter = new RomanToDecimalConverter(romanNumberValidator);
        GalacticWordProcessor galacticWordProcessor = new GalacticWordProcessor(galacticWordStore);
        MetalCreditsCalculator metalCreditsCalculator = new MetalCreditsCalculator(galacticToRomanConverter,romanToDecimalConverter);
        MetalCreditsProcessor metalCreditsProcessor = new MetalCreditsProcessor(metalCreditsStore,new MetalCreditsLineParser(),metalCreditsCalculator);
        GalacticQuestionHandler galacticQuestionHandler = new GalacticQuestionHandler(galacticToRomanConverter,romanToDecimalConverter);
        MetalCreditsQuestionHandler metalCreditsQuestionHandler = new MetalCreditsQuestionHandler(metalCreditsStore,galacticToRomanConverter, romanToDecimalConverter);
        
        inputProcessor = new InputProcessor(galacticWordProcessor,metalCreditsProcessor);
        questionHandler = new QuestionHandler(galacticQuestionHandler,metalCreditsQuestionHandler,new InvalidQuestionHandler());
        fileUtility = new FileUtility();

    }

    public InputProcessor getInputProcessor() {
        return inputProcessor;
    }

    public QuestionHandler getQuestionHandler() {
        return questionHandler;
    }

    public FileUtility getFileUtility() {
        return fileUtility;
    }
}
