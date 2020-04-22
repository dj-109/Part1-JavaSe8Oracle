package sandbox.listIteration;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DummyForm {

    private TreeSet<String> header;
    private List<Map<String, Object>> body;
    private boolean filled;

    public TreeSet<String> getHeader() {
        return header;
    }

    public void setHeader(TreeSet<String> header) {
        this.header = header;
    }

    public List<Map<String, Object>> getBody() {
        return body;
    }

    public void setBody(List<Map<String, Object>> body) {
        this.body = body;
    }

    public boolean isStatus() {
        return filled;
    }

    public void setStatus(boolean status) {
        this.filled = status;
    }

}