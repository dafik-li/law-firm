package com.solvd.lawfirm.collections;

import com.solvd.lawfirm.entity.crimes.AbstractCrime;
import com.solvd.lawfirm.entity.crimes.HomicideCrime;
import com.solvd.lawfirm.entity.crimes.HooliganismCrime;
import com.solvd.lawfirm.entity.crimes.RobberyCrime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CrimeHashMap {

    public Map<String, AbstractCrime> createCrimeHashMap() {
        Map<String, AbstractCrime> crimeHashMap = new HashMap<>();
        HomicideCrime homicideCrime = new HomicideCrime();
        RobberyCrime robberyCrime = new RobberyCrime();
        HooliganismCrime hooliganismCrime = new HooliganismCrime();
        crimeHashMap.put(homicideCrime.getTypeOfCrime(), homicideCrime);
        crimeHashMap.put(robberyCrime.getTypeOfCrime(), robberyCrime);
        crimeHashMap.put(hooliganismCrime.getTypeOfCrime(), hooliganismCrime);
        return crimeHashMap;
    }
    public AbstractCrime findCrime(Map<String, AbstractCrime> crimeHashMap, String typeOfCrime) throws Exception {
        Set<Map.Entry<String, AbstractCrime>> entries = crimeHashMap.entrySet();
        for (Map.Entry<String, AbstractCrime> entry : entries) {
            if (typeOfCrime.equals(entry.getValue().getTypeOfCrime())) {
                return entry.getValue();
            }
        }
        throw new Exception("Cannot find crime");
    }
}
