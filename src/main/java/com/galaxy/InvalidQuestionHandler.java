package com.galaxy;

public class InvalidQuestionHandler implements Handler {

    @Override
    public boolean canHandle(String question) {
        return true;
    }

    @Override
    public String findAnswer(String question) {
        return "";
    }
}
