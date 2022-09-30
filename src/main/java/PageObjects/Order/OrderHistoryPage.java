package PageObjects.Order;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class OrderHistoryPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(OrderHistoryPage.class);

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='content']/table/tbody/tr")
    private List<WebElement> allOrders;

    @FindBy(css = "[data-link-action='view-order-details']")
    private WebElement orderDetails;

    public void getOrderDetails() {
        click(orderDetails);
    }

    public void goToOrderDetails(String id) {
        if(getOrders().contains(id)) {
            getOrderDetails();
        }
    }

    public String getOrders() {
        for (WebElement order : allOrders) {
            String orders = order.getText();
            logger.info("List of orders: " + orders);
            return orders;
        }
        return null;
    }
}

