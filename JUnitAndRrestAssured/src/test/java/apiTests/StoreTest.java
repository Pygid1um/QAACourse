package apiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.request.StoreModelDto;
import models.response.ErrorModelDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.RequestObjectBuilder;
import utils.ResponseObjectBuilder;
import utils.ResponseWrapper;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static utils.TestDataHelper.*;

@Epic("Store контроллер")
@Feature("Добавление заявки в магазин")
public class StoreTest extends BaseTest {

    /**
     * Метод для создания тестовых данных для некоторых тестов
     */
    @BeforeEach
    public void generateTestData() {
        StoreModelDto generateDataRequest = RequestObjectBuilder.addNewStoreModel(VALID_PET_ID);
        ResponseWrapper generateDataTestData = steps.createOrderToStore(generateDataRequest);
        createdStoreTestData = generateDataTestData.as(StoreModelDto.class);
    }

    @Test
    @DisplayName("Добавление новой заявки в магазин c валидным ID питомца")
    public void addNewOrderToStorePositive() {

        step("Создание тела запроса заявки с валидным ID питомца", () -> {
            requestStore = RequestObjectBuilder.addNewStoreModel(VALID_PET_ID);
        });

        step("Выполнение POST запроса на создание заявки", () -> {
            responseWrapper = steps.createOrderToStore(requestStore);
        });

        step("Выполнение GET запроса для получения данных о созданной заявке", () -> {
            getResult = steps.getOrderStore(requestStore.getId());
        });

        step("Проверка результата создания заявки", () -> {
            StoreModelDto createResponse = responseWrapper.as(StoreModelDto.class);
            StoreModelDto getCreatedResponse = getResult.as(StoreModelDto.class);
            int statusCode = responseWrapper.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(createResponse.getId())
                                .isEqualTo(getCreatedResponse.getId());
                        softAssertions
                                .assertThat(statusCode)
                                .isEqualTo(STATUS_CODE_OK);
                    });
        });
    }

    @Test
    @DisplayName("Добавление новой заявки в магазин c невалидным ID питомца")
    public void addNewOrderToStoreNegative() {

        step("Создание тела запроса заявки с невалидным ID питомца", () -> {
            requestStore = RequestObjectBuilder.addNewStoreModel(NOT_VALID_PET_ID);
        });

        step("Выполнение POST запроса на создание питомца", () -> {
            responseWrapper = steps.createOrderToStore(requestStore);
        });

        step("Проверка получения ошибки", () -> {
            ErrorModelDto errorResponse = responseWrapper.as(ErrorModelDto.class);
            int statusCode = responseWrapper.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(errorResponse)
                                .isEqualTo(ResponseObjectBuilder.getUnknownErrorResponse());
                        softAssertions
                                .assertThat(statusCode)
                                .isEqualTo(STATUS_CODE_ERROR_500);
                    });
        });
    }

    @Test
    @DisplayName("Получение данных о заявки в магазине")
    public void getOrderToStorePositive() {

        step("Выполнение GET запроса для получения данных о заявке", () -> {
            responseWrapper = steps.getOrderStore(createdStoreTestData.getId());
            getResult = steps.getOrderStore(createdStoreTestData.getId());
        });

        step("Проверка результата полученных данных", () -> {
            StoreModelDto changeResponse = responseWrapper.as(StoreModelDto.class);
            StoreModelDto getChangedResponse = getResult.as(StoreModelDto.class);
            int statusCode = responseWrapper.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(changeResponse.getId())
                                .isEqualTo(getChangedResponse.getId());
                        softAssertions
                                .assertThat(statusCode)
                                .isEqualTo(STATUS_CODE_OK);
                    });
        });
    }

    @Test
    @DisplayName("Получение данных о несуществующей заявки в магазине")
    public void getOrderToStoreNegative() {

        step("Выполнение GET запроса для получения данных о несуществующей заявке в магазине", () -> {
            getResult = steps.getOrderStore("0");
        });

        step("Проверка получения ошибки", () -> {
            ErrorModelDto errorResponse = getResult.as(ErrorModelDto.class);
            int statusCode = getResult.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(errorResponse)
                                .isEqualTo(ResponseObjectBuilder.getNotFoundOrderErrorResponse());
                        softAssertions
                                .assertThat(statusCode)
                                .isEqualTo(STATUS_CODE_ERROR_404);
                    });
        });
    }

    @Test
    @DisplayName("Удаление существующего заявки в магазине")
    public void deleteOrderToStorePositive() {

        step("Выполнение DELETE запроса для удаления заявки", () -> {
            responseWrapper = steps.deleteOrderToStore(createdStoreTestData.getId());
        });

        step("Выполнение GET запроса для получения данных о удаленной заявки", () -> {
            getResult = steps.getOrderStore(createdStoreTestData.getId());
        });

        step("Проверка результата удаления питомца", () -> {
            ErrorModelDto deletePetResponse = responseWrapper.as(ErrorModelDto.class);
            ErrorModelDto getDeletedResponse = getResult.as(ErrorModelDto.class);
            int deletePetStatusCode = responseWrapper.getStatusCode();
            int getDeletedStatusCode = getResult.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(deletePetResponse)
                                .isEqualTo(ResponseObjectBuilder.deleteOrderResponse(createdStoreTestData.getId()));
                        softAssertions
                                .assertThat(getDeletedResponse)
                                .isEqualTo(ResponseObjectBuilder.getNotFoundOrderErrorResponse());
                        softAssertions
                                .assertThat(deletePetStatusCode)
                                .isEqualTo(STATUS_CODE_OK);
                        softAssertions
                                .assertThat(getDeletedStatusCode)
                                .isEqualTo(STATUS_CODE_ERROR_404);
                    });
        });
    }

    @Test
    @DisplayName("Удаление несуществующей заявки в магазине")
    public void deletePetStoreNegative() {

        step("Выполнение DELETE запроса для удаления несуществующей заявки в магазине", () -> {
            responseWrapper = steps.deleteOrderToStore(DELETE_ORDER_ID);
        });

        step("Проверка результата удаления несуществующей заявки в магазине", () -> {
            int deletePetStatusCode = responseWrapper.getStatusCode();
            assertThat(deletePetStatusCode).isEqualTo(STATUS_CODE_ERROR_404);
        });
    }
}