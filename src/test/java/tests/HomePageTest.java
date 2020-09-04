package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.FilteredResultPage;
import pageObject.PopUpHeladerasPage;
import pageObject.SearchPage;

import java.util.List;

public class HomePageTest extends BaseTest{

    @Test
    @Parameters({"elementToFind"})
    public void fravegaTest(String elementToFind){

        homePage.finderElement(elementToFind);

        SearchPage searchPage = new SearchPage(myDriver.getDriver());
        searchPage.clickFilterFunction();
        searchPage.clickAllBrandsPopUp();

        PopUpHeladerasPage popUpHeladerasPage = new PopUpHeladerasPage((myDriver.getDriver()));
        int items = popUpHeladerasPage.frontEndItems(popUpHeladerasPage.searchBrandFunction());
        popUpHeladerasPage.applyFilter();

        FilteredResultPage filteredResultPage = new FilteredResultPage(myDriver.getDriver());
        List<String> nameEachFridge;
        nameEachFridge = filteredResultPage.nameFridge();
        Assert.assertEquals(items, nameEachFridge.size());
        for (String samsungItem : nameEachFridge) {
            Assert.assertTrue(samsungItem.contains("Samsung"), "The name Samsung should be in each result.");
        }
        Assert.assertTrue(filteredResultPage.breadCrumFunction().contains("Heladeras con Frezzer"), "the name should be contained.");
    }
}