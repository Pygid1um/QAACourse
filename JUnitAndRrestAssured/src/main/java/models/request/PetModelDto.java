package models.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Поля для сериализации в JSON объект, тела запроса
 */
@Data
@Builder
public class PetModelDto {
    private String id;
    private final CategoryAndTagsItem category;
    private String name;
    private final List<String> photoUrls;
    private final List<CategoryAndTagsItem> tags;
    private final String status;

    /**
     * Поля для сериализации вложенного объекта в JSON объект, тела запроса
     */
    @Data
    @Builder
    public static class CategoryAndTagsItem {
        private final int id;
        private final String name;
    }
}