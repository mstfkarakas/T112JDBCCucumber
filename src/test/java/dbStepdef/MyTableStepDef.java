package dbStepdef;

import dbUtils.DbUtils;
import dbUtils.SqlQueries;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MyTableStepDef {

    DbUtils dbUtils = new DbUtils();
    SqlQueries sqlQueries = new SqlQueries();
    List<Object> dataList = new ArrayList<>();

    @Then("List the {string} data in the MyTable")
    public void list_the_data_in_the_my_table(String email) {
        dataList = dbUtils.getColumnData(sqlQueries.generalViewTable("myTable"),email);

    }
    @Then("Verify the {string} in the MyTable")
    public void verify_the_in_the_my_table(String email) {
        Assert.assertTrue(dataList.contains(email));
    }

    @Then("List the {string} tables columns name")
    public void list_the_tables_columns_name(String myTable) {
        dataList  = dbUtils.getColumnNames(sqlQueries.generalViewTable(myTable));
        System.out.println(dataList);
    }
    @Then("Verify the {string} in the MyTable table")
    public void verify_the_in_the_my_table_table(String MyTableColumnName) {
        Assert.assertTrue(dataList.contains(MyTableColumnName));
    }




}
