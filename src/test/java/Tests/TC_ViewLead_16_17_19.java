package Tests;

import Actions.LoginCRMAction;
import Actions.ViewLeadCRMAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TC_ViewLead_16_17_19 {
    WebDriver driver;
    Properties user = new Properties();
    Properties customer = new Properties();
    Properties editcustomer = new Properties();
    InputStream input = null;
    String dynamicanyname="Nguyen Thi Thu Hien";
    String dynamicopp = "áo len";
    @BeforeClass
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //vô hiệu hóa thông báo chrome
        driver = new ChromeDriver(options);
        driver.get("http://113.176.100.130:8080/CRMweb/faces/login.xhtml");
        driver.manage().window().maximize();

        try
        {
            input = new FileInputStream("src/user.txt");
            user.load(input);
            input = new FileInputStream("src/customer.txt");
            customer.load(input);
            input = new FileInputStream("src/editcustomer.txt");
            editcustomer.load(input);
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
    //Summary: Verify that customer information displays when clicks on any customer name in "Name" column  of "Customer List" table
    public void TC_ViewLead_16() throws InterruptedException {
        //Preconditions:  "Customer" page is opened
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        //Step1.Click on any customer name in  "Name" column
        ViewLeadCRMAction.clickOnNameButton(driver);

        //Expected Result:  Customer information selected displays on "Customer" page
        String AnyNameXpath = "//span[text()='"+dynamicanyname+"']";
        boolean isAnyName = driver.findElement(By.xpath(AnyNameXpath)).isDisplayed();
        Assert.assertEquals(true,isAnyName);
    }

   @Test
    //Summary:  Verify that "Customer Information" form displays
    //          after User clicks on any customer name on "Name" column in "Customer List" table
    //          and User can edit customer information successfully with valid data
    public void TC_ViewLead_17() throws InterruptedException {
        //Preconditions:  Navigate to Home Page  after logging-in successfully.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        //Step1.Click on any customer name in  "Name" column
        ViewLeadCRMAction.clickOnNameButton(driver);
        //Step2. Click on "Edit" button of "Customer Information" form
        ViewLeadCRMAction.clickOnEditButton(driver);
        //Step3.Enter valid data into all field
        ViewLeadCRMAction.clearInfoEditCustomer(driver);   //xóa toàn bộ giá trị của các trường để nhập dữ liệu từ file vào
        ViewLeadCRMAction.enterInfoEditCustomer(driver, editcustomer.getProperty("name"),editcustomer.getProperty("email"),editcustomer.getProperty("phone"),editcustomer.getProperty("address"));
        //4. Click on "Save" button
        ViewLeadCRMAction.clickOnSaveButton(driver);

        //Expected Result:  - "Customer Information" form displays
        //                  - User can edit customer information successfully
        String EmailFieldXpath = "//span[text()='"+editcustomer.getProperty("email")+"']";
        boolean isEmailField = driver.findElement(By.xpath(EmailFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isEmailField);

        String PhoneFieldXpath = "//span[text()='"+editcustomer.getProperty("phone")+"']";
        boolean isPhoneField = driver.findElement(By.xpath(PhoneFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isPhoneField);

        String AddressFieldXpath = "//span[text()='"+editcustomer.getProperty("address")+"']";
        boolean isAddressField = driver.findElement(By.xpath(AddressFieldXpath)).isDisplayed();
        Assert.assertEquals(true,isAddressField);
    }

    @Test
    //Summary: Verify that User can add Opportunity of the customer successfully with valid data on "Opportunity' form of "Customer" page
    public void TC_ViewLead_19() throws InterruptedException {
        //Preconditions:  Navigate to Home Page  after logging-in successfully.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        LoginCRMAction.clickOnLoginButton(driver);
        //Step1.Click a any customer name in  "Name" column
        ViewLeadCRMAction.clickOnNameButton(driver);
        //Step2. Click on "Add Opportunity" button of "Opportunity" form
        ViewLeadCRMAction.clickOnAddOpportunityButton(driver);
        //Step3. Enter valid data into all field
        ViewLeadCRMAction.clickOnOpportunityCheckBox(driver);
        //Step4. Click on "Create opportunity" button
        ViewLeadCRMAction.clickOnCreateOpportunityButton(driver);

        //Expected Result: User can add Opportunity successfully and this displays in "Opportunity" form
        String CreatePageXpath = "//td[text()='"+dynamicopp+"']";
        boolean isCreatePage = driver.findElement(By.xpath(CreatePageXpath)).isDisplayed();
        Assert.assertEquals(true,isCreatePage);
    }
}
