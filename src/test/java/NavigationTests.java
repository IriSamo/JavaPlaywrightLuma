import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTests extends BaseTest {

    @Test
    void shouldTitle() {
        page.navigate("/");

        assertThat(page).hasTitle("Home Pag");
    }

    @Test
    void navigateToWhatsNew() {
        page.navigate("/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("What's New")).click();

        assertThat(page).hasTitle("What's New");
        assertThat(page).hasURL("https://magento.softwaretestingboard.com/what-is-new.html");
    }

    @Test
    void navigateToWomen() {
        page.navigate("/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Women")).click();

        assertThat(page).hasTitle("Women");
        assertThat(page).hasURL("https://magento.softwaretestingboard.com/women.html");
    }

    @Test
    void navigateToMen() {
        page.navigate("/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(" Men")).click();

        assertThat(page).hasTitle("Men");
        assertThat(page).hasURL("https://magento.softwaretestingboard.com/men.html");
    }

    @Test
    void navigateToGear() {
        page.navigate("/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Gear")).click();

        assertThat(page).hasTitle("Gear");
        assertThat(page).hasURL("https://magento.softwaretestingboard.com/gear.html");
    }

    @Test
    void navigateToTraining() {
        page.navigate("/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Training")).click();

        assertThat(page).hasTitle("Training");
        assertThat(page).hasURL("https://magento.softwaretestingboard.com/training.html");
    }

    @Test
    void navigateToSale() {
        page.navigate("/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName("Sale")).click();

        assertThat(page).hasTitle("Sale");
        assertThat(page).hasURL("https://magento.softwaretestingboard.com/sale.html");
    }

    @DataProvider
    public Object[][] menuItems() {
        return new Object[][]{
                {"What's New", "https://magento.softwaretestingboard.com/what-is-new.html", "What's New"},
                {"Women", "https://magento.softwaretestingboard.com/women.html", "Women"},
                {"Men", "https://magento.softwaretestingboard.com/men.html", "Men"},
                {"Gear", "https://magento.softwaretestingboard.com/gear.html", "Gear"},
                {"Training", "https://magento.softwaretestingboard.com/training.html", "Training"},
                {"Sale", "https://magento.softwaretestingboard.com/sale.html", "Sale"}
        };
    }

    @Test(dataProvider = "menuItems")
    void navigateToMenuItems(String name, String expectedUrl, String expectedTitle) {
        page.navigate("https://magento.softwaretestingboard.com/");
        page.getByRole(AriaRole.MENUITEM, new Page.GetByRoleOptions().setName(
                Pattern.compile(name))).click();

        assertThat(page).hasTitle(expectedTitle);
        assertThat(page).hasURL(expectedUrl);
    }
}
