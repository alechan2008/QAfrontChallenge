package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class FilteredResultPage extends BasePage{
    public FilteredResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy( css = "article.PieceLayout-orsj2a-0.GKcLt")
    private List<WebElement> nameRefrigeratorLocator;

    @FindBy(css= ".breadcrumbstyled__List-vxt6er-2.dFbIgZ")
    private WebElement breadcumbLocator;

    public List<String> nameFridge(){
        getEwait().until(ExpectedConditions.visibilityOfAllElements(nameRefrigeratorLocator));

        List<String> nameEachFridge = new ArrayList<String>();
        WebElement selectedRefrigerator;
        for(int i =0 ; i< nameRefrigeratorLocator.size() ; i++){
            selectedRefrigerator = nameRefrigeratorLocator.get(i);
            nameEachFridge.add(selectedRefrigerator.findElement(By.cssSelector("h4")).getText());
        }
        return nameEachFridge;
        }
    public String breadCrumFunction(){
        getEwait().until(ExpectedConditions.visibilityOfAllElements(breadcumbLocator));
        String breadcumbName = breadcumbLocator.getText();
        return breadcumbName;
    }

}
