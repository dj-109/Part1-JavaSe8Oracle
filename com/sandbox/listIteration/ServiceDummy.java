package sandbox.listIteration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import sandbox.listIteration.DaoDummy;

public class ServiceDummy {

    DaoDummy daoDummy = new DaoDummy();
    DummyForm form = new DummyForm();

    /**
     * using form object instead of dao
     *
     * @return form header
     */
    public TreeSet<String> getHeader() {
        setForm();
        return form.getHeader();
    }

    /**
     * using form object instead of dao
     *
     * @return form body
     */
    public List<Map<String, Object>> getBody() {
        setForm();
        return form.getBody();
    }


    /**
     * we create a form object with all used parameters to call the database only one time
     * if the form object is already filled, it won't be recreated
     */
    private void setForm() {
        //call Dao
        List<Map<String, Object>> body;
        if (form.getBody() == null || form.getBody().isEmpty()) {
            body = daoDummy.getMapList();

            if (!body.isEmpty()) {

                System.out.println("HELL YEAH no NPE!");
                form.setBody(body);
                Map<String, Object> firstrow = getBody().get(0);
                TreeSet<String> header = new TreeSet<>();
                firstrow.forEach((k, v) -> header.add(k));

                form.setHeader(header);
            } else {
                System.out.println("Service: Error in setting Report Form caused by empty Dataset");
            }
        } else {
            System.out.println("Don't need to recreate the Form Object");
        }

    }
}