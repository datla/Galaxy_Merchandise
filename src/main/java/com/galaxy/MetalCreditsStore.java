package com.galaxy;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class MetalCreditsStore {

    Map<Metal, BigDecimal> store = new HashMap();

    public void addMetal(Metal metal, BigDecimal credits){
        store.put(metal, credits);
    }

    public BigDecimal getCredits(Metal metal) {
        return store.get(metal);
    }
}
