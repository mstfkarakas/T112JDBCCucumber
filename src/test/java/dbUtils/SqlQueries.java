package dbUtils;

public class SqlQueries {

    public String columnSalesmanTable(String columnName){

        return   "select "+columnName+" from salesman";
    /* OR
        String query = "select "+columnName+" from salesman";
        return query;
    */

    }

    public String generalViewTable(String tableName){

        return   "select * from "+ tableName;
    }
}
