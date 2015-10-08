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
 * Verify GMail home page logo, banners,  home page and text shown correctly.
 * Verify GMail home page links are working correctly. 
 */
public class gmailHomePageLinks {

  WebDriver driver;

  @Before
  public void setUp() throws Exception {
    //WebDriver driver = new ;
    driver = new FirefoxDriver();
    driver.get("http://gmail.com");
  }
  // Open link in new window.
  public void openNewWindow(String winHandleBefore) {
    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
  }

  // Verify text present in the page.
  public void verityText(WebElement pageHeading, String expectedString, String errorMessage) {
    assertEquals(errorMessage, expectedString, pageHeading.getText());
  }

  public void verityPageTitle(String t, String title){
    assertEquals(t,title);
  }

  @Test
  public void testGmailHomePageBanners(){
    WebElement banner = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h1"));
    WebElement hiddenBanner = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h2"));
    WebElement tagLine = driver.findElement(By.xpath
        ("html/body/div/div[2]/div[2]/div[2]/div/div/p[2]"));

    assertEquals("Home page banner text missing", "One account. All of Google.", banner.getText());
    assertEquals("Home page banner hidden text missing", "Sign in to continue to Gmail", 
        hiddenBanner.getText());
    assertEquals("Home page tagline text missing", "One Google Account for everything Google",
        tagLine.getText());
    driver.close();
  }  


  @Test  
  public void testGmailLogAndStrip(){
    WebElement logo = driver.findElement(By.className("logo"));
    WebElement logoStrip = driver.findElement(By.className("logo-strip"));

    assertEquals("Home page logo missing", "Google", logo.getAttribute("aria-label"));
    assertEquals("Logo Strip missing from home page.", 
        "url(\"https://ssl.gstatic.com/accounts/ui/wlogostrip_230x17_1x.png\")", 
        logoStrip.getCssValue("background-image"));
    driver.close();
  }

  @Test  
  public void testGmailHomePageNeedHelpLink(){
    WebElement needhelp = driver.findElement(By.xpath(".//*[@id='gaia_firstform']/div/a"));
    assertEquals("Need Help missing", "Need help?", needhelp.getText());
    driver.close();
  }

  @Test
  public void testGmailCreateAccountLink(){
    WebElement createAccount = driver.findElement(By.xpath(".//*[@id='link-signup']/a"));
    assertEquals("Create Account link missing", "Create account", createAccount.getText());
    driver.close();
  }

  @Test
  public void testGmailHomePageFooterAboutGoogleLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement aboutGoogleLink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[1]/a"));
    assertEquals("Create Account link missing", "About Google", aboutGoogleLink.getText());
    aboutGoogleLink.click();
    openNewWindow(winHandleBefore);
    verityPageTitle(driver.getTitle(), "About Google");
    WebElement newTitle = driver.findElement(By.xpath(".//*[@id='corp-crumb']/ol/li"));
    assertEquals("New About page Found", "About Google", newTitle.getText());
    verityText(newTitle, "About Google", "New About page Found");
    driver.close();
  }

  @Test
  public void testGmailHomePageFooterPrivacyLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement privacyLink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[2]/a"));
    assertEquals("Create Account link missing", "Privacy", privacyLink.getText());
    privacyLink.click();
    openNewWindow(winHandleBefore);
    verityPageTitle(driver.getTitle(), "Privacy Policy – Privacy & Terms – Google");
    WebElement newPageTitle = driver.findElement
        (By.xpath("//h1[contains(.,'Welcome to the Google Privacy Policy')]"));
    assertEquals("New About page Found", "Welcome to the Google Privacy Policy",
        newPageTitle.getText());
    verityText(newPageTitle, "Welcome to the Google Privacy Policy", "New Privay page Found");
    driver.close();
  }

  @Test
  public void testGmailHomePageFooterTermsLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement termsLink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[3]/a"));
    assertEquals("Create Account link missing", "Terms", termsLink.getText());
    termsLink.click();
    openNewWindow(winHandleBefore);
    verityPageTitle(driver.getTitle(), "Google Terms of Service – Privacy & Terms – Google");
    WebElement newPageTitle = driver.findElement
        (By.xpath("//h1[contains(.,'Google Terms of Service')]"));
    assertEquals("New About page Found", "Google Terms of Service", newPageTitle.getText());
    verityText(newPageTitle, "Google Terms of Service", "New About page Found");
    driver.close();
  }

  @Test
  public void testGmailHomePageFooterHelpLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement helpLink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[4]/a"));
    helpLink.click();
    openNewWindow(winHandleBefore);
    verityPageTitle(driver.getTitle(), "Accounts Help");
    WebElement newPageTitle = driver.findElement
        (By.xpath("//h3[contains(.,'Get started with Google Accounts')]"));
    verityText(newPageTitle, "Get started with Google Accounts", "New About page Found");
    driver.close();
  }

  @After
  public void teardown() throws Exception {
    driver.quit();
  }
}