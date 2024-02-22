package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDataHelper {

    /**
     * Валидный идентификатор питомца
     */
    public static final String VALID_PET_ID = "10";

    /**
     * Не валидный идентификатор питомца
     */
    public static final String NOT_VALID_PET_ID = "Kotik";

    /**
     * Идентификатор питомца для удаления
     */
    public static final String DELETE_PET_ID = "0";

    /**
     * Статус код успешного результата запроса
     */
    public static final int STATUS_CODE_OK = 200;

    /**
     * Статус код 500 не успешного результата запроса
     */
    public static final int STATUS_CODE_ERROR_500 = 500;

    /**
     * Статус код 404 питомец не найден
     */
    public static final int STATUS_CODE_ERROR_404 = 404;

    /**
     * Валидный идентификатор категории
     */
    public static final int VALID_CATEGORY_ID = 0;

    /**
     * Валидный идентификатор тэга
     */
    public static final int VALID_TAG_ID = 510;

    /**
     * Валидное имя тэга
     */
    public static final String VALID_TAG_NAME = "tagOne";

    /**
     * Валидный статус питомца
     */
    public static final String AVAILABLE_STATUS = "available";

    /**
     * Имя питомца для изменений
     */
    public static final String CHANGED_NAME = "Cat333";

    /**
     * Спец.символ вместо идентификатора питомца
     */
    public static final String AT_SYMBOL_PET_ID = "@";

    /**
     * Валидный статус заявки в магазине
     */
    public static final String VALID_STATUS = "placed";

    /**
     * Идентификатор заявки для удаления
     */
    public static final String DELETE_ORDER_ID = "0";

    /**
     * Экземпляр класса Faker
     */
    private static final Faker faker = new Faker();

    /**
     * Метод получения случайного имени питомца
     *
     * @return случайное имя питомца
     */
    public static String getRandomPetName() {
        return faker.cat().name();
    }

    /**
     * Метод получения случайного имени категории
     *
     * @return случайное имя категории
     */
    public static String getRandomCategoryName() {
        return faker.cat().breed();
    }

    /**
     * Метод получения случайного URL
     *
     * @return случайное URL
     */
    public static String getRandomUrl() {
        return faker.internet().url();
    }

    /**
     * Метод генерации случайного числа
     *
     * @return случайное число
     */
    public static String getRandomNumber() {
        int randomNumber = faker.random().nextInt(100) + 1;
        return String.valueOf(randomNumber);
    }

    /**
     * Метод генерации случайной даты
     *
     * @return случайную дату
     */
    public static String getRandomDate() {
        String dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        Date date = faker.date().past(1, java.util.concurrent.TimeUnit.DAYS);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeFormat);
        return simpleDateFormat.format(date);
    }

    /**
     * Метод генерации случайного типа boolean
     *
     * @return случайное значение типа boolean
     */
    public static boolean getRandomBoolean() {
        return faker.random().nextBoolean();
    }
}