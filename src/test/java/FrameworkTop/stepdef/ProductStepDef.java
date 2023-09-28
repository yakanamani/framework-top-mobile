package FrameworkTop.stepdef;

import FrameworkTop.pages.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import FrameworkTop.pages.ProductDetailsPage;
import FrameworkTop.pages.ProductsPage;

public class ProductStepDef {
    ProductsPage productsPage =new ProductsPage();
    BasePage basePage = new BasePage();
    @Then("I should see Products page with title {string}")
    public void iShouldSeeProductsPageWithTitle(String title) {
        Assert.assertEquals(productsPage.getTitle(), title);
    }
    @Then("the product is listed with title {string} and price {string}")
    public void theProductIsListedWithTitleAndPrice(String title, String price) throws Exception {
        Boolean checkTitle = productsPage.getProductTitle(title).equalsIgnoreCase(title);
        Assert.assertTrue(checkTitle);
        basePage.closeApp();
    }



    @When("I click product title {string}")
    public void iClickProductTitle(String title) throws Exception {
        productsPage.pressProductTitle(title);
    }

    @Then("I should be on product details page with title {string}, price {string} and description {string}")
    public void iShouldBeOnProductDetailsPageWithTitlePriceAndDescription(String title, String price, String description) throws Exception {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        boolean titleCheck = productDetailsPage.getTitle().equalsIgnoreCase(title);
        boolean descCheck = productDetailsPage.getDesc().equalsIgnoreCase(description);
        boolean priceCheck = productDetailsPage.getPrice().equalsIgnoreCase(price);
        Assert.assertTrue("titleCheck = " + titleCheck + ", descCheck = " + descCheck + ", priceCheck = " + priceCheck,
                titleCheck & descCheck & priceCheck);
    }
}
