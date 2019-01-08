package Actions;

import Pages.CRMEditLead_page;
import Pages.CRMSearchLead_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CRMEditLead_action {
    public static void enterSearchName(WebDriver driver, String textSearchName){
        driver.findElement(By.xpath(CRMSearchLead_page.txt_SearchName)).sendKeys(textSearchName);
    }
    public static void clickBtnEdit(WebDriver driver){
        driver.findElement(By.xpath(CRMEditLead_page.btn_Edit)).click();
    }
    public static void deleteName(WebDriver driver){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Name)).clear();
    }
    public static void deleteEmail(WebDriver driver){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Email)).clear();
    }
    public static void enterEmail(WebDriver driver, String emailChange){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Email)).sendKeys(emailChange);
    }
    public static void enterEmailExist(WebDriver driver, String emailExist){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Email)).sendKeys(emailExist);
    }
    public static void deleteAddress(WebDriver driver){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Address)).clear();
    }
    public static void deletePhone(WebDriver driver){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Phone)).clear();
    }
    public static void enterPhone(WebDriver driver, String phoneChange){
        driver.findElement(By.xpath(CRMEditLead_page.txt_Phone)).sendKeys(phoneChange);
    }
    public static void clickBtnSave(WebDriver driver){
        driver.findElement(By.xpath(CRMEditLead_page.btn_Save)).click();
    }

}
