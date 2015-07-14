package com.galaxy.input;

import java.util.ArrayList;
import java.util.List;

public class InputProcessor implements Processor {

    private final List<Processor> processors = new ArrayList<>();

    public InputProcessor(GalacticWordProcessor galacticWordProcessor, MetalCreditsProcessor metalCreditsProcessor) {
        processors.add(galacticWordProcessor);
        processors.add(metalCreditsProcessor);
    }

    @Override
    public boolean canProcess(String input) {
        //TODO refactor to avoid multiple return statements
        for(Processor processor : processors){
            if(processor.canProcess(input)){
                return true;
            }
        }
        return false;
    }

    public void process(String input){
        for(Processor processor : processors){
            if(processor.canProcess(input)){
                processor.process(input);
                break;
            }
        }
    }
}
