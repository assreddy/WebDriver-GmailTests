package New.src.gmailTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

/**
 * TODO: Insert description here. (generated by sreenivasa)
 */
public class gmailLoginPage {

  public static void main(String args[]){
    WebDriver driver = new FirefoxDriver();
    driver.get("http://gmail.com");
    testGmailHomePageBanner(driver);
    testGmailLogAndStrip(driver);
    testGmailHomePageNeedHelpLink(driver);
    testGmailCreateAccountLink(driver);
    testHomePageFooterAboutGoogleLink(driver);
    testHomePageFooterPrivacyLink(driver);
    testHomePageFooterTermsLink(driver);
    testHomePageFooterHelpLink(driver);
    driver.close();
  }
  /*
   * Verify banners and tags lines in Gmail home page.
   */
  public static void testGmailHomePageBanner(WebDriver driver){
    WebElement banner = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h1"));
    WebElement bannerhidden = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h2"));
    WebElement tagline = driver.findElement(By.xpath("html/body/div/div[2]/div[2]/div[2]/div/div/p[2]"));

    assertEquals("Home page banner text missing", "One account. All of Google.", banner.getText());
    assertEquals("Home page banner hidden text missing", "Sign in to continue to Gmail", bannerhidden.getText());
    assertEquals("Home page tagline text missing", "One Google Account for everything Google", tagline.getText());
  }  

  /*
   * Verify Google logo in Gmail home page.
   */
  public static void testGmailLogAndStrip(WebDriver driver){
    WebElement logo = driver.findElement(By.className("logo"));
    WebElement logostrip = driver.findElement(By.className("logo-strip"));

    assertEquals("Home page logo missing", "Google", logo.getAttribute("aria-label"));
    assertEquals("Logo Strip missing from home page.", "url(\"https://ssl.gstatic.com/accounts/ui/wlogostrip_230x17_1x.png\")", logostrip.getCssValue("background-image"));
  }
  
  /*
   * Verify Need Help link in Gmail home page
   */

  public static void testGmailHomePageNeedHelpLink(WebDriver driver){
    WebElement needhelp = driver.findElement(By.xpath(".//*[@id='gaia_firstform']/div/a"));
    assertEquals("Need Help missing", "Need help?", needhelp.getText());
  }
  
  /*
   * Verify Create Account link in Gmail home page
   */

  public static void testGmailCreateAccountLink(WebDriver driver){
    WebElement createaccount = driver.findElement(By.xpath(".//*[@id='link-signup']/a"));
    assertEquals("Create Account link missing", "Create account", createaccount.getText());
  }
  
  /*
   * Verify Footer About Google link in Gmail home page
   */

  public static void testHomePageFooterAboutGoogleLink(WebDriver driver){
    WebElement aboutgooglelink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[1]/a"));
    assertEquals("Create Account link missing", "About Google", aboutgooglelink.getText());
  }
  
  /*
   * Verify footer Privacy Help link in Gmail home page
   */

  public static void testHomePageFooterPrivacyLink(WebDriver driver){
    WebElement privacylink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[2]/a"));
    assertEquals("Create Account link missing", "Privacy", privacylink.getText());
  }
  
  /*
   * Verify footer Terms Help link in Gmail home page
   */

  public static void testHomePageFooterTermsLink(WebDriver driver){
    WebElement termslink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[3]/a"));
    assertEquals("Create Account link missing", "Terms", termslink.getText());
  }
  
  /*
   * Verify footer Help link in Gmail home page
   */

  public static void testHomePageFooterHelpLink(WebDriver driver){
    WebElement helplink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[4]/a"));
    assertEquals("Create Account link missing", "Help", helplink.getText());
  }
}

