package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс с методами явного ожидания
 */
public class Waiters {

    /**
     * Ожидает в течении 4 секунд появления элемента на странице.
     *
     * @param driver  экземпляр драйвера браузера
     * @param element элемент
     */
    public static void waitUntilVisibleElement(WebDriver driver, WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Ожидает в течении 5 секунд появления текста в элементе.
     *
     * @param driver  экземпляр драйвера браузера
     * @param element элемент в котором должен появиться текст
     * @param text    текст
     */
    public static void waitUntilVisibleText(WebDriver driver, WebElement element, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}