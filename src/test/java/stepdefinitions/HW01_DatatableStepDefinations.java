package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.DatatablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExcelUtil;

import java.util.List;
import java.util.Map;

public class  HW01_DatatableStepDefinations {

    DatatablePage datatablePage = new DatatablePage();

    @Given("user is on the datatable page")
    public void user_is_on_the_datatable_page() {
        Driver.getDriver().get(ConfigReader.getProperty("datatable_url"));

    }
    @Given("user clicks new button")
    public void user_clicks_new_button() {
        datatablePage.newEnteryButton.click();

    }
    @Given("user enters first name {string}")
    public void user_enters_first_name(String string) {
        datatablePage.firstName.sendKeys(string);

    }
    @Given("user enters last name {string}")
    public void user_enters_last_name(String string) {
        datatablePage.lastName.sendKeys(string);

    }
    @Given("user enters position {string}")
    public void user_enters_position(String string) {
        datatablePage.position.sendKeys(string);

    }
    @Given("user enters office {string}")
    public void user_enters_office(String string) throws InterruptedException {
        datatablePage.office.sendKeys(string);
        Thread.sleep(1000);
    }

    @Given("user enters extension {string}")
    public void user_enters_extension(String string) {
        datatablePage.extension.sendKeys(string);

    }
    @Given("user enters start date {string}")
    public void user_enters_start_date(String string) {
        datatablePage.startDate.sendKeys(string);

    }
    @Given("user enters salary {string}")
    public void user_enters_salary(String string) {
        datatablePage.salary.sendKeys(string);

    }
    @Then("user clicks create button")
    public void user_clicks_create_button() {
        datatablePage.createButton.click();

    }
    @Then("user search first name {string}")
    public void user_search_first_name(String string) {
        datatablePage.search.sendKeys(string);

    }
    @Then("verifies that name fields contain first name")
    public void verifies_that_name_fields_contain_first_name() {
        Assert.assertEquals("Fatih Moonstar", datatablePage.searchResult.getText());
    }
    @Then("user close data table page")
    public void user_close_data_table_page() {
        Driver.closeDriver();
    }

    @When("user enters all fields")
    public void user_enters_all_fields(DataTable dataTable) throws InterruptedException {
        List<String> dataTableTest = dataTable.row(1);
        System.out.println(dataTableTest); //[Fatih, Moonstar, QA Automation Engineer, Frankfurt, 3846, 2022-08-21, 85000, Fatih]

        datatablePage.firstName.sendKeys(dataTableTest.get(0));

        datatablePage.lastName.sendKeys(dataTableTest.get(1));

        datatablePage.position.sendKeys(dataTableTest.get(2));

        datatablePage.office.sendKeys(dataTableTest.get(3));
        Thread.sleep(1000);

        datatablePage.extension.sendKeys(dataTableTest.get(4));

        datatablePage.startDate.sendKeys(dataTableTest.get(5));

        datatablePage.salary.sendKeys(dataTableTest.get(6));

        datatablePage.search.sendKeys(dataTableTest.get(7));
    }
    ExcelUtil excelUtil;
    List<Map<String, String>> testData;

    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("datatable_url"));
        datatablePage = new DatatablePage();

    }
    @When("user enters all fields with excel")
    public void user_enters_all_fields_with_excel(String SheetName) throws InterruptedException {
        String path ="./src/test/resources/testdata/dataTable.xlsx";
        String sheetName="datatable_fields_info";
        excelUtil= new ExcelUtil(path,sheetName);

        testData=excelUtil.getDataList();
        System.out.println(testData);

        for(Map<String,String> eachData : testData ){
            setUp();
            datatablePage.firstName.sendKeys(eachData.get("firstname"));
            datatablePage.lastName.sendKeys(eachData.get("lastname"));
            datatablePage.position.sendKeys(eachData.get("position"));
            datatablePage.office.sendKeys(eachData.get("office"));
            datatablePage.extension.sendKeys(eachData.get("extension"));
            datatablePage.startDate.sendKeys(eachData.get("startDate"));
            datatablePage.salary.sendKeys(eachData.get("salary"));
            datatablePage.search.sendKeys(eachData.get("search"));

        }
    }
}
