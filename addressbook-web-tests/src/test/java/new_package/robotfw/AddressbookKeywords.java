package new_package.robotfw;

import new_package.appmanager.ApplicationManager;
import new_package.model.GroupData;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;
import java.security.PublicKey;

public class AddressbookKeywords {

  public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

  private ApplicationManager app;

  public void initApplicationManager() throws IOException {
    app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    app.init();
  }

  public void stopApplicationManager(){
    app.stop();
    app = null;
  }

  public int getGroupCount(){
    app.goTo().GroupPage();
    return app.group().count();
  }

  public void createGroup(String name, String header, String footer){
    app.goTo().GroupPage();
    app.group().create(new GroupData().withGroupName(name).withGroupHeader(header).withGroupFooter(footer));
  }
}
