package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//h3[contains(text(),'Java')]")
    private WebElement resultsRow;

    @FindBy(xpath = "//h3[contains(text(),'Java')]")
    private List<WebElement> resultsRows;

    //private By resultRow = By.xpath("//h3[contains(text(),'Java')]");

    public SearchResultsPage() {
        super();
    }

    public void assertThatTopResultContainsCorrectText(String expected) {
        /*WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultRowElement.isDisplayed()).as("Element has not been displayed").isTrue();
        assertThat(resultRowElement.getText()).as("WRONG TEXT").contains(expected);*/
        wait.until(ExpectedConditions.visibilityOfAllElements(resultsRows));
        //assertThat(resultsRow.isDisplayed()).as("Element has not been displayed").isTrue();
        assertThat(resultsRows.stream().map(e -> e.getText()).collect(Collectors.toList()).toString()).as("WRONG TEXT").contains(expected);
    }

    public void assertThatTopResultContainsProperAttributeText(String expected) {
        //WebElement resultRowElement = driver.findElement(resultRow);
        assertThat(resultsRow.getAttribute("class")).as("Wrong Attribute text").contains("LC20lb");
    }
}
