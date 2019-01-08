package Actions;

import Pages.ViewLeadCRMPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewLeadCRMAction {
    public static  void clickOnNameButton(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.btnName)).click();
    }
    public static  void clickOnEditButton(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.btnEdit)).click();
    }
    public static void enterInfoEditCustomer(WebDriver driver, String name, String email, String phone, String address)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.txtName)).sendKeys(name);
        driver.findElement(By.xpath(ViewLeadCRMPage.txtEmail)).sendKeys(email);
        driver.findElement(By.xpath(ViewLeadCRMPage.txtPhone)).sendKeys(phone);
        driver.findElement(By.xpath(ViewLeadCRMPage.txtAddress)).sendKeys(address);
    }
    public static  void clickOnSaveButton(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.btnSave)).click();
    }
    public static  void clickOnAddOpportunityButton(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.btnAddOpp)).click();
    }
    public static  void clickOnCreateOpportunityButton(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.btnCreateOpp)).click();
    }
    public static  void clickOnOpportunityCheckBox(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.checkboxOpp)).click();
    }

    //xóa giá trị trong text field sử dụng clear()
    public static void clearInfoEditCustomer(WebDriver driver)
    {
        driver.findElement(By.xpath(ViewLeadCRMPage.txtName)).clear();
        driver.findElement(By.xpath(ViewLeadCRMPage.txtEmail)).clear();
        driver.findElement(By.xpath(ViewLeadCRMPage.txtPhone)).clear();
        driver.findElement(By.xpath(ViewLeadCRMPage.txtAddress)).clear();
    }
}
