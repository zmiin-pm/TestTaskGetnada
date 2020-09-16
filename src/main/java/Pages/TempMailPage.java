package Pages;

import Driver.DriverHolder;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class TempMailPage extends BasePage {

    @FindBy(css = ".address.what_to_copy")
    WebElement mailAddress;

    @FindBy(css = ".msg_item")
    WebElement mailItem;

    @FindBy(id = "idIframe")
    WebElement iFrame;

    @FindBy(xpath = "//body")
    private WebElement frameBody;

    @FindBy(xpath = "//body/span")
    private WebElement frameSpan;

    public TempMailPage open(String url) {
        DriverHolder.INSTANCE.getDriver().get(url);
        return this;
    }

    public String getMailAddress() {
        String address;
        try {                                           // to except StaleReferenceElementException
            address = mailAddress.getText();
        } catch (StaleElementReferenceException e) {
            address = mailAddress.getText();
        }
        return address;
    }

    public TempMailPage openMail() {
        waitForVisible(mailItem);
        mailItem.click();
        return this;
    }

    public List<String> getMessageFromMail() {
        DriverHolder.INSTANCE.getDriver()
                .switchTo().frame(iFrame);
        DriverHolder.INSTANCE.getWebDriverWait()            // Only firefox needed it to wait for messages loading
                .until(ExpectedConditions.visibilityOf(frameSpan));
        return Arrays.asList(
                frameBody
                        .getText()
                        .split("\\s"));
    }
}
