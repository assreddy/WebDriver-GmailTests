package gmail.WebDriver.Selenium.gmailWebDriverProject;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.sql.Driver;

import static org.junit.Assert.*;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
//import org.junit.Before;
import org.junit.Test;

/**
 * TODO: Insert description here. (generated by sreenivasa)
 */
public class gmailHomePageLinks {
  
  WebDriver driver = null;
  WebDriver element = null;
  
  @Before
  public void setUp() throws Exception 
  {
    //WebDriver driver = new ;
      driver = new FirefoxDriver();
      driver.get("http://gmail.com");
  }
  
//  @Test
//  //Verify banners and tags lines in Gmail home page.
//  public void testGmailHomePageBanner(){
//    WebElement banner = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h1"));
//    WebElement bannerhidden = driver.findElement(By.xpath("html/body/div/div[2]/div[1]/h2"));
//    WebElement tagline = driver.findElement(By.xpath("html/body/div/div[2]/div[2]/div[2]/div/div/p[2]"));
//
//    assertEquals("Home page banner text missing", "One account. All of Google.", banner.getText());
//    assertEquals("Home page banner hidden text missing", "Sign in to continue to Gmail", bannerhidden.getText());
//    assertEquals("Home page tagline text missing", "One Google Account for everything Google", tagline.getText());
//    driver.close();
//  }  
//  
//  @Test
//  // Verify Google logo in Gmail home page.
//  public void testGmailLogAndStrip(){
//    WebElement logo = driver.findElement(By.className("logo"));
//    WebElement logostrip = driver.findElement(By.className("logo-strip"));
//
//    assertEquals("Home page logo missing", "Google", logo.getAttribute("aria-label"));
//    assertEquals("Logo Strip missing from home page.", "url(\"https://ssl.gstatic.com/accounts/ui/wlogostrip_230x17_1x.png\")", logostrip.getCssValue("background-image"));
//    driver.close();
//  }
//
//  @Test
//  // Verify Need Help link in Gmail home page
//  public void testGmailHomePageNeedHelpLink(){
//    WebElement needhelp = driver.findElement(By.xpath(".//*[@id='gaia_firstform']/div/a"));
//    assertEquals("Need Help missing", "Need help?", needhelp.getText());
//    driver.close();
//  }
//
//  @Test
//  // Verify Create Account link in Gmail home page
//  public void testGmailCreateAccountLink(){
//    WebElement createaccount = driver.findElement(By.xpath(".//*[@id='link-signup']/a"));
//    assertEquals("Create Account link missing", "Create account", createaccount.getText());
//    driver.close();
//  }
  
  @Test
  public void testHomePageFooterAboutGoogleLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement aboutgooglelink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[1]/a"));
    assertEquals("Create Account link missing", "About Google", aboutgooglelink.getText());
    aboutgooglelink.click();
    
    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    WebElement newTitle = driver.findElement(By.xpath(".//*[@id='corp-crumb']/ol/li"));
    assertEquals("New About page Found", "About Google", newTitle.getText());
    // Close the new opened window:
    driver.close();
    driver.switchTo().window(winHandleBefore); 
    driver.close();
  }
  
  @Test
  // Verify footer Privacy Help link in Gmail home page
  public void testHomePageFooterPrivacyLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement privacylink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[2]/a"));
    assertEquals("Create Account link missing", "Privacy", privacylink.getText());
    privacylink.click();

    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    WebElement newPageTitle = driver.findElement(By.xpath("//h1[contains(.,'Welcome to the Google Privacy Policy')]"));
    assertEquals("New About page Found", "Welcome to the Google Privacy Policy", newPageTitle.getText());
    driver.close();
    driver.switchTo().window(winHandleBefore);
    driver.close();
  }

  @Test
  // Verify footer Terms Help link in Gmail home page
  public void testHomePageFooterTermsLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement termslink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[3]/a"));
    assertEquals("Create Account link missing", "Terms", termslink.getText());
    termslink.click();

    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    WebElement newPageTitle = driver.findElement(By.xpath("//h1[contains(.,'Google Terms of Service')]"));
    assertEquals("New About page Found", "Google Terms of Service", newPageTitle.getText());
    driver.close();
    driver.switchTo().window(winHandleBefore);
    driver.close();
  }
  @Test
  // Verify footer Help link in Gmail home page
  public void testHomePageFooterHelpLink(){
    String winHandleBefore = driver.getWindowHandle();
    WebElement helplink = driver.findElement(By.xpath(".//*[@id='footer-list']/li[4]/a"));
    assertEquals("Create Account link missing", "Help", helplink.getText());
    helplink.click();

    for(String winHandle : driver.getWindowHandles()){
      driver.switchTo().window(winHandle);
    }
    WebElement newPageTitle = driver.findElement(By.xpath("//h3[contains(.,'Get started with Google Accounts')]"));
    assertEquals("New About page Found", "Get started with Google Accounts", newPageTitle.getText());
    driver.close();
    driver.switchTo().window(winHandleBefore); 
    driver.close();
  }
  @After
  public void teardown() throws Exception 
  {
     driver.quit();
  }
}