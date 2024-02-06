import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Основной класс с тестами на страницу Avito
 */
@Epic("AvitoTest")
public class AvitoTest extends BaseTest {

    @Test(description = "Вывод первых 5 ссылок результатов поиска в консоль")
    @Feature("Вывод результатов поиска")
    public void draft() {
        new HomePage(driver)
                .selectAllCategories()
                .selectCategoryElectronics()
                .selectCategoryConsumables()
                .clickCheckBox()
                .inputGoodsInSearchField()
                .selectCityPopUp()
                .searchCity()
                .showAds()
                .chooseInDropDown()
                .printFirstUrlSpecifiedNumber(5);
    }
}