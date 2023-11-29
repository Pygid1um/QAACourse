package homework5;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Epic("Writer. Single test")
@Owner("Практически автотестер, Аносов Д.С.")
public class WriterTests {

    @Feature("Проверка полученного текста из метода класса Writer")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Тест проверяет текст, который возвращает метод класса Writer")
    @Test(description = "Проверка полученного текста")
    public void checkWriterText() {
        Writer writer = new Writer();
        String actual = "Hello World!";
        String expectedResult = writer.getText();
        assertEquals(actual, expectedResult);
    }
}