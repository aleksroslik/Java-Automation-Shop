package PageObjects.Cart;

import Base.BasePage;
import Models.Cart;
import Models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {super(driver);
    }

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
        click(deleteBtn);
        scheduleWait(700);
    }

    public double getTotalCartValue() {
        String text = totalValue.getText().trim();
        return getPriceFromText(text);
    }

    public List<CartItemPage> getAllItemsOnCartList() {
        List<CartItemPage> allItems = new ArrayList<>();

        for (WebElement item : allItemsOnList) {
            allItems.add(new CartItemPage(driver, item));
        }
        return allItems;
    }

    public List<Product> getAllProductsFromShoppingCart() {
        List<CartItemPage> allItemsOnCartList = getAllItemsOnCartList();
        List<Product> products = new ArrayList<>();
        for (CartItemPage cartItemPage : allItemsOnCartList) {
            String name = cartItemPage.getName();
            double quantityPrice = cartItemPage.getQuantityPrice();
            int quantity = cartItemPage.getQuantity();
            double totalPrice = cartItemPage.getTotalPrice();

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
