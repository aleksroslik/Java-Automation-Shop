package Base;

import PageObjects.*;
import PageObjects.Cart.CartPopupPage;
import PageObjects.Cart.ShoppingCartPage;
import PageObjects.Checkout.*;
import PageObjects.PageComponents.*;
import PageObjects.Order.OrderConfirmationPage;
import PageObjects.Order.OrderDetailsPage;
import PageObjects.Order.OrderHistoryPage;
import org.junit.jupiter.api.BeforeEach;

public class Pages extends BaseTest {

    public ProductDetailsPage productDetailsPage;
    public ProductGrid productGrid;
    public CartPopupPage cartPopupPage;
    public CategoriesList categoriesList;
    public Header header;
    public MainMenu mainMenu;
    public LoginPage loginPage;
    public CategoryDetailsPage categoryDetailsPage;
    public Filter filter;
    public RegistrationPage registrationPage;
    public SearchWidget searchWidget;
    public SearchResultsPage searchResultsPage;
    public AddressPage addressPage;
    public ConfirmationPage confirmationPage;
    public PaymentsPage paymentsPage;
    public ShippingPage shippingPage;
    public ShoppingCartPage shoppingCartPage;
    public OrderConfirmationPage orderConfirmationPage;
    public AccountPage accountPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderDetailsPage orderDetailsPage;

    @BeforeEach
    public void testSetup() {
        productDetailsPage = new ProductDetailsPage(driver);
        cartPopupPage = new CartPopupPage(driver);
        categoriesList = new CategoriesList(driver);
        productGrid = new ProductGrid(driver);
        header = new Header(driver);
        mainMenu = new MainMenu(driver);
        loginPage = new LoginPage(driver);
        categoryDetailsPage = new CategoryDetailsPage(driver);
        filter = new Filter(driver);
        registrationPage = new RegistrationPage(driver);
        searchWidget = new SearchWidget(driver);
        searchResultsPage = new SearchResultsPage(driver);
        addressPage = new AddressPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        paymentsPage = new PaymentsPage(driver);
        shippingPage = new ShippingPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        accountPage = new AccountPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
    }
}
