package base;

import config.BaseConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import steps.Steps;

/**
 * Базовый тестовый класс с общими настройками
 */
public class BaseTest {

    /**
     * Экземпляр интерфейса с конфигурацией
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getProperties());

    /**
     * Экземпляр класса с REST шагами
     */
    protected final Steps steps = new Steps(getPetStoreRequestSpecification());

    /**
     * Метод для получения спецификации RestAssured
     * baseUrl - базовый URL
     * contentType - параметр в header со значением JSON
     * accept - параметр в header со значением JSON
     * filter - создает фильтр для allure
     * log - логирование всех деталей
     *
     * @return спецификация
     */
    private RequestSpecification getPetStoreRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(config.baseUrl())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .log(LogDetail.ALL)
                .build();
    }
}