package new_package.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  private final Properties properties;
  private NavigationHelper navigationHelper;
  private ContactHelper contactHelper;
  private SessionHelper sessionHelper;
  private GroupHelper groupHelper;
  private String browser;
  private DbHelper dbHelper;

  public ApplicationManager(String browser) {
    properties = new Properties();
    this.browser = browser;

  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

    dbHelper = new DbHelper();

    if ("".equals(properties.getProperty("selenium.server"))) {
      if (browser.equals(BrowserType.FIREFOX)) {
        wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
        wd = new ChromeDriver();
      } else {
        wd = new EdgeDriver();
      }
    } else {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setBrowserName(browser);
      wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
    }

    wd.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    contactHelper = new ContactHelper(this);
    groupHelper = new GroupHelper(this);
    navigationHelper = new NavigationHelper(this);
    sessionHelper = new SessionHelper(this);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
  }

  public GroupHelper group() {
    return groupHelper;
  }
  public ContactHelper contact() {
    return contactHelper;
  }
  public NavigationHelper goTo() {
    return navigationHelper;
  }
  public DbHelper db() {return dbHelper;}
  public void stop() {
    wd.quit();
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
