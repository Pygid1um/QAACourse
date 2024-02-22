package utils;

import models.response.ErrorModelDto;

import static utils.TestDataHelper.STATUS_CODE_ERROR_500;
import static utils.TestDataHelper.STATUS_CODE_OK;

public class ResponseObjectBuilder {

    /**
     * Код 1 когда питомец не найден
     */
    private static final int NOT_FOUND_CODE = 1;

    /**
     * Тип неизвестной ошибки
     */
    private static final String UNKNOWN_TYPE = "unknown";

    /**
     * Тип ошибки когда питомец не найден
     */
    private static final String ERROR_TYPE = "error";

    /**
     * Сообщение неизвестной 500 ошибки
     */
    private static final String UNKNOWN_MESSAGE = "something bad happened";

    /**
     * Сообщение ошибки когда питомец не найден
     */
    private static final String PET_NOT_FOUND_MESSAGE = "Pet not found";

    /**
     * Сообщение ошибки когда заказ не найден
     */
    private static final String ORDER_NOT_FOUND_MESSAGE = "Order not found";

    /**
     * Метод формирования ожидаемого результата неизвестной 500 ошибки
     *
     * @return тело ошибки
     */
    public static ErrorModelDto getUnknownErrorResponse() {
        return ErrorModelDto.builder()
                .code(STATUS_CODE_ERROR_500)
                .type(UNKNOWN_TYPE)
                .message(UNKNOWN_MESSAGE)
                .build();
    }

    /**
     * Метод формирования ожидаемого результата 404 ошибки, питомец не найден
     *
     * @return тело ошибки
     */
    public static ErrorModelDto getNotFoundPetErrorResponse() {
        return ErrorModelDto.builder()
                .code(NOT_FOUND_CODE)
                .type(ERROR_TYPE)
                .message(PET_NOT_FOUND_MESSAGE)
                .build();
    }

    /**
     * Метод формирования ожидаемого результата 200 кода ответа, питомец удален
     *
     * @return тело ошибки
     */
    public static ErrorModelDto deletePetResponse(String id) {
        return ErrorModelDto.builder()
                .code(STATUS_CODE_OK)
                .type(UNKNOWN_TYPE)
                .message(id)
                .build();
    }

    /**
     * Метод формирования ожидаемого результата 404 ошибки, заказ не найден
     *
     * @return тело ошибки
     */
    public static ErrorModelDto getNotFoundOrderErrorResponse() {
        return ErrorModelDto.builder()
                .code(NOT_FOUND_CODE)
                .type(ERROR_TYPE)
                .message(ORDER_NOT_FOUND_MESSAGE)
                .build();
    }

    /**
     * Метод формирования ожидаемого результата 200 кода ответа, заявка удалена
     *
     * @return тело ошибки
     */
    public static ErrorModelDto deleteOrderResponse(String id) {
        return ErrorModelDto.builder()
                .code(STATUS_CODE_OK)
                .type(UNKNOWN_TYPE)
                .message(id)
                .build();
    }
}