package com.galaxy;

public interface Handler {

    boolean canHandle(String question);

    String findAnswer(String question);

}
