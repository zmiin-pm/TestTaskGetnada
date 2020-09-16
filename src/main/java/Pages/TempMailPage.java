package Pages;

import Driver.DriverHolder;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public TempMailPage open(String url) {
        DriverHolder.INSTANCE.getDriver().get(url);
        return this;
    }

    public String getMailAddress() {
//        waitForVisible(mailAddress);
//        System.out.println(waitForVisible(mailAddress));
        String s;
        try {                                           // to except StaleReferenceElementException
            s = mailAddress.getText();
        } catch (StaleElementReferenceException e) {
            s = mailAddress.getText();
        }
        return s;
    }

    public TempMailPage openMail(){
        waitForVisible(mailItem);
        mailItem.click();
        return this;
    }

    public List<String> getMessageFromMail(){
        DriverHolder.INSTANCE.getDriver()
                .switchTo().frame(iFrame);
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        waitUntilNotNull(frameBody);
        System.out.println("Body: " + frameBody.getText());
        System.out.println(Arrays.asList(
                frameBody
                        .getText()
                        .split("\\s")));
        return Arrays.asList(
                frameBody
                        .getText()
                        .split("\\s"));
    }
}
