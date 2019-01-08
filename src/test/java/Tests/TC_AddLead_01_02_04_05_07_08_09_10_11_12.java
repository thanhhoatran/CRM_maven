package Tests;

import Actions.AddLeadCRMAction;
import Actions.LoginCRMAction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TC_AddLead_01_02_04_05_07_08_09_10_11_12 {
    WebDriver driver;
    Properties user = new Properties();
    Properties customer = new Properties();
    InputStream input = null;
    String dynamicname = "Thanh Hoa";
    String dynamicCreate = "Create Customer";
    String dynamicNameField = "Name";
    String dynamicEmailField = "Email";
    String dynamicPhoneField = "Phone";
    String dynamicAddressField = "Address";
    Integer row=189;
    @Before

    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ".\\src\\Resources\\Drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //vô hiệu hóa thông báo chrome
        driver = new ChromeDriver(options);
        driver.get("http://113.176.100.130:8080/CRMweb/faces/login.xhtml");
        driver.manage().window().maximize();

        try
        {
            input = new FileInputStream("user.txt");
            user.load(input);
            input = new FileInputStream("customer.txt");
            customer.load(input);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    //Summary: Verify that "Create Customer" page opens after User clicks on "Create Customer" link of "Customer" menu.
    public void TC_AddLead_01() throws InterruptedException {
        //Preconditions:  Navigate to Home Page  after logging-in successfully.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        //Step1. Cick on Customers menu.
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        //Step2. Click on Create Customer link.
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);

        //Expected Result: Create Customer page open.
        String CreatePageXpath = "//h2[text()='"+dynamicCreate+"']";
        boolean isCreatePage = driver.findElement(By.xpath(CreatePageXpath)).isDisplayed();
        Assert.assertEquals(true,isCreatePage);
    }

    @Test
    //Summary: Verify that "Add Customer" form in "Customer" page include "Name, Email,Phone,Address" field.
    public void TC_AddLead_02() throws InterruptedException {
        //Preconditions:  Navigate to Home Page  after logging-in successfully.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        //Step1. Cick on Customers menu.
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        //Step2. Click on Create Customer link.
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);

        //Expected Result: "Add Customer" form in "Customer" page include "Name, Email,Phone,Address" field.
        String NameFieldXpath = "//label[text()='"+dynamicNameField+"']";
        boolean isNameField = driver.findElement(By.xpath(NameFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isNameField);

        String EmailFieldXpath = "//label[text()='"+dynamicEmailField+"']";
        boolean isEmailField = driver.findElement(By.xpath(EmailFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isEmailField);

        String PhoneFieldXpath = "//label[text()='"+dynamicPhoneField+"']";
        boolean isPhoneField = driver.findElement(By.xpath(PhoneFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isPhoneField);

        String AddressFieldXpath = "//label[text()='"+dynamicAddressField+"']";
        boolean isAddressField = driver.findElement(By.xpath(AddressFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isAddressField);
    }

    @Test
    //*Summary:  Verify that User can Add customer successfully
    //          with valid data and this customer information displays in "Customer List" table
    public void TC_AddLead_04() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. Enter valid data into all field
        AddLeadCRMAction.enterInfoAddCustomer(driver, customer.getProperty("name"),customer.getProperty("email"),customer.getProperty("phone"),customer.getProperty("address"));
        //Step2. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);
        AddLeadCRMAction.clickOnEndPageButton(driver);
        Thread.sleep(1000);


        //Expected Result:
        String EmailFieldXpath = "//tbody[@id='j_idt12:tbl_data']//tr[@data-ri='"+row+"']//td[text()='"+customer.getProperty("email")+"']";
        boolean isEmailField = driver.findElement(By.xpath(EmailFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isEmailField);
    }

    @Test
    //Summary: Verify that  "The email is not valid (ex: abc@abc)" message displays above "Email" field when User add customer on"Create Customer" page with invalid email.
    public void TC_AddLead_05() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. 1. Enter invalid email into "Email" field (E.G: 123123)
        AddLeadCRMAction.enterInfoAddCustomer(driver, customer.getProperty("name"),"123123",customer.getProperty("phone"),customer.getProperty("address"));
        //Step2. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "The email is not valid (ex: abc@abc)" message displays above "Email" field
        String EmailFieldXpath = "//span[text()='The email is not valid (ex: abc@abc)']";
        boolean isEmailField = driver.findElement(By.xpath(EmailFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isEmailField);
    }

    @Test
    //Summary:  Verify that "Only numbers 0-9" message displays above "Phone" field
    //          when User add customer on "Create Customer" page with invalid phone numbers .
    public void TC_AddLead_07() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //StepEnter invalid data into "Phone" filed (E.G: qwe123)
        AddLeadCRMAction.enterInfoAddCustomer(driver, customer.getProperty("name"),customer.getProperty("email"),"qwe123",customer.getProperty("address"));
        //Step2. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "Only numbers 0-9" message displays above "Phone" field
        String PhoneFieldXpath = "//span[text()='Only numbers 0-9']";
        boolean isPhoneField = driver.findElement(By.xpath(PhoneFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isPhoneField);
    }

    @Test
    //Summary:  Verify that "Please enter your name" message displays above "Name" field
    //          when User leaving "Name" field is blank on "Create Customer" page
    public void TC_AddLead_08() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "Please enter your name" message displays above "Name" field
        String NameFieldXpath = "//span[text()='Please enter your name']";
        boolean isNameField = driver.findElement(By.xpath(NameFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isNameField);
    }

    @Test
    //Summary:  Verify that "Please enter your email" message displays above "Email" field
    //          when User leaving "Email" field is blank on "Create Customer" page
    public void TC_AddLead_09() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "Please enter your email" message displays above "Email" field
        String EmailFieldXpath = "//span[text()='Please enter your email']";
        boolean isEmailField = driver.findElement(By.xpath(EmailFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isEmailField);
    }

    @Test
    //Summary:  Verify that "Please enter your phone" message displays above "Phone" field
    //          when User leaving "Phone" field is blank on "Create Customer" page
    public void TC_AddLead_10() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "Please enter your phone" message displays above "Phone" field
        String PhoneFieldXpath = "//span[text()='Please enter your phone']";
        boolean isPhoneField = driver.findElement(By.xpath(PhoneFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isPhoneField);
    }

    @Test
    //Summary:  Verify that "Please enter your address" message displays above "Address" field
    //          when User leaving "Address" field is blank on "Create Customer" page
    public void TC_AddLead_11() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "Please enter your address" message displays above "Address" field
        String AddressFieldXpath = "//span[text()='Please enter your address']";
        boolean isAddressField = driver.findElement(By.xpath(AddressFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isAddressField);
    }

    @Test
    //Summary:  Verify that "That email is taken.Try another" message displays above "Email" field
    //          when entering email exists into "Email" field on "Create Customer" page
    //BUG: CMR_Lead Management –Add a New Lead_03
    public void TC_AddLead_12() throws InterruptedException {
        //Preconditions:  "Create Customer" page is opened.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        AddLeadCRMAction.clickOnCustomerMenu(driver);
        Thread.sleep(1000);
        AddLeadCRMAction.clickOnCreateCustomerMenu(driver);
        //Step1. Enter a email exists into "Email" filed
        AddLeadCRMAction.enterInfoAddCustomer(driver, customer.getProperty("name"),customer.getProperty("email"),customer.getProperty("phone"),customer.getProperty("address"));
        //Step2. Click on "Create Customer" button
        AddLeadCRMAction.clickOnCreateButton(driver);

        //Expected Result: "That email is taken.Try another." message displays above "Email" field
        String EmailFieldXpath = "//span[text()='That email is taken.Try another.']";
        boolean isEmailField = driver.findElement(By.xpath(EmailFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isEmailField);
    }
}
