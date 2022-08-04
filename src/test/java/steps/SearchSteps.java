package steps;

import pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeSearchByKeyword(String keyword) throws InterruptedException {
        // searchPage.fillSearchField(keyword);
        searchPage.pasteToSearchField(keyword);
        searchPage.clickSearchButtonOrPressEnter();
        /*Thread.sleep(3000);*/
        return new SearchResultSteps();
    }

    public SearchSteps openTooltip() {
        searchPage.moveToVoiceSearchButton();
        return this;
    }

    public SearchSteps verifyThatTooltipContainsText(String text) {
        searchPage.assertThatVoiceSearchTooltipHasCorrectText(text);
        return this;
    }
}
