package com.example.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.Playwright.create;

public class SampleTest {
    public static void main(String[] args) {
        try (Playwright playwright = create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://demoqa.com");
            System.out.println("Title: " + page.title());
            page.getByText("Elements").click();
            System.out.println(page.getByText("Text Box").isVisible());
            page.getByText("Text Box").click();
            page.getByPlaceholder("Full Name").fill("Likith Bhushan");
            page.getByPlaceholder("name@example.com").fill("likith@gmail.com");
          page.getByPlaceholder("Current Address").fill("Madhugiri");
            page.getByText("Submit").click();
        }
    }
}
