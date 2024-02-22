package apiTests;

import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.request.PetModelDto;
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

@Epic("Pet контроллер")
@Feature("Добавление нового питомца в магазин")
public class PetTest extends BaseTest {

    /**
     * Метод для создания тестовых данных для некоторых тестов
     */
    @BeforeEach
    public void generateTestData() {
        PetModelDto generateDataRequest = RequestObjectBuilder.addNewPetModel(VALID_PET_ID);
        ResponseWrapper generateDataTestData = steps.createPetToStore(generateDataRequest);
        createdPetTestData = generateDataTestData.as(PetModelDto.class);
    }

    @Test
    @DisplayName("Добавление нового питомца в магазин c валидным ID")
    public void addNewPetStorePositive() {

        step("Создание тела запроса с валидным ID", () -> {
            requestPet = RequestObjectBuilder.addNewPetModel(VALID_PET_ID);
        });

        step("Выполнение POST запроса на создание питомца", () -> {
            responseWrapper = steps.createPetToStore(requestPet);
        });

        step("Выполнение GET запроса для получения данных созданного питомца", () -> {
            getResult = steps.getPetToStore(requestPet.getId());
        });

        step("Проверка результата создания питомца", () -> {
            PetModelDto createResponse = responseWrapper.as(PetModelDto.class);
            PetModelDto getCreatedResponse = getResult.as(PetModelDto.class);
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
    @DisplayName("Добавление нового питомца в магазин c невалидным ID")
    public void addNewPetStoreNegative() {

        step("Создание тела запроса с невалидным ID", () -> {
            requestPet = RequestObjectBuilder.addNewPetModel(NOT_VALID_PET_ID);
        });

        step("Выполнение POST запроса на создание питомца", () -> {
            responseWrapper = steps.createPetToStore(requestPet);
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
    @DisplayName("Изменение имени у существующего питомца")
    public void changePetStorePositive() {

        step("Выполнение PUT запроса на редактирование питомца", () -> {
            createdPetTestData.setName(CHANGED_NAME);
            responseWrapper = steps.changePetToStore(createdPetTestData);
        });

        step("Выполнение GET запроса для получения данных редактируeмого питомца", () -> {
            getResult = steps.getPetToStore(createdPetTestData.getId());
        });

        step("Проверка результата редактирования питомца", () -> {
            PetModelDto changeResponse = responseWrapper.as(PetModelDto.class);
            PetModelDto getChangedResponse = getResult.as(PetModelDto.class);
            int statusCode = responseWrapper.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(changeResponse.getId())
                                .isEqualTo(getChangedResponse.getId());
                        softAssertions
                                .assertThat(changeResponse.getName())
                                .isEqualTo(getChangedResponse.getName());
                        softAssertions
                                .assertThat(statusCode)
                                .isEqualTo(STATUS_CODE_OK);
                    });
        });
    }

    @Test
    @DisplayName("Изменение ID питомца на спецсимвол")
    public void changePetStoreNegative() {

        step("Выполнение PUT запроса редактирования ID питомца на спецсимвол", () -> {
            createdPetTestData.setId(AT_SYMBOL_PET_ID);
            responseWrapper = steps.changePetToStore(createdPetTestData);
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
    @DisplayName("Получение данных о питомце")
    public void getPetStorePositive() {

        step("Выполнение GET запроса для получения данных о питомце", () -> {
            responseWrapper = steps.createPetToStore(createdPetTestData);
            getResult = steps.getPetToStore(createdPetTestData.getId());
        });

        step("Проверка результата полученных данных", () -> {
            PetModelDto changeResponse = responseWrapper.as(PetModelDto.class);
            PetModelDto getChangedResponse = getResult.as(PetModelDto.class);
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
    @DisplayName("Получение данных о несуществующем питомце")
    public void getPetStoreNegative() {

        step("Выполнение GET запроса для получения данных о несуществующем питомце", () -> {
            getResult = steps.getPetToStore("0");
        });

        step("Проверка получения ошибки", () -> {
            ErrorModelDto errorResponse = getResult.as(ErrorModelDto.class);
            int statusCode = getResult.getStatusCode();

            assertSoftly(
                    softAssertions -> {
                        softAssertions
                                .assertThat(errorResponse)
                                .isEqualTo(ResponseObjectBuilder.getNotFoundPetErrorResponse());
                        softAssertions
                                .assertThat(statusCode)
                                .isEqualTo(STATUS_CODE_ERROR_404);
                    });
        });
    }

    @Test
    @DisplayName("Удаление существующего питомца")
    public void deletePetStorePositive() {

        step("Выполнение DELETE запроса для удаления питомца", () -> {
            responseWrapper = steps.deletePetToStore(createdPetTestData.getId());
        });

        step("Выполнение GET запроса для получения данных о удаленном питомце", () -> {
            getResult = steps.getPetToStore(createdPetTestData.getId());
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
                                .isEqualTo(ResponseObjectBuilder.deletePetResponse(createdPetTestData.getId()));
                        softAssertions
                                .assertThat(getDeletedResponse)
                                .isEqualTo(ResponseObjectBuilder.getNotFoundPetErrorResponse());
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
    @DisplayName("Удаление несуществующего питомца")
    public void deletePetStoreNegative() {

        step("Выполнение DELETE запроса для удаления несуществующего питомца", () -> {
            responseWrapper = steps.deletePetToStore(DELETE_PET_ID);
        });

        step("Проверка результата удаления несуществующего питомца", () -> {
            int deletePetStatusCode = responseWrapper.getStatusCode();
            assertThat(deletePetStatusCode).isEqualTo(STATUS_CODE_ERROR_404);
        });
    }
}