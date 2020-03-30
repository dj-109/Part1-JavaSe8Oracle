package sandbox.stringUtils;

public class Replace {
    public static void main(String[] args) {
        String query = "Select * from :phTablename where :phRunId = :runId";

        String runId = "15400";
        String tableName = "TBL_Gesellschaften";
        String queryRunId = "runId";

        query = query.replaceAll(":phTablename", tableName);
        System.out.println(query);
        query = query.replace(":phRunId", queryRunId);
        System.out.println(query);
        query = query.replace(":runId",runId);
        System.out.println("final: ");
        System.out.println(query);

    }

}
