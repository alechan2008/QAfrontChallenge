package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (css = "li:nth-child(1) li:nth-child(2) h4")
    private WebElement heladeraLocator;

    @FindBy (name = "viewAllBrands")
    private WebElement allBrandsPopUpLocator;

    public void clickFilterFunction(){
        getEwait().until(ExpectedConditions.elementToBeClickable(heladeraLocator));
        heladeraLocator.click();
    }

    public void clickAllBrandsPopUp(){
        getEwait().until(ExpectedConditions.elementToBeClickable(allBrandsPopUpLocator));
        allBrandsPopUpLocator.click();
    }



}
