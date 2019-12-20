package package_lesson8.tests;

import org.testng.annotations.Test;
import package_lesson8.model.Issue;
import package_lesson8.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase {
  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
    int issueId = 1;
    skipIfNotFixed(issueId);
    Set<Project> projects = app.soap().getProjects();

    System.out.println(projects.size());
    for (Project project: projects) {
      System.out.println(project.getName());
    }
  }

  @Test
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    Set<Project> projects = app.soap().getProjects();

    Issue issue = new Issue()
            .withSummary("Test issue 1").withDescription("Test issue description 1").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(), created.getSummary());


  }
}
