package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = ".InputBar__SearchInput-t6v2m1-1.iJaFAt")
    private WebElement inputBarLocator;

    public void finderElement(String elementToFind){
        getEwait().until(ExpectedConditions.elementToBeClickable(inputBarLocator));
        inputBarLocator.click();
        inputBarLocator.sendKeys(elementToFind);
        inputBarLocator.sendKeys(Keys.ENTER);
    }



}
