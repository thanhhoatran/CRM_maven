package Actions;

import Pages.CRMSearchLead_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMSearchLead_action {
    public static void enterSearcal(WebDriver driver, String textSearch){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_search)).sendKeys(textSearch);
    }
    public static void enterSearchName(WebDriver driver, String textSearchName){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_SearchName)).sendKeys(textSearchName);
    }
    public static void enterSearchEmail(WebDriver driver, String textSearchEmail){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_SearchEmail)).sendKeys(textSearchEmail);
    }
    public static void enterSearchAddress(WebDriver driver, String textSearchAddress){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_SearchAddress)).sendKeys(textSearchAddress);
    }
    public static void clickBtnEdit(WebDriver driver){
        driver.findElement(By.xpath(CRMSearchLead_page.btn_Edit)).click();
    }
    public static void deleteAddress(WebDriver driver){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_Address)).clear();
    }
    public static void enterChangeAddress(WebDriver driver, String changeAddress){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_Address)).sendKeys(changeAddress);
    }
    public static void clickBtnSave(WebDriver driver){
        driver.findElement(By.xpath(CRMSearchLead_page.btn_Save)).click();
    }
    public static void clickmenuShowAllCustomer(WebDriver driver){
        driver.findElement(By.xpath(CRMSearchLead_page.menu_Customer)).click();
        driver.findElement(By.xpath(CRMSearchLead_page.menuitem_ShowAllCustomer)).click();
    }
}
