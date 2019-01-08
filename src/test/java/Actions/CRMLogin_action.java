package Actions;

import Pages.CRMLogin_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMLogin_action {
    public static void enterEmail_Pass(WebDriver driver, String email, String pass){
        driver.findElement(By.xpath(CRMLogin_page.txt_email)).sendKeys(email);
        driver.findElement(By.xpath(CRMLogin_page.txt_pass)).sendKeys(pass);
    }

    public static void clickButtonLogin(WebDriver driver){
        driver.findElement(By.xpath(CRMLogin_page.btn_Login)).click();
    }
}
