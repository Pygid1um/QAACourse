import configs.BaseConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Общий класс с настройками для всех тестов
 */
public class BaseTest {

    /**
     * Переменная экземпляра драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getProperties());

    /**
     * Общие настройки для всех тестов перед выполнением каждого
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(config.url());
    }

    /**
     * Общие настройки для всех тестов после выполнением каждого
     */
    @AfterMethod
    public void closeDriver() {
        driver.close();
    }
}