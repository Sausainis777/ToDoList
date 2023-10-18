package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest extends BaseTest {

    @Test
    void addWorkList() throws InterruptedException {
        MainPage page = new MainPage(driver);


        page.clickAddToDoList();
        page.enterToDoList();
        page.clickEnter();
        waiting();
        assertEquals("Pamėgoti", driver.findElement(By.xpath("//div[@id='container']/ul/li[4]")).getText());
    }

    @Test
    void finishWorkList() {
        MainPage page = new MainPage(driver);
        page.clickAddToDoList();
        page.enterToDoList();
        page.clickEnter();

        page.clickToFinishWorkList();
        waiting();
        assertEquals("completed", driver.findElement(By.xpath("//div[@id='container']/ul/li[4]")).getAttribute("class"));

    }

    @Test
    void deleteWorkList() {
        MainPage page = new MainPage(driver);

        page.clickAddToDoList();
        page.enterToDoList();
        page.clickEnter();

        page.clickToFinishWorkList();

        page.getNumberOfTodoItemsWithText("Pamėgoti");
        page.deleteList("Pamėgoti");
        waiting();

//        WebElement deleteLink = null;
//        try {
//            deleteLink = driver.findElement(By.xpath("//div[@id='container']/ul/li[4]"));
//        } catch (NoSuchElementException e) {
//
//        }
//        assertFalse(deleteLink != null);


        assertEquals(0,page.getNumberOfTodoItemsWithText(" Pamėgoti"));


    }


}
