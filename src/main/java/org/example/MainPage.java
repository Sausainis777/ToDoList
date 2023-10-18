package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    WebDriver driver;
    By clickToAddToDoList = By.cssSelector("input");
    By enterToDoList = By.cssSelector("input");
    By clickEnter = By.cssSelector("input");
    By clickToFinishWorkList = By.xpath("//div[@id='container']/ul/li[4]");

    By clickDelete = By.xpath("//div[@id='container']/ul/li[@class='completed']/span/i[@class='fa fa-trash']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToDoList() {
        driver.findElement(clickToAddToDoList).click();
    }

    public void enterToDoList() {
        driver.findElement(enterToDoList).sendKeys("Pamėgoti");
    }

    public void clickEnter() {
        driver.findElement(clickEnter).sendKeys(Keys.ENTER);
    }

    public void clickToFinishWorkList() {
        driver.findElement(clickToFinishWorkList).click();
    }

    public void clickDelete() {
        driver.findElement(clickDelete).click();
    }


    public int getNumberOfTodoItemsWithText(String text) {
        return driver.findElements(By.xpath("//ul//li[text()=' " + text + "']")).size();

    }

    public void deleteList(String text) {
       driver.findElement(By.xpath("//ul//li[text()=' " + text + "']/span/i[@class='fa fa-trash']")).click();

    }
}

