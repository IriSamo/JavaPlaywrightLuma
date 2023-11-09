import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.nio.file.Paths;


@Listeners({ExtentReportListener.class})
public class BaseTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected static Page page;

    @BeforeClass
    protected void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
        );
    }

    @BeforeMethod
    protected void createContextAndPage() {
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setBaseURL("https://magento.softwaretestingboard.com")
        );

        page = context.newPage();
    }

    @AfterMethod
    protected void closeContext() {
        context.close();
    }

    @AfterClass
    protected void closeBrowser() {
        browser.close();
        playwright.close();
    }

    public static Page getPage() {
        return page;
    }
}