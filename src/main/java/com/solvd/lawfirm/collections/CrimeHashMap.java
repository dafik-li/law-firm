/*package com.solvd.lawfirm.collections;

//import com.solvd.lawfirm.entity.crimes.AbstractCrime;
//import com.solvd.lawfirm.entity.crimes.HooliganismCrime;
//import com.solvd.lawfirm.entity.crimes.RobberyCrime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CrimeHashMap {

    public Map<String, EnumCrime> createCrimeHashMap() {
        Map<String, EnumCrime> crimeHashMap = new HashMap<>();
        EnumCrime homicide = EnumCrime.HOMICIDE;
        //HomicideCrime homicideCrime = new HomicideCrime();
        EnumCrime robbery = EnumCrime.ROBBERY;
        //RobberyCrime robberyCrime = new RobberyCrime();
        EnumCrime hooliganism = EnumCrime.HOOLIGANISM;
        //HooliganismCrime hooliganismCrime = new HooliganismCrime();
        crimeHashMap.put(homicide.getTypeOfCrime(), homicide);
        crimeHashMap.put(robbery.getTypeOfCrime(), robbery);
        crimeHashMap.put(hooliganism.getTypeOfCrime(), hooliganism);
        return crimeHashMap;
    }
    public EnumCrime findCrime(Map<String, EnumCrime> crimeHashMap, String typeOfCrime) throws Exception {
        Set<Map.Entry<String, EnumCrime>> entries = crimeHashMap.entrySet();
        for (Map.Entry<String, EnumCrime> entry : entries) {
            if (typeOfCrime.equals(entry.getValue().getTypeOfCrime())) {
                return entry.getValue();
            }
        }
        throw new Exception("Cannot find crime");
    }
}
 */

