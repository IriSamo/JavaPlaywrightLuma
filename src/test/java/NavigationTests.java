import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTests extends BaseTest {

    @Test
    void shouldTitle() {
        page.navigate("https://magento.softwaretestingboard.com/");

        assertThat(page).hasTitle("Home Page");
    }
}
