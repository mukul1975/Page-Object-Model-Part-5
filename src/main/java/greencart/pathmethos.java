package greencart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class pathmethos {
	
	WebDriver driver;
	
	@FindBy(how=How.CSS,using="h4.product-name")
	WebElement product;
	By product1=By.cssSelector("h4.product-name");
	By add=By.cssSelector("div.product-action");
	
	
	
	@FindBy(how=How.XPATH,using="//a[@class='cart-icon']//img[contains(@class,'')]")
	WebElement bag;
	@FindBy(how=How.XPATH,using="//button[contains(text(),'PROCEED TO CHECKOUT')]")
	WebElement proceed;
	@FindBy(how=How.CSS,using="[class='promoCode']")
	WebElement pcode;
	
	@FindBy(how=How.XPATH,using="//button[@class='promoBtn']")
	WebElement apply;
	
	@FindBy(how=How.XPATH,using="//span[@class='promoInfo']")
	WebElement vcode;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Place Order')]")
	WebElement placeorder;
	
	@FindBy(how=How.XPATH,using="//div[@class='wrapperTwo']//div//select")
	WebElement select;
	
	@FindBy(how=How.XPATH,using="//input[@class='chkAgree']")
	WebElement check;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Proceed')]")
	WebElement proceed1;
	public pathmethos(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void proceed2()
	{
		proceed1.click();
	}
	
	
	public void check()
	{
		check.click();
	}
	
	public void select()
	{
		Select sc=new Select(select);
		sc.selectByVisibleText("India");
	}
	
	public void placeorder()
	{
		placeorder.click();
	}
	public void bag()
	{
		bag.click();
	}
	public void proceed()
	{
		proceed.click();
	}
	public void pcode(String text)
	{
		pcode.sendKeys(text);
	}
	public void apply()
	{
		apply.click();	
	}
	
	
	public void vcode()
	{
		Assert.assertTrue(vcode.getText().contains("Code applied ..!"));
		
	}
	
	int j=0;
	String[] itemNeed= {"Cucumber","Apple","Orange","Beans","Mango"};
	
	public void addtocart()
	{
		List<WebElement> item=driver.findElements(product1);
		
		for(int i=0;i<item.size();i++)
		{
			String[] itemName=item.get(i).getText().split("-");
			String name=itemName[0].trim();
			
			List itemneeded=Arrays.asList(itemNeed);
			
			if(itemneeded.contains(name))
			{
				driver.findElements(add).get(i).click();
				j++;
			}
			
			if(j==name.length())
			{
				break;
			}
		}
	}
	
	
}
