package configs;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов на странице Avito
 */
@Config.Sources({"classpath:avito_tests_config.properties"})
public interface AvitoConfig extends Config {

    /**
     * Метод возвращает параметр seleniumInput из avito_tests_config.properties
     * @return параметр строки поиска
     */
    String inputSearchPrinter();

    /**
     * Метод возвращает параметр seleniumInput из avito_tests_config.properties
     * @return параметр строки поиска
     */
    String inputSearchCity();

    /**
     * Метод возвращает параметр linkAttribute из avito_tests_config.properties
     * @return параметр атрибута ссылки
     */
    String linkAttribute();
}