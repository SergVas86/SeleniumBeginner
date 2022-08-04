package steps;

import pages.SearchResultsPage;

public class SearchResultSteps {
    private SearchResultsPage searchResultsPage = new SearchResultsPage();

    public SearchResultSteps verifyThatTopResultContainsCorrectText(String text) {
        searchResultsPage.assertThatTopResultContainsCorrectText(text);
        return this;

    }

    public SearchResultSteps verifyThatTopResultContainsProperAttributeText(String text) {
        searchResultsPage.assertThatTopResultContainsProperAttributeText(text);
        return this;
    }
}
