package dbUtils;

public class SqlQueries {

    public String columnSalesmanTable(String columnName){
       return   "select "+columnName+" from salesman";
    }

    public String generalViewTable(String tableName){
        return   "select * from "+ tableName;
    }
}
