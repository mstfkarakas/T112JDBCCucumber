package dbUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbUtils {

    static String databaseUrl = "jdbc:mysql://localhost:3306/team112?serverTimezone=UTC";
    static String username = "root";
    static String password = "ervanaz2012";

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








}
