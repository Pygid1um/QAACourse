package pages;

import configs.AvitoConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ScreenHelper;
import utils.Waiters;

public class HomePage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Экземпляр конфигурации с параметрами для Avito тестов
     */
    AvitoConfig avitoConfig = ConfigFactory.create(AvitoConfig.class, System.getProperties());

    /**
     * Элемент раскрывающий все категории товаров
     */
    @FindBy(xpath = "//div[@class='top-rubricator-rubricatorButton-SoKyQ']")
    private WebElement allCategories;

    /**
     * Элемент выбора категории 'Электроника'
     */
    @FindBy(xpath = "//p[text()='Электроника']")
    private WebElement categoryElectronics;

    /**
     * Элемент выбора подкатегории 'Оргтехника и расходники'
     */
    @FindBy(xpath = "//a[@href='/penza/orgtehnika_i_rashodniki']")
    private WebElement categoryConsumables;

    /**
     * Элемент выбора чекбокса 'Новые' товары
     */
    @FindBy(xpath = "//span[text()='Новые']")
    private WebElement checkboxNewGoods;

    /**
     * Элемент с полем поиска товаров
     */
    @FindBy(xpath = "//input[@data-marker='search-form/suggest']")
    private WebElement searchFieldGoods;

    /**
     * Элемент выбора города
     */
    @FindBy(xpath = "//div[@class='main-richTitleWrapper-bl4mK']")
    private WebElement chooseCityPopUp;

    /**
     * Элемент очищающий поле поиска города
     */
    @FindBy(xpath = "//div[@class='suggest-icon-qI_yN']")
    private WebElement clearCitySearchField;

    /**
     * Элемент с полем поиска городов
     */
    @FindBy(xpath = "//input[@data-marker='popup-location/region/input']")
    private WebElement searchFieldCities;

    /**
     * Элемент с городом Владивосток
     */
    @FindBy(xpath = "//strong[text()='Владивосток']")
    private WebElement city;

    /**
     * Элемент выбора n объявлений
     */
    @FindBy(xpath = "//button[@class='desktop-xujs2d']")
    private WebElement showAds;

    /**
     * Элемент раскрывающий выпадающий список 'Сортировка'
     */
    @FindBy(xpath = "//div[@class='index-topPanel-McfCA']/div[2]/div")
    private WebElement dropDownList;

    /**
     * Элемент с выбором 'Дороже' в выпадающем списке
     */
    @FindBy(xpath = "//button[@data-marker='sort/custom-option(2)']")
    private WebElement chooseExpensive;

    /**
     * Конструктор создания HomePage
     * @param driver драйвер для управления браузером
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод раскрытия всех категорий на главной странице
     * @return текущая страница
     */
    @Step("Раскрытие списка 'Все категории'")
    public HomePage selectAllCategories() {
        Waiters.waitUntilVisible(driver, allCategories);
        allCategories.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для выбора категории 'Электроника'
     * @return текущая страница
     */
    @Step("Выбор категории 'Электроника'")
    public HomePage selectCategoryElectronics() {
        switchToWindow();
        Waiters.waitUntilVisible(driver, categoryElectronics);
        coverByElement(categoryElectronics);
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для выбора подкатегории 'Оргтехника и расходники'
     * @return текущая страница
     */
    @Step("Выбор подкатегории 'Оргтехника и расходники'")
    public HomePage selectCategoryConsumables() {
        categoryConsumables.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора чекбокса 'Новые'
     * @return текущая страница
     */
    @Step("Клик чекбокса 'Новые'")
    public HomePage clickCheckBox() {
        checkboxNewGoods.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода товара в поле поиска
     * @return текущая страница
     */
    @Step("Ввод товара в поле поиска")
    public HomePage inputGoodsInSearchField() {
        searchFieldGoods.sendKeys(avitoConfig.inputSearchPrinter());
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод перехода для выбора города
     * @return текущая страница
     */
    @Step("Раскрытие поп-апа выбора города")
    public HomePage selectCityPopUp() {
        Waiters.waitUntilVisible(driver, chooseCityPopUp);
        chooseCityPopUp.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора города
     * @return текущая страница
     */
    @Step("Выбор города")
    public HomePage searchCity() {
        Waiters.waitUntilVisible(driver, clearCitySearchField);
        clearCitySearchField.click();
        searchFieldCities.sendKeys(avitoConfig.inputSearchCity());
        Waiters.waitUntilVisible(driver, city);
        city.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбирающий n объявлений
     * @return текущая страница
     */
    @Step("Выбор найденных объявлений в выбранном городе")
    public HomePage showAds() {
        Waiters.waitUntilVisible(driver, showAds);
        showAds.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод с выбором 'Дороже' в выпадающем списке
     * @return текущая страница
     */
    @Step("Клик чекбокса 'Дороже'")
    public HomePage chooseInDropDown() {
        Waiters.waitUntilVisible(driver, dropDownList);
        dropDownList.click();
        Waiters.waitUntilVisible(driver, chooseExpensive);
        chooseExpensive.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод печати первых n ссылок элементов
     * @param count количество ссылок
     */
    @Step("Вывод в консоль ссылок первых результатов запроса")
    public void printFirstUrlSpecifiedNumber(int count) {
        for (int i = 1; i <= count; i++) {
            System.out.println(getSearchResultElementByNumber(i).getAttribute(avitoConfig.linkAttribute()));
        }
    }

    /**
     * Метод для переключения на всплывающий попАп на странице категорий
     */
    private void switchToWindow() {
        driver.switchTo().activeElement().findElement(By.xpath("//div[@data-marker='more-popup/target']"));
    }

    /**
     * Метод для наведения курсора мыши на элемент страницы
     * @param element элемент на который наводится курсор мыши
     */
    private void coverByElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * Метод получения элемента по номеру
     * @param elementNumber номер элемента
     * @return элемент результата поиска
     */
    private WebElement getSearchResultElementByNumber(int elementNumber){
        return driver.findElement(By.xpath("//div[@class='items-items-kAJAg']/div[" + elementNumber + "]//a"));
    }
}