package com.galaxy.output;

public interface Handler {

    boolean canHandle(String question);

    String findAnswer(String question);

}
