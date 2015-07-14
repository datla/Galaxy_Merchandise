package com.galaxy;

public class MetalCreditsQuestionHandler implements Handler {

    private final MetalCreditsStore metalCreditsStore;

    public MetalCreditsQuestionHandler(MetalCreditsStore metalCreditsStore) {
        this.metalCreditsStore = metalCreditsStore;
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
