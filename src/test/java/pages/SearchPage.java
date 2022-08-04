package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement searchButton;
    //private By searchField = By.name("q");
    @FindBy(xpath = "//body")
    private WebElement pageBody;
    @FindBy(css = "div.XDyW0e")
    private WebElement searchByVoiceButton;

    //WebElement searchField = driver.findElement(By.xpath("(//input[@name='q'])[1]"));
    public SearchPage() {
        super();
    }

    public void fillSearchField(String text) {
        //WebElement searchFieldElement = driver.findElement(searchField);
        //searchFieldElement.click();
        //searchFieldElement.sendKeys(text);
        searchField.click();
        searchField.sendKeys(text);
    }

    public void pasteToSearchField(String text) {
        pasteTextToElementFromClipboard(searchField, text);
    }

    public void pressEnter() {
        //WebElement searchFieldElement = driver.findElement(searchField);
        //searchFieldElement.sendKeys(Keys.RETURN);
        searchField.sendKeys(Keys.RETURN);
    }

    public void clickSearchButtonOrPressEnter() throws InterruptedException {
        if (isElementFound(By.name("btnK"), 3)) {
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
            //clickWithJavascript(searchButton);
        } else {
            pressEnter();
        }
    }

    public void moveToVoiceSearchButton() {
        builder.moveToElement(searchByVoiceButton).build().perform();
    }

    public void assertThatVoiceSearchTooltipHasCorrectText(String text) {
        assertThat(pageBody.findElements(By.xpath("//div[@class ='gb_ae']/following-sibling::div[contains( text(),'" + text + "')]")).size()) //div[@class ='gb_ae']/following-sibling::div[contains( text(), 'Голосовой поиск')]
                .as("EXPECTED TOOLTIP WAS NOT FOUND");

    }


}
