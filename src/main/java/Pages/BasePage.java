package Pages;

import Driver.DriverHolder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage {
    protected BasePage() {
        PageFactory.initElements(DriverHolder.INSTANCE.getDriver(), this);
    }

    protected abstract BasePage open(String url);

    protected BasePage waitForVisible(WebElement webElement) {
        DriverHolder.INSTANCE.getWebDriverWait()
                .until(ExpectedConditions
                        .visibilityOf(webElement));
        return this;
    }


}
