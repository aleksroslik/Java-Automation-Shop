package PageObjects.PageComponents;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends BasePage {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img.logo.img-responsive")
    private WebElement myStoreBtn;

    public void goToMainPage() {
        click(myStoreBtn);
    }
}
