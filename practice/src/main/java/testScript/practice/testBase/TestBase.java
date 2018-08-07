package testScript.practice.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
	public File file;
	public FileInputStream freader;
	public Properties prop;
	

	public String getBrowser(String myBrowser) {
		
		if(System.getProperty("os.name").contains("Windows")) {
			
			if(myBrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
			else if(myBrowser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		else if(System.getProperty("os.name").contains("Mac")) {
			
			if(myBrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
			else if(myBrowser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		return null;
	}
	
	public void loadpropertiesFile() throws IOException {
		prop = new Properties();
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testScript\\practice\\config\\config.properties");
		freader = new FileInputStream(file);
		prop.load(freader);
		
		file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testScript\\practice\\config\\OR.properties");
		freader = new FileInputStream(file);
		prop.load(freader);
		
	}
	
	public String getPropertiesData(String Data) throws IOException {
		loadpropertiesFile();
		String data = prop.getProperty(Data);
		return data;
	}
	
	public static void main(String[] args) throws IOException {
		TestBase test = new TestBase();
		
		test.loadpropertiesFile();
		System.out.println(test.prop.getProperty("test"));
		System.out.println(test.prop.getProperty("url"));
	}
}
