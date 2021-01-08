package test;

import exception.ui.WebServerUIException;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GUITest {

    @Test
    public void testOpenStoppedWebServerBrowser() throws WebServerUIException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8134");
        if(!driver.getTitle().equals("Problem loading page"))
            throw new WebServerUIException();
    }

    @Test
    public void testOpenRunningWebServerBrowser() throws WebServerUIException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8134");
        if(driver.getTitle().equals("Problem loading page"))
            throw new WebServerUIException();
    }

    @Test
    public void testNotFoundPageWebServerBrowser() throws WebServerUIException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8134/notfoundpage");
        if(!driver.getTitle().equals("Not found"))
            throw new WebServerUIException();
    }

    @Test
    public void testMaintenanceWebServeBrowser() throws WebServerUIException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8134/project.html");
        if(!driver.getTitle().equals("Unavailable"))
            throw new WebServerUIException();
    }


}
