package sandbox.listIteration;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class ShowStuff {
    public static void main(String[] args) {
        ServiceDummy serviceDummy = new ServiceDummy();
        TreeSet<String> header = serviceDummy.getHeader();
        List<Map<String, Object>> body = serviceDummy.getBody();
        System.out.println("############################# working builder: -- ");
        workingBuilder(header, body);
        System.out.println("\n\n\n");
        System.out.println("+++++++++++++++++++++++++++++ not working builder: -- ");
 //       notWorkingBuilder(serviceDummy);
    }

    /**
     * not really not working but a little bit troubled in the for_loop
     *
     * @param serviceDummy is a dummy of the original service
     */
    private static void notWorkingBuilder(ServiceDummy serviceDummy) {
        StringBuilder buildHeader = new StringBuilder();
        StringBuilder buildBody = new StringBuilder();

        buildHeader.append("|| ");
        for (String headerElement : serviceDummy.getHeader()) {
            //System.out.println("Header: " + headerElement);
            // Fill the header columns layouted as Header
            buildHeader.append(" ");
            buildHeader.append(headerElement);
            buildHeader.append(" |");
        }
        buildHeader.append("|");


        for (Map<String, Object> singleRow : serviceDummy.getBody()) {
            // reset Column to first
            buildBody.append("|| ");
            for (String headerElement : serviceDummy.getHeader()) {
                //System.out.println("Header: " + headerElement);
                Object keyCellValue = singleRow.get(headerElement); // can be number or string
                if (keyCellValue == null) { // stored value in database can be null
                    keyCellValue = ""; // prevent NPE
                }
                //System.out.println("Body: " + keyCellValue.toString() + " type: " + keyCellValue.getClass());
                buildBody.append(" ");
                buildBody.append(keyCellValue);
                buildBody.append(" |");
            }
            buildBody.append("| \n");
        }
        System.out.println(buildHeader);
        System.out.println("_______________________________");
        System.out.println(buildBody);
    }

    private static void workingBuilder(TreeSet<String> header, List<Map<String, Object>> body) {
        StringBuilder buildHeader = new StringBuilder();
        StringBuilder buildBody = new StringBuilder();

        buildHeader.append("|| ");
        for (String headerElement : header) {
            // System.out.println("Header: " + headerElement);
            // Fill the header columns layouted as Header
            buildHeader.append(" ");
            buildHeader.append(headerElement);
            buildHeader.append(" |");
        }
        buildHeader.append("|");


        for (Map<String, Object> singleRow : body) {
            // reset Column to first
            buildBody.append("|| ");
            for (String headerElement : header) {
                //System.out.println("Header: " + headerElement);
                Object keyCellValue = singleRow.get(headerElement); // can be number or string
                if (keyCellValue == null) { // stored value in database can be null
                    keyCellValue = ""; // prevent NPE
                }
                //System.out.println("Body: " + keyCellValue.toString() + " type: " + keyCellValue.getClass());
                buildBody.append(" ");
                buildBody.append(keyCellValue);
                buildBody.append(" |");
            }
            buildBody.append("| \n");
        }
        System.out.println(buildHeader);
        System.out.println("_______________________________");
        System.out.println(buildBody);
    }
}
