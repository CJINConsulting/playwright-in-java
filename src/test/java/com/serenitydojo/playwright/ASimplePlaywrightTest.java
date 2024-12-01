package com.serenitydojo.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@UsePlaywright
public class ASimplePlaywrightTest {
    @Test
    void shouldShowThePageTitle(Page page) {
        page.navigate("https://practicesoftwaretesting.com");
        String title = page.title();
        assertThat(title).contains("Practice Software Testing");
    }

    @Test
    void shouldSearchByKeyword(Page page) {
        page.navigate("https://practicesoftwaretesting.com");
        page.locator("[placeholder='Search']").fill("pliers");
        page.locator("button:has-text('Search')").click();

        int matchingSearch = page.locator(".card").count();
        assertTrue(matchingSearch > 0);
    }
}
