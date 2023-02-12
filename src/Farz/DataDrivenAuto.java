package Farz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class DataDrivenAuto {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Furqan/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.etihad.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement l = driver.findElement(By.xpath(
				"//body/div[2]/div[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/label[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", l);
		WebElement multi = driver.findElement(By.xpath(
				"//body/div[2]/div[1] /div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/fieldset[1]/div[3]/label[1]"));
		multi.click();
		driver.manage().window().maximize();

		WebElement clsbtn = driver.findElement(By.xpath(
				"//*[@class='onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon']"));
		clsbtn.click();

		WebElement f = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", f);

		File file = new File("C:\\Users\\Furqan\\Downloads\\inputData.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("input");
		XSSFRow A1 = sheet.getRow(0);

		String InputPlaceFrom1 = A1.getCell(0).getStringCellValue();
		String InputPlaceTo1 = A1.getCell(1).getStringCellValue();
		String InputPlaceFrom2 = A1.getCell(1).getStringCellValue();
		String InputPlaceTo2 = A1.getCell(2).getStringCellValue();

		WebElement PlaceFrom1 = driver.findElement(By.xpath("//input[@id='multicityOrigin0']"));
		PlaceFrom1.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		PlaceFrom1.sendKeys(InputPlaceFrom1);
		PlaceFrom1.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement PlaceTo1 = driver.findElement(By.xpath("//input[@id='multicityDestination0']"));
		PlaceTo1.click();
		PlaceTo1.sendKeys(InputPlaceTo1);
		PlaceTo1.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement Date1 = driver.findElement(By.xpath("//input[@id='oneWayDesktopCalendar0DepartDate']"));
		Date1.click();
		driver.findElement(By.xpath(
				"//body[1]/div[2]/div[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[2]/td[4]"))
				.click();

		WebElement PlaceFrom2 = driver.findElement(By.xpath("//input[@id='multicityOrigin1']"));
		PlaceFrom2.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		PlaceFrom2.sendKeys(InputPlaceFrom2);
		PlaceFrom2.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		WebElement PlaceTo2 = driver.findElement(By.xpath("//input[@id='multicityDestination1']"));
		PlaceTo2.click();
		PlaceTo2.sendKeys(InputPlaceTo2);
		PlaceTo2.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

		inputStream.close();
		wb.close();

		WebElement Date2 = driver.findElement(By.xpath("//input[@id='oneWayDesktopCalendar1DepartDate']"));
		Date2.click();
		driver.findElement(By.xpath(
				"//body[1]/div[2]/div[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/table[1]/tbody[1]/tr[2]/td[3]"))
				.click();

		driver.findElement(By.xpath("//button[contains(text(),'Search flights')]")).click();
		String FromTime = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/time[1]"))
				.getText();
		String ToTime = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/time[1]"))
				.getText();
		String Duration = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/time[1]/span[1]"))
				.getText();
		String FlightNumber = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"))
				.getText();
		String AircraftType = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"))
				.getText();
		String Fare = driver.findElement(By.xpath(
				"//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/span[1]/span[1]/span[1]/span[1]/span[2]/span[1]"))
				.getText();

		File file2 = new File("C:\\Users\\Furqan\\Downloads\\outputData.xlsx");
		FileInputStream outputStream = new FileInputStream(file2);
		XSSFWorkbook wb2 = new XSSFWorkbook(outputStream);
		XSSFSheet sheet2 = wb2.getSheet("output");

		sheet2.createRow(1).createCell(1).setCellValue(FromTime);

		sheet2.getRow(1).createCell(2).setCellValue(ToTime);

		sheet2.getRow(1).createCell(3).setCellValue(Duration);

		sheet2.getRow(1).createCell(4).setCellValue(FlightNumber);

		sheet2.getRow(1).createCell(5).setCellValue(AircraftType);

		sheet2.getRow(1).createCell(6).setCellValue(Fare);

		FileOutputStream fout = new FileOutputStream(file2);
		wb2.write(fout);
		wb2.close();

	}

}
