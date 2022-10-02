package PageObjects.Cart;

import Base.BasePage;
import Models.Cart;
import Models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {super(driver);
    }
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartPage.class);


    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceed;

    @FindBy(css = "div#cart-subtotal-products .value")
    private WebElement totalValue;

    @FindBy(css = ".cart-item")
    private List<WebElement> allItemsOnList;

    @FindBy(css = ".remove-from-cart")
    private WebElement deleteBtn;

    @FindBy(className = "no-items")
    private WebElement noItemsLabel;

    public String getEmptyBasketText() {
        return noItemsLabel.getText();
    }

    public void proceed() {
        click(proceed);
    }

    public void removeItem() {
        waitToBeClickable(deleteBtn);
        click(deleteBtn);
        scheduleWait(700);
    }

    public double getTotalCartValue() {
        String text = totalValue.getText().trim();
        return getPriceFromText(text);
    }

    public List<SingleItemCartPage> getAllItemsOnCartList() {
        List<SingleItemCartPage> allItems = new ArrayList<>();

        for (WebElement item : allItemsOnList) {
            allItems.add(new SingleItemCartPage(item));
        }
        return allItems;
    }

    public List<Product> getAllProductsFromShoppingCart() {
        List<SingleItemCartPage> allItemsOnCartList = getAllItemsOnCartList();
        List<Product> products = new ArrayList<>();
        for (SingleItemCartPage singleItemCartPage : allItemsOnCartList) {
            String name = singleItemCartPage.getName();
            double quantityPrice = singleItemCartPage.getQuantityPrice();
            int quantity = singleItemCartPage.getQuantity();
            double totalPrice = singleItemCartPage.getTotalPrice();

            Product product = new Product(name, quantityPrice, quantity, totalPrice);
            products.add(product);
        }
        return products;
    }

    public Cart getShoppingCart() {
        List<Product> allProductsInTheCart = getAllProductsFromShoppingCart();
        double totalShoppingCartValue = getTotalCartValue();
        return new Cart(allProductsInTheCart, totalShoppingCartValue);
    }
}
