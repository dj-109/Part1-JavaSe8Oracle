package sandbox.listIteration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import sandbox.listIteration.DaoDummy;

public class ServiceDummy {

    DaoDummy daoDummy = new DaoDummy();

    public TreeSet<String> getHeader() {
        Map<String, Object> firstrow = getBody().get(0);
        TreeSet<String> header = new TreeSet<>();
        if (firstrow.isEmpty()) {
            System.out.println("Nix drin");
        }
        // Unsorted
        firstrow.forEach((k, v) -> {
            header.add(k);
            System.out.println(" - " + k);
        });
        System.out.println("Service Got Header");
        return header;
    }

    public List<Map<String, Object>> getBody() {
        List<Map<String, Object>> body;
        body = daoDummy.getMapList();
        if (!body.isEmpty()) {
            System.out.println("Service Body-List successfully retrieved ");
        }
        return body;
    }
}