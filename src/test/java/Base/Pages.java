package Base;

import PageObjects.*;
import PageObjects.Components.*;
import org.junit.jupiter.api.BeforeEach;

public class Pages extends BaseTest {

    public ProductDetailsPage productDetailsPage;
    public ProductGrid productGrid;
    public CartPopupPage cartPopupPage;
    public CartPage cartPage;
    public CategoriesList categoriesList;
    public Header header;
    public MainMenu mainMenu;
    public LoginPage loginPage;
    public HomePage homePage;
    public CategoryDetailsPage categoryDetailsPage;
    public Filter filter;
    public RegistrationPage registrationPage;
    public SearchWidget searchWidget;
    public SearchResultsPage searchResultsPage;

    @BeforeEach
    public void testSetup() {
        productDetailsPage = new ProductDetailsPage(driver);
        cartPopupPage = new CartPopupPage(driver);
        cartPage = new CartPage(driver);
        categoriesList = new CategoriesList(driver);
        productGrid = new ProductGrid(driver);
        header = new Header(driver);
        mainMenu = new MainMenu(driver);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        categoryDetailsPage = new CategoryDetailsPage(driver);
        filter = new Filter(driver);
        registrationPage = new RegistrationPage(driver);
        searchWidget = new SearchWidget(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }
}
