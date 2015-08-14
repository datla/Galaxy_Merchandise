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
        boolean canProcess = false;
        for(Processor processor : processors){
            if(processor.canProcess(input)){
            	canProcess = true;
            }
        }
        return canProcess;
    }

    @Override
    public void process(String input){
        for(Processor processor : processors){
            if(processor.canProcess(input)){
                processor.process(input);
                break;
            }
        }
    }
}
