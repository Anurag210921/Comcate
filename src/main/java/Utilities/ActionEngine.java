package Utilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ActionEngine {
	WebDriver driver;
	
	
	
	public ActionEngine(WebDriver driver) {
		
	this.driver=driver;
	
	}

	public void click_custom(WebElement element)
	{
		
		element.click();
		
	
	}
	
	public void send_keys(WebElement element, String text)
	{
		element.click();
		element.clear();
		element.sendKeys(text);
		
	}
	
	public void clear_field(WebElement element)
	{
		
		element.clear();
		
		
	}
	
	
	
	public void selectByVisibleText(WebElement element, String text)
	{
		Select dropdown= new Select(element);
		dropdown.selectByVisibleText(text);
		
	}
	
	public void selectByIndex(WebElement element, int index)
	{
		Select dropdown= new Select(element);
		dropdown.selectByIndex(index);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
		
	}

	public void mouseHoverAndClick(WebElement element)
	{
		Actions action= new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
	}
	
	public String getCurrentWindow()
	{
		
		return driver.getWindowHandle();
	}
		
	public Set<String> getAllWindows()
	{
		
		return driver.getWindowHandles();
	}	

	public String get_Text(WebElement element)
	{
		return element.getText();
		
	}
	
    public void selectCheckBox(WebElement element)
    {
        
    	 boolean value= getCheckBoxValue(element);
         if(value== false)
         element.click();	
    }

    public void uncheck_CheckBox(WebElement element) {
    	boolean value= getCheckBoxValue(element);
        if(value== true)
        	element.click();	
    }

    public boolean getCheckBoxValue(WebElement ele) {
        
        return ele.isSelected();
    }
	
	public List<WebElement> findElements_custom(List<WebElement> element)
	{
		
		List<WebElement> list= new ArrayList<>();
		int size=element.size();
		for(int i=0; i<size;i++)
		{
			list.add(element.get(i));
		}
	return list;
	}


}