package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "gate_anonymous_login_button")
    private WebElement skipLoginBtn;

    @FindBy(id = "gate_login_button")
    private WebElement loginBtn;

    @FindBy(id = "username")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement signInBtn;

    @FindBy(id = "keepMeSignedIn")
    private WebElement keepMeSignedIn;

    @FindAll({
            @FindBy(xpath = "//*[contains(@text, 'Sorry')]"),
            @FindBy(id = "alertMessage")
    })
    private WebElement errorLogin;

    @FindBy(id = "button")
    private WebElement returnToAppBtn;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void skipLogin() {
        waitForElementToBeVisible(skipLoginBtn);
        skipLoginBtn.click();
    }

    public void clickOnLoginBtn() {
        waitForElementToBeClickable(loginBtn);
        loginBtn.click();
        waitForPageLoad();
        waitForElementToBeVisible(emailField);
    }

    public boolean typeCredentials(String email, String pwd) {
        waitForElementToBeVisible(emailField);
        emailField.clear();
        emailField.sendKeys(email);
        waitForPageLoad();
        waitForElementToBeVisible(passwordField);
        passwordField.clear();
        passwordField.sendKeys(pwd);
        signInBtn.click();
        waitForPageLoad();
        waitForElementToBeVisible(errorLogin);
        return errorLogin.isDisplayed();
    }

    public void typeValidCredentials(String email, String pwd) {
            waitForElementToBeVisible(emailField);
            emailField.click();
            emailField.sendKeys(email);
            waitForPageLoad();
            waitForElementToBeVisible(passwordField);
            passwordField.click();
            passwordField.sendKeys(pwd);
            waitForElementToBeVisible(keepMeSignedIn);
            keepMeSignedIn.click();
            signInBtn.click();
            waitForPageLoad();
            waitForElementToBeVisible(returnToAppBtn);
            returnToAppBtn.click();
    }
}
