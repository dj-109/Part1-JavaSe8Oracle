package sandbox.listIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaoDummy {

    public List<Map<String, Object>> getMapList() {
        System.out.println("DAO - working on sth");
        List<Map<String, Object>> dummyListMap = new ArrayList<>();
        int i = 0;
        dummyListMap.add(i, getDennis());
        dummyListMap.add(++i, getMiri());
        dummyListMap.add(++i, getSpencer());
        dummyListMap.add(++i, getMaggie());
        dummyListMap.add(++i, getMissMarple());

        return dummyListMap;
    }

    public Map<String, Object> getDennis() {
        Map<String, Object> fillHelper = new HashMap<>();
        fillHelper.put("Name", "Dennis");
        fillHelper.put("Alter", 28);
        fillHelper.put("Kurz", "D91");
        return fillHelper;
    }

    public Map<String, Object> getMiri() {
        Map<String, Object> fillHelper = new HashMap<>();
        fillHelper.put("Name", "Miri");
        fillHelper.put("Alter", 27);
        fillHelper.put("Kurz", "M92");
        return fillHelper;
    }

    public Map<String, Object> getSpencer() {
        Map<String, Object> fillHelper = new HashMap<>();
        fillHelper.put("Name", "Spencer");
        fillHelper.put("Alter", 5);
        fillHelper.put("Kurz", "S15");
        return fillHelper;
    }

    public Map<String, Object> getMaggie() {
        Map<String, Object> fillHelper = new HashMap<>();
        fillHelper.put("Name", "Maggie");
        fillHelper.put("Alter", 3);
        fillHelper.put("Kurz", "M17");
        return fillHelper;
    }

    public Map<String, Object> getMissMarple() {
        Map<String, Object> fillHelper = new HashMap<>();
        fillHelper.put("Name", "Miss-Marple");
        fillHelper.put("Alter", 3);
        fillHelper.put("Kurz", "MM17");
        return fillHelper;
    }

}
