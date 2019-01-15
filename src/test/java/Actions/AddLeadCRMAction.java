package Actions;

import Pages.AddLeadCRMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddLeadCRMAction {
    public static  void clickOnCustomerMenu(WebDriver driver)
    {
        driver.findElement(By.xpath(AddLeadCRMPage.btnCustomer)).click();
       // driver.findElement(By.xpath(AddLeadCRMPage.btnCreateCustomer)).click();
    }
    public static  void clickOnCreateCustomerMenu(WebDriver driver)
    {
       // driver.findElement(By.xpath(AddLeadCRMPage.btnCustomer)).click();
        driver.findElement(By.xpath(AddLeadCRMPage.btnCreateCustomer)).click();
    }
    public static void enterInfoAddCustomer(WebDriver driver, String name, String email, String phone, String address)
    {
        driver.findElement(By.xpath(AddLeadCRMPage.txtName)).sendKeys(name);
        driver.findElement(By.xpath(AddLeadCRMPage.txtEmail)).sendKeys(email);
        driver.findElement(By.xpath(AddLeadCRMPage.txtPhone)).sendKeys(phone);
        driver.findElement(By.xpath(AddLeadCRMPage.txtAddress)).sendKeys(address);
    }
    public static  void clickOnCreateButton(WebDriver driver)
    {
        driver.findElement(By.xpath(AddLeadCRMPage.btnCreate)).click();
    }

    public static void enterSearchCustomer(WebDriver driver, String name, String email, String address, String phone)
    {
        driver.findElement(By.xpath(AddLeadCRMPage.txtSearchName)).sendKeys(name);
        driver.findElement(By.xpath(AddLeadCRMPage.txtSearchEmail)).sendKeys(email);
        driver.findElement(By.xpath(AddLeadCRMPage.txtSearchAddress)).sendKeys(address);
        driver.findElement(By.xpath(AddLeadCRMPage.txtSearchPhone)).sendKeys(phone);

    }
    public static  void clickOnEndPageButton(WebDriver driver)
    {
        driver.findElement(By.xpath(AddLeadCRMPage.btnEndPage)).click();
    }
}
