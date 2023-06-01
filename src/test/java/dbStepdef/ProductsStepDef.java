package dbStepdef;

import dbUtils.DbUtils;
import dbUtils.SqlQueries;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductsStepDef {

    DbUtils dbUtils = new DbUtils();

    int actualData;

    @Given("Bring the sum of price from {string} column in the {string} table")
    public void bring_the_sum_of_price_from_column_in_the_table(String columnName, String tableName) {
        actualData = dbUtils.sumOfColumnData(columnName, tableName);
        System.out.println("The sum of price is "+actualData);
    }

    @Then("Verify the expected price that is {int} in the products table")
    public void verify_the_expected_price_that_is_in_the_products_table(int expectedPrice) {
        Assert.assertEquals(expectedPrice, actualData);
    }
}
