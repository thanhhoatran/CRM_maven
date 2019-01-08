package Actions;

import Pages.LoginCRMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginCRMAction {
    public static void enterUsernameAndPassword(WebDriver driver, String username, String password)
    {
        driver.findElement(By.xpath(LoginCRMPage.txtUser)).sendKeys(username);
        driver.findElement(By.xpath(LoginCRMPage.txtPass)).sendKeys(password);
    }
    public static  void clickOnLoginButton(WebDriver driver)
    {
        driver.findElement(By.xpath(LoginCRMPage.btnLogin)).click();
    }
}
