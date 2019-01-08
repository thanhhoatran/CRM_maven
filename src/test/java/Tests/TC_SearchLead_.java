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

public class TC_SearchLead_ {
    String email = "tokyoken@gmail.com";
    String pass = "15091992h";
    String text = "abcd";
    String textname = "van luat";
    String textemail = "kuranh@gmail.com";
    String textaddress = "113 Hai Phong";
    String textchangeaddress = "160 Dong Da";
    WebDriver driver;
    @BeforeClass
    public void preCondion(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://crmweb.ddns.net");
        System.out.println(driver.getTitle());
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        CRMLogin_action.enterEmail_Pass(driver,email,pass);
        CRMLogin_action.clickButtonLogin(driver);
    }
    @Test
    public void TC_SearchLead_20(){
        CRMSearchLead_action.enterSearcal(driver,text);
        driver.findElement(By.xpath(CRMSearchLead_page.txt_search)).sendKeys(Keys.ENTER);
        WebElement pageFail = driver.findElement(By.xpath("//h1[contains(.,'HTTP Status 404 - Not Found')]"));
        Assert.assertTrue(pageFail.isDisplayed());
    }
    @Test
    public void TC_SearchLead_21(){
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement name = driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]"));
        Assert.assertTrue(name.isDisplayed());
    }
    @Test
    public void TC_SearchLead_22(){
        CRMSearchLead_action.enterSearchEmail(driver,textemail);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement email = driver.findElement(By.xpath("//td[contains(.,'"+textemail+"')]"));
        Assert.assertTrue(email.isDisplayed());
    }
    @Test
    public void TC_SearchLead_23(){
        CRMSearchLead_action.enterSearchAddress(driver,textaddress);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement address = driver.findElement(By.xpath("//td[contains(.,'"+textaddress+"')]"));
        Assert.assertTrue(address.isDisplayed());
    }
    @Test
    public void TC_SearchLead_25() {
        CRMSearchLead_action.enterSearchName(driver,textname);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[contains(.,'"+textname+"')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMSearchLead_action.clickBtnEdit(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        CRMSearchLead_action.deleteAddress(driver);
        CRMSearchLead_action.enterChangeAddress(driver,textchangeaddress);
        CRMSearchLead_action.clickBtnSave(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        WebElement changeAddress = driver.findElement(By.xpath("//span[contains(.,'"+textchangeaddress+"')]"));
        Assert.assertTrue(changeAddress.isDisplayed());
    }
}
