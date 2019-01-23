package Tests;

import Actions.CRMEditLead_action;
import Actions.CRMLogin_action;
import Actions.CRMSearchLead_action;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_EditLead_27_28_30_31_32_33_34_35 {
    WebDriver driver;
    String email = "tokyoken@gmail.com";
    String pass = "15091992h";
    String textname = "van luat";
    String emailChange = "123123";
    String phoneChange = "qwe123";
    String emailExist = "tokyoken@gmail.com";
    String textchangeaddress = "160 Dong Da";

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\Resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://crmweb.ddns.net");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    //Summary:Verify that "Edit Customer" page displays after searching then clicking on Edit button
    // of each result in "Customer List"table and User can edit customer successfully with valid data
    //BUG: Missing "Edit" column is located on the right "Phone" column in "Customers List" table
    public void TC_Edit_27(){
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        //Step1: Enter a name or a part of name into "Name" field
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Step2: Click on any "Edit" button of "Customer List" table
        driver.findElement(By.xpath("//a[contains(.,'Edit')]")).click();
        //Step3: Enter valid data into all field
        CRMSearchLead_action.deleteAddress(driver);
        CRMSearchLead_action.enterChangeAddress(driver,textchangeaddress);
        //Step4: Click on "Save" button
        CRMSearchLead_action.clickBtnSave(driver);
        //Step5: Observed "Customer Information" form
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //Expected Result: User can edit customer information successfully
        // and new information displays in "Customer Information" form
        WebElement changeAddress = driver.findElement(By.xpath("//span[contains(.,'"+textchangeaddress+"')]"));
        Assert.assertTrue(changeAddress.isDisplayed());
    }
    @Test
    // Summary: Verify that "The email is not valid (ex: abc@abc)" message displays above "Email" field
    // when User edit customer information in "Edit Customer" page with invalid email
    public void TC_Edit_28()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1: Enter invalid email into "Email" field
        CRMEditLead_action.deleteEmail(driver);
        CRMEditLead_action.enterEmail(driver,emailChange);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "The email is not valid (ex: abc@abc)" message displays above "Email" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'The email is not valid (ex: abc@abc)')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    // Summary: Verify that "Only numbers 0-9" message displays above "Phone" field
    // when User edit customer information in "Edit Customer" page with invalid phone numbers
    public void TC_Edit_30()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1:  Enter invalid data into "Phone" filed
        //(E.G: qwe123)
        CRMEditLead_action.deletePhone(driver);
        CRMEditLead_action.enterPhone(driver,phoneChange);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "Only numbers 0-9" message displays above "Phone" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Only numbers 0-9')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    //Summary: Verify that "Please enter your name" message displays above "Name" field
    // when User leaving "Name" field is blank in "Edit Customer" page
    public void TC_Edit_31()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1: Delete data into "Name" field
        CRMEditLead_action.deleteName(driver);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "Please enter your name" message displays above "Name" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your name')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    //Summary: Verify that "Please enter your email" message displays above "Email" field
    // when User leaving "Email" field is blank in "Edit Customer" page
    public void TC_Edit_32()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1: Delete data into "Email" field
        CRMEditLead_action.deleteEmail(driver);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "Please enter your email" message displays above "Email" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your email')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    //Summary: Verify that "Please enter your phone" message displays above "Phone" field
    // when User leaving "Phone" field is blank in "Edit Customer" page
    public void TC_Edit_33()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1: Delete data into "Phone" field
        CRMEditLead_action.deletePhone(driver);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "Please enter your phone" message displays above "Phone" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your phone')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    //Summary: Verify that  "Please enter your address" message displays above "Address" field
    // when User leaving "Address" field is blank in "Edit Customer" page
    public void TC_Edit_34()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1: Delete data into "Address" field
        CRMEditLead_action.deleteAddress(driver);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "Please enter your address" message displays above "Address" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your address')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    //Summary: Verify that "That email is taken.Try another" message displays above "Email" field
    // when entering email exists into "Email" field on "Edit Customer" page
    //BUG: Missing "That email is taken.Try another" message displays above "Email" field
    // when entering email exists into "Email" field on "Edit Customer" page
    public void TC_Edit_35()  {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMEditLead_action.clickBtnEdit(driver);

        //Step1: Enter a email exists into "Email" filed
        CRMEditLead_action.deleteEmail(driver);
        CRMEditLead_action.enterEmail(driver,emailExist);
        //Step2: Click on "Save" button
        CRMEditLead_action.clickBtnSave(driver);
        //Expected Result: "That email is taken.Try another" message displays above "Email" field
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'That email is taken.Try another')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
}
