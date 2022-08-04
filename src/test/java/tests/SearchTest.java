package tests;

import org.testng.annotations.Test;

public class SearchTest extends BaseTest {




    /*@Test
    public void openGoogleComInChromeTest (){

        System.out.println(driver.getTitle());
        WebElement searchField = driver.findElement(By.xpath("//a[@class='gb_d']"));
        System.out.println("href attr contains value: " + searchField.getAttribute("href") );
        System.out.println("element text "+ searchField.getText());
        //searchField.click();
          ;
    }*/

 /*   @Test(dataProvider = "dataProvider") //Page object pattern version
    public void googleSearchResultsAndTime(String text) {

        SearchPage searchPage = new SearchPage();
        searchPage.fillSearchField(text);
        searchPage.pressEnter();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.assertThatTopResultContainsCorrectText("Java");
        searchResultsPage.assertThatTopResultContainsProperAttributeText("LC20lb");

    }*/


    @Test(dataProvider = "dataProvider") //Steps pattern version
    public void googleSearchResultsAndTime(String text) throws InterruptedException {

        steps.executeSearchByKeyword(text)
                .verifyThatTopResultContainsCorrectText("Java")
                .verifyThatTopResultContainsProperAttributeText("LC20lb");

    }

    @Test
    public void verifySearchByVoiceTooltipGoogle() {
        steps.openTooltip()
                .verifyThatTooltipContainsText("Голосовой поиск");
    }

}

