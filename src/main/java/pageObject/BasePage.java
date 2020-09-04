package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait ewait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        ewait = new WebDriverWait(driver, 5);
        this.driver = driver;
    }

    protected WebDriver getDriver() { return driver; }
    protected WebDriverWait getEwait() { return ewait; }

    public void dispose(){
        if(driver != null){
            driver.quit();
        }
    }
}
