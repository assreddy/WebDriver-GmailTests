package gmail.WebDriver.Selenium.gmailWebDriverProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test GMail login with invalid email address, password check error message shown
 * Test GMail log and logout functionality with correct email address and password 
 */
public class gmailLoginLogout {

  private static final By EMAIL_INPUT = By.id("Email");
  private static final By PASSWORD_INPUT = By.id("Passwd");
  private static final By NEXT_BUTTON = By.id("next");
  private static final By SIGN_BUTTON = By.id("signIn");
  private static final By USER_SETTINGS = 
      By.xpath(".//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span");
  private static final By USER_SIGNOUT = By.id("gb_71");

  WebDriver driver;
  WebDriver element;

  @Before
  public void setup() throws Exception {
    //WebDriver driver = new ;
    driver = new FirefoxDriver();
    driver.get("http://gmail.com");
  }

  @Test
  public void testGmailLoginWithInvalidGmailId() throws Exception{
    WebElement userNameTextBox = driver.findElement(EMAIL_INPUT);
    userNameTextBox.sendKeys("testtest!!");
    driver.findElement(NEXT_BUTTON).click();
    Thread.sleep(100);
    WebElement errorMsgEmail = driver.findElement(By.xpath(".//*[@id='errormsg_0_Email']"));
    assertEquals("Emal id not matched.", "Sorry, Google doesn't recognize that email.", 
        errorMsgEmail.getText());
    userNameTextBox.clear();
  }

  @Test
  public void testGmailLoginWithInvalidPassword() throws Exception{
    WebElement userNameTextBox = driver.findElement(EMAIL_INPUT);
    userNameTextBox.sendKeys("testtest@gmail.com");
    driver.findElement(NEXT_BUTTON).click();
    Thread.sleep(100);
    WebElement passwordTextBox = driver.findElement(PASSWORD_INPUT);       
    passwordTextBox.sendKeys("testtesttesttest");
    driver.findElement(SIGN_BUTTON).click();
    Thread.sleep(100);
    WebElement errorMsgPassword = driver.findElement(By.xpath(".//*[@id='errormsg_0_Passwd']"));
    assertEquals("Emal and Password didn't matched", "The email and password you entered "
        + "don't match.", errorMsgPassword.getText());
  }

  @Test
  public void testGmailLoginForValidUser() throws Exception{
    WebElement userNameTextBox = driver.findElement(EMAIL_INPUT);
    userNameTextBox.sendKeys("<Add Email Address>"); // replace with user valid Gmail ID
    driver.findElement(NEXT_BUTTON).click();
    Thread.sleep(100);
    WebElement passwordTextBox = driver.findElement(PASSWORD_INPUT);
    passwordTextBox.sendKeys("<Add Password>"); // replace with user valid Password
    driver.findElement(SIGN_BUTTON).click();
    Thread.sleep(1000);
    WebElement gmailDropBox = driver.findElement(By.xpath(".//*[@id=':j']/span"));
    assertEquals("Emal and Password didn't matched", "Gmail", gmailDropBox.getText());
  }

  @Test
  public void testGmailLogOutAfterSuccessfullLogin() throws Exception{
    WebElement userNameTextBox = driver.findElement(EMAIL_INPUT);
    userNameTextBox.sendKeys("<Add Email Address>"); // replace with user valid Gmail ID
    driver.findElement(NEXT_BUTTON).click();
    Thread.sleep(100);
    WebElement passwordTextBox = driver.findElement(PASSWORD_INPUT);
    passwordTextBox.sendKeys("<Add Password>"); // replace with user valid Password
    driver.findElement(SIGN_BUTTON).click();
    Thread.sleep(1000);
    WebElement userSettings = driver.findElement(USER_SETTINGS);        
    userSettings.click();
    WebElement userLogOut = driver.findElement(USER_SIGNOUT);
    userLogOut.click();
  }

  @After
  public void teardown() throws Exception{
    driver.quit();
  }
}