package com.galaxy;

public interface Processor {

    boolean canProcess(String input);

    void process(String input);

}
