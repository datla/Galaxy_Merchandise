package com.galaxy;

public class GalacticQuestionHandler implements Handler {

    private final GalacticWordStore galacticWordStore;

    public GalacticQuestionHandler(GalacticWordStore galacticWordStore) {
        this.galacticWordStore = galacticWordStore;
    }

    @Override
    public boolean canHandle(String question) {
        return false;
    }

    @Override
    public String findAnswer(String question) {
        return null;
    }
}
