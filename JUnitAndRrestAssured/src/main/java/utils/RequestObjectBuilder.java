package utils;

import models.request.PetModelDto;
import models.request.StoreModelDto;

import java.util.List;

import static utils.TestDataHelper.*;

/**
 * Вспомогательный класс для формирования тестовых объектов
 */
public class RequestObjectBuilder {

    /**
     * Метод для формирования тела запроса создания питомца
     *
     * @param petID идентификатор питомца
     * @return тело запроса
     */
    public static PetModelDto addNewPetModel(String petID) {
        return PetModelDto.builder()
                .id(petID)
                .category(PetModelDto.CategoryAndTagsItem.builder()
                        .id(VALID_CATEGORY_ID)
                        .name(TestDataHelper.getRandomCategoryName())
                        .build())
                .name(TestDataHelper.getRandomPetName())
                .photoUrls(List.of(TestDataHelper.getRandomUrl()))
                .tags(List.of(PetModelDto.CategoryAndTagsItem.builder()
                        .id(VALID_TAG_ID)
                        .name(VALID_TAG_NAME).build()))
                .status(AVAILABLE_STATUS)
                .build();
    }

    /**
     * Метод для формирования тела запроса создания заказа питомца
     *
     * @param petID идентификатор питомца
     * @return тело запроса
     */
    public static StoreModelDto addNewStoreModel(String petID) {
        return StoreModelDto.builder()
                .id(TestDataHelper.getRandomNumber())
                .petId(petID)
                .quantity(TestDataHelper.getRandomNumber())
                .shipDate(TestDataHelper.getRandomDate())
                .status(VALID_STATUS)
                .complete(TestDataHelper.getRandomBoolean())
                .build();
    }
}