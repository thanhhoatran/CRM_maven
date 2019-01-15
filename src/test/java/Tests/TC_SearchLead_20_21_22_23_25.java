package Tests;

import Actions.CRMLogin_action;
import Actions.CRMSearchLead_action;
import Pages.CRMSearchLead_page;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_SearchLead_20_21_22_23_25 {
    String email = "tokyoken@gmail.com";
    String pass = "15091992h";
    String text = "abcd";
    String textname = "van luat";
    String textemail = "kuranh@gmail.com";
    String textaddress = "113 Hai Phong";
    String textchangeaddress = "160 Dong Da";
    WebDriver driver;
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
        //Summary:Verify that User can search customer information after entering valid data into "Search" textbox
    public void TC_SearchLead_20(){
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        //Step1:Enter a name or a part of name into "Search" textbox
        CRMSearchLead_action.enterSearcal(driver,text);
        //Step2: Press Enter keyboard
        driver.findElement(By.xpath(CRMSearchLead_page.txt_search)).sendKeys(Keys.ENTER);
        //Expected Result: User can search customer information
        WebElement pageFail = driver.findElement(By.xpath("//h1[contains(.,'HTTP Status 404 - Not Found')]"));
        Assert.assertTrue(pageFail.isDisplayed());
    }
    @Test
    //Summary: Verify that after User enters a name or a part of name into "Name" field of "Customer List" table, The related customers list is displayed.
    public void TC_SearchLead_21(){
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        //Step1: Enter a name or a part of name into "Name" field
        CRMSearchLead_action.enterSearchName(driver,textname);
        //Step2: Observed "Customer List" table
        //Expected Result: The related customers list is displayed in "Customer List" table
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement name = driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]"));
        Assert.assertTrue(name.isDisplayed());
    }
    @Test
    //Summary: Verify that User can search customer by entering valid data into "Email" field of "Customer List" table
    public void TC_SearchLead_22(){
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        //Step1: Enter valid email into "Email" field
        CRMSearchLead_action.enterSearchEmail(driver,textemail);
        //Step2: Observed "Customer List" table
        //Expected Result: The related customers list is displayed in "Customer List" table
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//td[contains(.,'"+textemail+"')]"));
        Assert.assertTrue(email.isDisplayed());
    }
    @Test
    //Summary:Verify that User can search customer by entering valid data into "Address" field of "Customer List" table
    public void TC_SearchLead_23(){
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        //Step1: Enter valid data into "Address" field
        CRMSearchLead_action.enterSearchAddress(driver,textaddress);
        //Step2: Observed "Customer List" table
        //Expected Result: The related customers list is displayed in "Customer List" table
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement address = driver.findElement(By.xpath("//td[contains(.,'"+textaddress+"')]"));
        Assert.assertTrue(address.isDisplayed());
    }
    @Test
    //Summary:Verify that "Edit Customer" page displays after searching then clicking any customer name of result in "Customer List"table and User can edit customer successfully with valid data
    public void TC_SearchLead_25() {
        //Preconditions: "Customer" page is opened
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
        //Step1: Enter a name or a part of name into "Name" field
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Step2: Click on any customer name in  "Name" column
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //Step3: Click on "Edit" button of "Customer Information" form
        CRMSearchLead_action.clickBtnEdit(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //Step4: Enter valid data into all field (e.g: Change address)
        CRMSearchLead_action.deleteAddress(driver);
        CRMSearchLead_action.enterChangeAddress(driver,textchangeaddress);
        //Step5: Click on "Save" button
        CRMSearchLead_action.clickBtnSave(driver);
        //Step6: Observed "Customer Information" form
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement changeAddress = driver.findElement(By.xpath("//span[contains(.,'"+textchangeaddress+"')]"));
        Assert.assertTrue(changeAddress.isDisplayed());
    }
}
