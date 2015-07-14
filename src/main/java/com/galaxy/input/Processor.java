package com.galaxy.input;

public interface Processor {

    boolean canProcess(String input);

    void process(String input);

}
