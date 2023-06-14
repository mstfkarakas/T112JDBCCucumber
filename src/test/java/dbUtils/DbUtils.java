package dbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            System.out.println("The Connecion Database is Fail :"+e.getMessage());
        }
    }

    public void executeQuery(String query){
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }catch (SQLException e){
            System.out.println("The Statement is Fail :"+e.getMessage());
        }
        try{
            resultSet = statement.executeQuery(query);
        }catch (SQLException e){
            System.out.println("The Query is Fail :"+e.getMessage());
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
            System.out.println("Execution of the Query is Fail :"+e.getMessage());
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
            System.out.println("The close method is fail :"+e.getMessage());
        }
    }

    public List<Object> getColumnNames(String query){
        executeQuery(query);
        List<Object> columns = new ArrayList<>();
        ResultSetMetaData metada;
        try {
            metada = resultSet.getMetaData();
            int columnCount = metada.getColumnCount();
            for(int i = 1; i<=columnCount; i++){
                columns.add(metada.getColumnName(i));
            }
        }catch (SQLException e){
            System.out.println("The Columns Couldnt Find "+e.getMessage());
        }
        return columns;
    }

     public int sumOfColumnData(String columnName, String tableName){
        String query = "select sum("+columnName+") from "+tableName;
        executeQuery(query);
        int sum = 0 ;
        try {
            if(resultSet.next()){ // no need for 'while' since there is only one cell value,
                                  // and SQL can add values in a column 68688 USD
                sum = resultSet.getInt(1); // it returns integer like salary/earning
            }
        }catch (SQLException e){
            System.out.println("Failed to Retrieve the Sum of Column Data "+e.getMessage());
        }
        return sum;
     }


}
