package com.galaxy.output;

import java.util.ArrayList;
import java.util.List;

public class QuestionHandler implements  Handler {

    private final List<Handler> handlers = new ArrayList<>();

    public QuestionHandler(GalacticQuestionHandler galacticQuestionHandler,
            MetalCreditsQuestionHandler metalCreditsQuestionHandler,
            InvalidQuestionHandler invalidQuestionHandler) {

        handlers.add(galacticQuestionHandler);
        handlers.add(metalCreditsQuestionHandler);
        handlers.add(invalidQuestionHandler);
    }

    @Override
    public boolean canHandle(String question) {
        return question.endsWith("?");
    }

    @Override
    public String findAnswer(String question) {
        String answer = "";
        for(Handler handler : handlers) {
            if(handler.canHandle(question)){
                handler.findAnswer(question);
                break;
            }
        }

        return answer;
    }
}
