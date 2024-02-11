package pages;

import io.qameta.allure.Step;
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
     * Элемент раскрывающий все категории товаров
     */
    @FindBy(xpath = "//div[@class='top-rubricator-rubricatorButton-SoKyQ']")
    private WebElement allCategoriesButton;

    /**
     * Элемент выбора категории 'Электроника'
     */
    @FindBy(xpath = "//p[text()='Электроника']")
    private WebElement electronicsCategory;

    /**
     * Элемент выбора подкатегории 'Оргтехника и расходники'
     */
    @FindBy(xpath = "//a[@href='/penza/orgtehnika_i_rashodniki']")
    private WebElement consumablesSubcategory;

    /**
     * Элемент выбора чекбокса 'Новые' товары
     */
    @FindBy(xpath = "//span[text()='Новые']")
    private WebElement newGoodsCheckbox;

    /**
     * Элемент с полем поиска товаров
     */
    @FindBy(xpath = "//input[@data-marker='search-form/suggest']")
    private WebElement searchGoodsField;

    /**
     * Элемент выбора города
     */
    @FindBy(xpath = "//div[@class='main-richTitleWrapper-bl4mK']")
    private WebElement chooseCityPopUp;

    /**
     * Элемент очищающий поле поиска города
     */
    @FindBy(xpath = "//div[@class='suggest-icon-qI_yN']")
    private WebElement citySearchFieldClear;

    /**
     * Элемент с полем поиска городов
     */
    @FindBy(xpath = "//input[@data-marker='popup-location/region/input']")
    private WebElement searchCitiesField;

    /**
     * Элемент выбора n объявлений
     */
    @FindBy(xpath = "//button[@class='desktop-xujs2d']")
    private WebElement selectAds;

    /**
     * Элемент раскрывающий выпадающий список 'Сортировка'
     */
    @FindBy(xpath = "//div[@class='index-topPanel-McfCA']/div[2]/div")
    private WebElement listDropDown;

    /**
     * Элемент с выбором 'Дороже' в выпадающем списке
     */
    @FindBy(xpath = "//button[@data-marker='sort/custom-option(2)']")
    private WebElement expensiveChoose;

    /**
     * Элемент с первым совпадением при поиске города
     */
    @FindBy(xpath = "//ul[@class='suggest-suggests-CzXfs']/li[1]/span/span/span")
    private WebElement firstCityInDropDown;

    /**
     * Конструктор создания HomePage
     *
     * @param driver драйвер для управления браузером
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод раскрытия всех категорий на главной странице
     *
     * @return текущая страница
     */
    @Step("Раскрытие списка 'Все категории'")
    public HomePage expansionAllCategories() {
        Waiters.waitUntilVisibleElement(driver, allCategoriesButton);
        allCategoriesButton.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для выбора категории 'Электроника'
     *
     * @return текущая страница
     */
    @Step("Выбор категории 'Электроника'")
    public HomePage selectCategoryElectronics() {
        switchToWindow();
        Waiters.waitUntilVisibleElement(driver, electronicsCategory);
        coverByElement(electronicsCategory);
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод для выбора подкатегории 'Оргтехника и расходники'
     *
     * @return текущая страница
     */
    @Step("Выбор подкатегории 'Оргтехника и расходники'")
    public HomePage selectCategoryConsumables() {
        consumablesSubcategory.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора чекбокса 'Новые'
     *
     * @return текущая страница
     */
    @Step("Клик чекбокса 'Новые'")
    public HomePage clickCheckBox() {
        newGoodsCheckbox.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод ввода товара в поле поиска
     *
     * @return текущая страница
     */
    @Step("Ввод товара в поле поиска")
    public HomePage inputGoodsInSearchField(String product) {
        searchGoodsField.sendKeys(product);
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод перехода для выбора города
     *
     * @return текущая страница
     */
    @Step("Раскрытие поп-апа выбора города")
    public HomePage selectCityPopUp() {
        Waiters.waitUntilVisibleElement(driver, chooseCityPopUp);
        chooseCityPopUp.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод клика по кнопке очищения поля поиска города
     *
     * @return текущая страница
     */
    @Step("Клик по кнопке очищения поля поиска города")
    public HomePage clearCitySearchField() {
        Waiters.waitUntilVisibleElement(driver, citySearchFieldClear);
        citySearchFieldClear.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбора города
     *
     * @return текущая страница
     */
    @Step("Выбор города")
    public HomePage selectCity(String searchingCity) {
        Waiters.waitUntilVisibleElement(driver, searchCitiesField);
        searchCitiesField.sendKeys(searchingCity);
        Waiters.waitUntilVisibleText(driver, firstCityInDropDown, searchingCity);
        firstCityInDropDown.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод выбирающий n объявлений
     *
     * @return текущая страница
     */
    @Step("Выбор найденных объявлений в выбранном городе")
    public HomePage selectAllAds() {
        Waiters.waitUntilVisibleElement(driver, selectAds);
        selectAds.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Раскрытие выпадающего списка 'Сортировка'
     *
     * @return текущая страница
     */
    @Step("Раскрытие выпадающего списка 'Сортировка'")
    public HomePage expansionDropDown() {
        Waiters.waitUntilVisibleElement(driver, listDropDown);
        listDropDown.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод с выбором 'Дороже' в выпадающем списке
     *
     * @return текущая страница
     */
    @Step("Выбор 'Дороже' в выпадающем списке")
    public HomePage chooseExpensive() {
        Waiters.waitUntilVisibleElement(driver, expensiveChoose);
        expensiveChoose.click();
        ScreenHelper.makeScreenShot(driver);
        return this;
    }

    /**
     * Метод печати первых n ссылок элементов
     *
     * @param count количество ссылок
     */
    @Step("Вывод в консоль ссылок первых результатов запроса")
    public void printFirstUrlSpecifiedNumber(int count) {
        String linkAttribute = "href";
        for (int i = 1; i <= count; i++) {
            System.out.println(getSearchResultElementByNumber(i).getAttribute(linkAttribute));
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
     *
     * @param element элемент на который наводится курсор мыши
     */
    private void coverByElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * Метод получения элемента по номеру
     *
     * @param elementNumber номер элемента
     * @return элемент результата поиска
     */
    private WebElement getSearchResultElementByNumber(int elementNumber) {
        return driver.findElement(By.xpath("//div[@class='items-items-kAJAg']/div[" + elementNumber + "]//a"));
    }
}