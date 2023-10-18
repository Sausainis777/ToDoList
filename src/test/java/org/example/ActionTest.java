package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionTest extends BaseTest {

    @Test
    void dragAndDrop() {

        WebElement clickable = driver.findElement(By.cssSelector("#draggable p"));
        WebElement hoverable = driver.findElement(By.cssSelector("#droppable"));
        new Actions(driver)
                .clickAndHold(clickable)
                .moveToElement(hoverable)
                .click(clickable)
                .perform();
        assertEquals("Dropped!", driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());
    }

    @Test
    void doubleClick() {

        WebElement element = driver.findElement(By.xpath("/html//div[@id='double-click']"));
        Actions click = new Actions(driver);
        click.doubleClick(element).perform();
        waiting();
        assertEquals("div-double-click double", driver.findElement(By.xpath("/html//div[@id='double-click']")).getAttribute("class"));
    }

    @Test
    void clickAndHold() {
        WebElement clickable = driver.findElement(By.xpath("//div[@id='click-box']/p[.='Click and Hold!']"));

        new Actions(driver)
                .clickAndHold(clickable)
                .perform();
        waiting();
        assertEquals("background: rgb(0, 255, 0); font-size: 30px;", driver.findElement(By.xpath("/html//div[@id='click-box']")).getAttribute("style"));
    }

    @Test
    void hover() {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement hoverable = driver.findElement(By.cssSelector("div:nth-of-type(1) > .dropbtn"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();
        driver.findElement(By.className("list-alert")).click();
        waiting();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals("Well done you clicked on the link!", driver.switchTo().alert().getText());
        alert.dismiss();
    }
}
