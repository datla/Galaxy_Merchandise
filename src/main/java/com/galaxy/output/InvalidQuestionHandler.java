package com.galaxy.output;

public class InvalidQuestionHandler implements Handler {

    @Override
    public boolean canHandle(String question) {
        return true;
    }

    @Override
    public String findAnswer(String question) {
        return "I have no idea what you are talking about";
    }
}
