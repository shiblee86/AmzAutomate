package com.scratchproject;

import com.setup.BaseSetup;
import com.testpages.HeaderElements;
import com.testpages.Iphone;
import com.testpages.LandingPage;

public class AddToCartValidation extends BaseSetup{
	
	public void addToCart() {
		
		Iphone ip = new Iphone(driver);
		LandingPage lp = new LandingPage(driver);
		HeaderElements he = new HeaderElements(driver);
		
		if(lp.getSearchBox().isEnabled() && lp.getSearchBox().isDisplayed()) {
			lp.getSearchBox().clear();
			lp.getSearchBox().sendKeys("iphone");
			lp.getSearchBox().submit();
		}else {
			System.out.println("Search box is not available");
		}
		
		ip.getShopNowButton().click();
		he.getAddToCartButton().click();
		
	}

}
