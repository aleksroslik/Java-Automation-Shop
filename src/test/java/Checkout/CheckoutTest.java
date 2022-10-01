package Checkout;

import Base.Pages;
import Models.User;
import DataProviders.UserFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutTest extends Pages {

    protected static Logger logger = LoggerFactory.getLogger(CheckoutTest.class);

    User user = new UserFactory().getAlreadyRegisteredUser();

    @Test
    public void successfulCheckoutTest() {
        logger.info(">>>> Start Checkout test >>>>>");

        header.goToLoginPage();
        loginPage.loginUser(user);

        categoriesList.clickOnArtCategory();

        String expectedName = "THE BEST IS YET POSTER";
        productGrid.openProductByName(expectedName);

        productDetailsPage.addToCart();

        cartPopupPage.proceedToCheckout();
        shoppingCartPage.proceed();

        addressPage.changeBillingAddress(user)
                   .continueToShipping();

        shippingPage.continueToPayments();

        paymentsPage.selectPayByCheck()
                    .agreeToTerms()
                    .confirmOrder();

        assertThat(orderConfirmationPage.getProductName()).contains(expectedName);
        assertThat(orderConfirmationPage.getQuantity()).isEqualTo(1);
        assertThat(orderConfirmationPage.getUnitPrice()).isEqualTo(29.00);
        assertThat(orderConfirmationPage.getTotalPrice()).isEqualTo(29.00);
        assertThat(orderConfirmationPage.getShippingAndHandling()).isEqualTo("Free");
        assertThat(orderConfirmationPage.getPaymentMethod()).contains("Payments by check");
        assertThat(orderConfirmationPage.getShippingMethod()).contains("TesterSii");
        assertThat(orderConfirmationPage.getCheckPaymentDetails()).contains("John Doe", "Washington");

        String orderReference = orderConfirmationPage.getOrderReferenceNumber();

        header.goToAccount();
        accountPage.goToOrderHistory();

        String allOrders = orderHistoryPage.getOrders();

        assertThat(allOrders).contains(orderReference);

        orderHistoryPage.getOrderDetails();

        assertThat(orderDetailsPage.getOrderDate()).isEqualTo("09/30/2022");
        assertThat(orderDetailsPage.getTotalPrice()).isEqualTo(29.00);
        assertThat(orderDetailsPage.getPaymentStatus()).isEqualTo("Awaiting check payment");
        assertThat(orderDetailsPage.getInvoiceAddress()).contains(user.getAlternativeAddress());
        assertThat(orderDetailsPage.getDeliveryAddress()).contains(user.getAddress());

        logger.info(">>>> End of Checkout test >>>>>");
    }
}
