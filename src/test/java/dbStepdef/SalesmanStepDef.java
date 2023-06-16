package dbStepdef;

import dbUtils.DbUtils;
import dbUtils.SqlQueries;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SalesmanStepDef {

    DbUtils dbUtils = new DbUtils();
    SqlQueries sqlQueries = new SqlQueries();
    List<Object> dataSalesmanTable = new ArrayList<>();

    // actually this method return a list
    // this method ==>> dbUtils.getColumnData(sqlQueries.columnSalesmanTable(salesman_id),salesman_id);
    // but java says that you should assign to another list, thats why we created a list with name
    // dataSalesmanTable and we assigned on this list
    @Given("Connection to the database")
    public void connection_to_the_database() {
        dbUtils.createConnection();
    }

    @Then("List the {string} in the salesman_id column")
    public void list_the_in_the_salesman_id_column(String salesman_id) {
        dataSalesmanTable = dbUtils.getColumnData(sqlQueries.columnSalesmanTable(salesman_id), salesman_id);
        // sqlQueries.columnSalesmanTable(salesman_id),salesman_id) in this method we called
        // only salesman_id column and we have checked salesman_id column only

    }

    @Then("Verify the {int}")
    public void verify_the(Integer salesman_id) {
        Assert.assertTrue(dataSalesmanTable.contains(salesman_id));
    }

    @Then("Close the connection to the database")
    public void close_the_connection_to_the_database() {
        dbUtils.closeConnection();
    }

    @Then("List the {string} in the salesman table")
    public void list_the_in_the_salesman_table(String firstname) {
        dataSalesmanTable = dbUtils.getColumnData(sqlQueries.generalViewTable("salesman"), firstname);
        // we called all columns of in the salesman table but we have checked only firstname column

    }

    @Then("Verify the {string}")
    public void verify_the(String firstname) {
        Assert.assertTrue(dataSalesmanTable.contains(firstname));
    }

    @Then("List the {string} data")
    public void list_the_data(String city) {
        dataSalesmanTable = dbUtils.getColumnData(sqlQueries.generalViewTable("salesman"), city);
    }

    @Then("Verify {string}")
    public void verify(String city) {
        Assert.assertTrue(dataSalesmanTable.contains(city));
    }

    @Then("List the {string} data in the salesman")
    public void list_the_data_in_the_salesman(String earning) {
        dataSalesmanTable = dbUtils.getColumnData(sqlQueries.generalViewTable("salesman"), earning);

    }

    @Then("Verify {int}")
    public void verify(Integer earning) {
        Assert.assertTrue(dataSalesmanTable.contains(earning));
    }

    @Then("List the {string}")
    public void list_the(String companyName) {
        dataSalesmanTable = dbUtils.getColumnData(sqlQueries.generalViewTable("salesman"), companyName);

    }

    @Then("Verify {string} in the salesman table")
    public void verify_in_the_salesman_table(String companyName) {
        Assert.assertTrue(dataSalesmanTable.contains(companyName));
    }
}
