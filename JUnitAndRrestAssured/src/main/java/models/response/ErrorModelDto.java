package models.response;

import lombok.Builder;
import lombok.Data;

/**
 * Поля для сериализации в JSON объект типа ошибка, тела ответа
 */
@Data
@Builder
public class ErrorModelDto {
    private final Integer code;
    private final String type;
    private final String message;
}