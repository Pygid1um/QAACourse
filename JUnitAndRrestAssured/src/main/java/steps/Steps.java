package steps;

import io.restassured.specification.RequestSpecification;
import models.request.PetModelDto;
import models.request.StoreModelDto;
import utils.ResponseWrapper;

import static io.restassured.RestAssured.given;

/**
 * Класс с реализацией всех Rest шагов
 */
public class Steps {

    /**
     * Экземпляр спецификации RestAssured
     */
    private final RequestSpecification petStoreRequestSpecification;

    /**
     * Часть URL для POST запросов создания питомцев
     */
    private static final String POST_PET_PATH = "/pet";

    /**
     * Часть URL для PUT запросов редактирования питомцев
     */
    private static final String PUT_PET_PATH = "/pet";

    /**
     * Часть URL для GET запроса поиска питомцев
     */
    private static final String GET_PET_PATH = "/pet/";

    /**
     * Часть URL для DELETE запроса удаления питомцев
     */
    private static final String DELETE_PET_PATH = "/pet/";

    /**
     * Часть URL для POST запроса создания заявки в магазине
     */
    private static final String POST_STORE_PATH = "/store/order";

    /**
     * Часть URL для GET запроса поиска заявки в магазине
     */
    private static final String GET_STORE_PATH = "/store/order/";

    /**
     * Часть URL для DELETE запроса удаления заявки в магазине
     */
    private static final String DELETE_STORE_PATH = "/store/order/";

    /**
     * Конструктор для создания экземпляра класса
     *
     * @param requestSpecification спецификация RestAssured
     */
    public Steps(RequestSpecification requestSpecification) {
        this.petStoreRequestSpecification = requestSpecification;
    }

    /**
     * Метод создания питомца
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper createPetToStore(PetModelDto request) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .body(request)
                .post(POST_PET_PATH)
                .andReturn());
    }

    /**
     * Метод поиска питомцев по ID
     *
     * @param petId ID питомца
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper getPetToStore(String petId) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .get(GET_PET_PATH + petId)
                .andReturn());
    }

    /**
     * Метод редактирования созданного питомца
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper changePetToStore(PetModelDto request) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .body(request)
                .put(PUT_PET_PATH)
                .andReturn());
    }

    /**
     * Метод удаления созданного питомца
     *
     * @param petId ID питомца
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper deletePetToStore(String petId) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .delete(DELETE_PET_PATH + petId)
                .andReturn());
    }

    /**
     * Метод создания заявки в магазине
     *
     * @param request тело запроса
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper createOrderToStore(StoreModelDto request) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .body(request)
                .post(POST_STORE_PATH)
                .andReturn());
    }

    /**
     * Метод поиска заявки в магазине
     *
     * @param orderId ID заявки
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper getOrderStore(String orderId) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .get(GET_STORE_PATH + orderId)
                .andReturn());
    }

    /**
     * Метод удаления созданной заявки в магазине
     *
     * @param orderId ID заявки
     * @return оболочка для работы с ответом
     */
    public ResponseWrapper deleteOrderToStore(String orderId) {
        return new ResponseWrapper(given(petStoreRequestSpecification)
                .when()
                .delete(DELETE_STORE_PATH + orderId)
                .andReturn());
    }
}