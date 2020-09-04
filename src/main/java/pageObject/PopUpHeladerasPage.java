package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.lang.Integer.parseInt;

public class PopUpHeladerasPage extends BasePage{
    public PopUpHeladerasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy ( css = ".fhkySw > div")
    private List<WebElement> ListBrandsLocator;

    @FindBy ( id = "apply")
    private WebElement applyFilterLocator;

    public String searchBrandFunction(){
        getEwait().until(ExpectedConditions.visibilityOfAllElements(ListBrandsLocator));
        String samsungBrand = null;

        for (WebElement element : ListBrandsLocator ) {
            if(element.getText().contains("Samsung (")){
                samsungBrand = element.getText();
                element.click();
            }
        }
        return samsungBrand;
    }

    public int frontEndItems(String samsungBrand){
        String count = samsungBrand.replaceAll("[^\\d.]","");
        int itemsPage = parseInt(count);
        System.out.println(itemsPage);
        return itemsPage;
    }

    public void applyFilter(){
        getEwait().until(ExpectedConditions.visibilityOfAllElements(applyFilterLocator));
        applyFilterLocator.click();
    }

}
