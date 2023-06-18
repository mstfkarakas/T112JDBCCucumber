package dbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {

    static String databaseUrl = "jdbc:mysql://localhost:3306/team112?serverTimezone=UTC";
    static String username = "root";
    static String password = "1604";

    static Statement statement;
    static Connection connection;
    static ResultSet resultSet;

    public void createConnection(){

        try {
            connection = DriverManager.getConnection(databaseUrl,username,password);
        }catch (SQLException e){
            System.out.println("The Connection to Database failed :"+e.getMessage());
        }
    }

    public static void executeQuery(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }catch (SQLException e){
            System.out.println("The Statement failed :"+e.getMessage());
        }
        try{
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println("The Query failed :"+e.getMessage());
        }
     /*
     TYPE_SCROLL_INSENSITIVE
     when using this type, the result set is scrollable, it means we can navigate forward abd backward through the rows
      */
    }

    public List<Object> getColumnData(String query, String columnName){
        executeQuery(query);
        List<Object> rowList = new ArrayList<>();
        try {
            while (resultSet.next()){
                rowList.add(resultSet.getObject(columnName));
            }
        }catch (SQLException e){
            System.out.println("Execution of the Query failed :" + e.getMessage());
        }
        return rowList;
    }

    public void closeConnection(){
        try{
            if(resultSet !=null){
                resultSet.close();
            }if(statement !=null){
                statement.close();
            }if(connection !=null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("The close method failed :" +e.getMessage());
        }
    }


    public static void updateQuery(String query) throws SQLException {

        int st = statement.executeUpdate(query);
        System.out.println(st);
    }

    public static synchronized void update(String query) throws SQLException {

        Statement st = connection.createStatement();
        int ok = st.executeUpdate(query);

        if (ok == -1) {
            throw new SQLException("DB problem with query: " + query);
        }
        st.close();
    }


    public static Connection getConnection() {
        String url = "";
        String username = "";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static Statement getStatement() {

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }


    public static ResultSet getResultSet() {

        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public static int getRowCount() throws SQLException {

        resultSet.last();
        int rowCount = resultSet.getRow();

        return rowCount;
    }

    public static Object getCellValue (String query) {
        return getQueryResultList(query).get(0).get(0);
    }

    public static List<Object> getRowList(String query) {
        return getQueryResultList(query).get(0);
    }

    public static Map<String, Object> getRowMap(String query) {
        return getQueryResultMap(query).get(0);

    }

    public static List<List<Object>> getQueryResultList(String query) {
        executeQuery(query);
        List<List<Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                List<Object> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(resultSet.getObject(i));
                }
                rowList.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowList;
    }

    public static List<Map<String, Object>> getQueryResultMap(String query) {
        executeQuery(query);
        List<Map<String, Object>> rowList = new ArrayList<>();
        ResultSetMetaData rsmd;

        try{
            rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> colNameValueMap = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    colNameValueMap.put(rsmd.getColumnName(i), resultSet.getObject(i));
                }
                rowList.add(colNameValueMap);
            }

        }catch (SQLException e) {
            e.printStackTrace();

        }
        return rowList;
    }

    public static List<String> getColumnNames (String query) {
        executeQuery(query);
        List<String> columns = new ArrayList<>();
        ResultSetMetaData rsmd;

        try {
            rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columns.add(rsmd.getColumnName(i));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return columns;
    }

    public static void printResultSet (ResultSet resultSet) {

        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(metaData.getColumnName(i) + ": " + resultSet.getString(i) + " ");
                }
                System.out.println();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}