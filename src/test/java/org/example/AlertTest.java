package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertTest extends BaseTest {
    @Test
    void checkAlert() {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("[onclick='myFunction\\(\\)'] p")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        waiting();
        assertEquals("I am an alert box!", driver.switchTo().alert().getText());


    }

    @Test
    void checkConfirmBox() {

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(By.cssSelector("[onclick='confirmAlert\\(\\)'] p")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        waiting();
        assertEquals("Press a button!", driver.switchTo().alert().getText());

        alert.accept();
        waiting();
        assertEquals("You pressed OK!", driver.findElement(By.cssSelector("#confirm-alert-text")).getText());


    }

    @Test
    void checkModalPopup() {


        driver.findElement(By.cssSelector("[data-toggle] p")).click();
        waiting();
        assertEquals("We can inject and use JavaScript code if all else fails! Remember always try to use WebDriver Library method(s) first such as WebElement.click(). (The Selenium development team have spent allot of time developing WebDriver functions etc).", driver.findElement(By.cssSelector(".modal-body p")).getText());

        driver.findElement(By.cssSelector(".modal-footer [data-dismiss]")).click();
    }

    @Test
    void checkModalPopupWait() {

        driver.findElement(By.cssSelector("#button3")).click();

        WebElement modal = driver.findElement(By.cssSelector("span#button1 > p"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(7));


        wait.until(ExpectedConditions.visibilityOf(modal));
        modal.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-title")));
        assertEquals("Well Done For Waiting....!!!", driver.findElement(By.cssSelector(".modal-title")).getText());
        driver.findElement(By.cssSelector(".modal-footer [data-dismiss]")).click();

    }
}