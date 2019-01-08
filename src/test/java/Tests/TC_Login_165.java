package Tests;

import Actions.LoginCRMAction;
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

public class TC_Login_165 {
    WebDriver driver;
    Properties user = new Properties();
    InputStream input = null;
    String dynamicname = "Thanh Hoa";
    @BeforeClass
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
            input = new FileInputStream("src/user.txt");
            user.load(input);
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
    //Summary: Verify that the Home page is displayed when the user successfully logs in with the registered account.
    public void TC_Login_165() throws InterruptedException {
        //Step1:  Enter all valid data in all field of Login form.
        LoginCRMAction.enterUsernameAndPassword(driver,user.getProperty("userid"),user.getProperty("password"));
        //Step3: Click on Login button.
        LoginCRMAction.clickOnLoginButton(driver);
        //Expected Result: Navigate to Homepage.
        String LoginUserXpath = "//a[text()=\""+dynamicname+"\"]";
        boolean isLogin = driver.findElement(By.xpath(LoginUserXpath)).isDisplayed();
        Assert.assertEquals(true,isLogin);
    }
}