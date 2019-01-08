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

public class TC_EditLead_ {
    WebDriver driver;
    String email = "tokyoken@gmail.com";
    String pass = "15091992h";
    String text = "abcd";
    String textname = "van luat";
    String emailChange = "123123";
    String phoneChange = "qwe123";
    String emailExist = "tokyoken@gmail.com";


    @BeforeClass
    public void preCondion(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://crmweb.ddns.net");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
    }
    @Test
    public void TC_Edit_27(){
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //BUG
        //Missing "Edit" column is located on the right "Phone" column in "Customers List" table
    }
    @Test
    public void TC_Edit_28()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deleteEmail(driver);
        CRMEditLead_action.enterEmail(driver,emailChange);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'The email is not valid (ex: abc@abc)')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    public void TC_Edit_30()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deletePhone(driver);
        CRMEditLead_action.enterPhone(driver,phoneChange);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Only numbers 0-9')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    public void TC_Edit_31()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deleteName(driver);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your name')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    public void TC_Edit_32()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deleteEmail(driver);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your email')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    public void TC_Edit_33()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deletePhone(driver);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your phone')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    public void TC_Edit_34()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deleteAddress(driver);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your address')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
    @Test
    public void TC_Edit_35()  {
        driver.navigate().to("http://113.176.100.130:8080/CRMweb/faces/editCustomer.xhtml?id=2054");
        CRMEditLead_action.clickBtnEdit(driver);
        CRMEditLead_action.deleteEmail(driver);
        CRMEditLead_action.enterEmail(driver,emailExist);
        CRMEditLead_action.clickBtnSave(driver);
        WebElement mssEmail = driver.findElement(By.xpath("//span[contains(.,'Please enter your email')]"));
        Assert.assertTrue(mssEmail.isDisplayed());
    }
}
