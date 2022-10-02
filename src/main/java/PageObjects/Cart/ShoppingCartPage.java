package PageObjects.Cart;

import Base.BasePage;
import Models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {super(driver);
    }

    @FindBy(css = "a.btn.btn-primary")
    private WebElement proceed;

    @FindBy(css = ".cart-total")
    private WebElement totalValue;

    @FindBy(css = ".cart-item")
    private List<WebElement> allItemsOnList;

    @FindBy(css = ".cart-items .cart-item:nth-of-type(1) .float-xs-left")
    private WebElement deleteBtn;

    @FindBy(className = "no-items")
    private WebElement noItemsLabel;

    public boolean isDeleteButtonVisible() {
        return deleteBtn.isDisplayed();
    }

    public boolean isBasketEmpty() {
        return noItemsLabel.isDisplayed();
    }

    public void proceed() {
        click(proceed);
    }

    public void removeItem() {
        waitToBeVisible(deleteBtn);
        click(deleteBtn);
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
}
