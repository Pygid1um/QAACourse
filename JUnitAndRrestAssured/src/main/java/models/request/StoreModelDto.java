package models.request;

import lombok.Builder;
import lombok.Data;

/**
 * Поля для сериализации в JSON объект, тела запроса
 */
@Data
@Builder
public class StoreModelDto {
    private final String id;
    private final String petId;
    private final String quantity;
    private final String shipDate;
    private final String status;
    private final boolean complete;
}