package com.solvd.lawfirm.collections;

import java.util.HashMap;
import java.util.Map;

public class CrimeHashMap {
    public Map<String, Integer> createCrimeHashMap() {
        Map<String, Integer> crimeHashMap = new HashMap<>();
        crimeHashMap.put("robbery", 10);
        crimeHashMap.put("homicide", 20);
        crimeHashMap.put("hooliganism", 50);
        return crimeHashMap;
    }

}
